package oop.rest.jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import oop.utils.DBManager;
import oop.utils.Plane;
import oop.utils.PlaneStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static spark.Spark.*;

public class JDBCServer {
    static final String SUCCESS = "{status: ok}";
    static final String FAILURE = "{status: failed}";
    static Logger logger = LoggerFactory.getLogger(JDBCServer.class);
    ObjectMapper mapper;

    private boolean isUUIDAvailable(UUID uuid) throws SQLException {
        boolean isUUIDAvailable;
        try (PreparedStatement statement = DBManager.getConnection().prepareStatement("SELECT * FROM planes WHERE uuid=?")) {
            statement.setString(1, uuid.toString());
            try (ResultSet rs = statement.executeQuery()) {
                isUUIDAvailable = rs.next();
            }
            return isUUIDAvailable;
        }
    }

    public void run() {
        mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        mapper.findAndRegisterModules();

        // Start embedded server at this port
        port(8080);

        // POST - Add new
        // curl -X POST -d name=xyz -d length=1.0 -d wingspan=1.0 -d firstFlight=2020-01-01 -d category=Airliner
        // http://localhost:8080/plane/add
        post("/plane/add", (request, response) -> {
            try (PreparedStatement statement = DBManager.getConnection().prepareStatement(
                    "INSERT INTO planes (uuid, name, length, wingspan, firstFlight, category) VALUES (?, ?, ?, ?, ?, ?)")) {
                statement.setString(1, UUID.randomUUID().toString());
                statement.setString(2, request.queryParams("name"));
                statement.setDouble(3, Double.parseDouble(request.queryParams("length")));
                statement.setDouble(4, Double.parseDouble(request.queryParams("wingspan")));
                statement.setDate(5, Date.valueOf(request.queryParams("firstFlight")));
                statement.setString(6, request.queryParams("category"));
                statement.executeUpdate();
            }
            return mapper.writeValueAsString(SUCCESS);
        });

        // PUT - Update
        // curl -X PUT -d name=abc -d length=1.0 -d wingspan=1.0 -d firstFlight=2000-01-01 -d
        // category=Airliner http://localhost:8080/plane/e2956180-4cb5-4ab4...
        put("/plane/:id", (request, response) -> {
            UUID uuid = UUID.fromString(request.params(":id"));
            if (!isUUIDAvailable(uuid)) {
                response.status(404);
                return mapper.writeValueAsString(FAILURE);
            }

            try (PreparedStatement statement = DBManager.getConnection().prepareStatement(
                    "UPDATE planes SET name=?, length=?, wingspan=?, firstFlight=?, category=? WHERE uuid=?")) {
                statement.setString(1, request.queryParams("name"));
                statement.setDouble(2, Double.parseDouble(request.queryParams("length")));
                statement.setDouble(3, Double.parseDouble(request.queryParams("wingspan")));
                statement.setDate(4, Date.valueOf(request.queryParams("firstFlight")));
                statement.setString(5, request.queryParams("category"));
                statement.setString(1, uuid.toString());
                statement.executeUpdate();
            }
            return mapper.writeValueAsString(SUCCESS);
        });

        // DELETE - delete
        // curl -X DELETE http://localhost:8080/plane/e2956180-4cb5-4ab4...
        delete("/plane/:id", (request, response) -> {
            UUID uuid = UUID.fromString(request.params(":id"));
            if (!isUUIDAvailable(uuid)) {
                response.status(404);
                return mapper.writeValueAsString(FAILURE);
            }

            try (PreparedStatement statement = DBManager.getConnection().prepareStatement(
                    "DELETE FROM planes WHERE uuid=?")) {
                statement.setString(1, uuid.toString());
                statement.executeUpdate();
            }
            return mapper.writeValueAsString(SUCCESS);
        });

        // GET - get all
        // curl -X GET http://localhost:8080/plane
        get("/plane", (request, response) -> {
            List<Plane> planes = new ArrayList<>();
            try (PreparedStatement statement = DBManager.getConnection().prepareStatement(
                    "SELECT * FROM planes")) {
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        planes.add(new Plane(UUID.fromString(rs.getString("uuid")), rs.getString("name"), rs.getDouble("length"), rs.getDouble("wingspan"), PlaneStorage.convertSQLDateToLocalDate(rs.getDate("firstFlight")), rs.getString("category")));
                    }
                }
            }
            return mapper.writeValueAsString(planes);
        });

        // GET - get by length
        // curl -X GET "http://localhost:8080/plane/length?min=30&max=40"
        get("/plane/length", (request, response) -> {
            List<Plane> planes = new ArrayList<>();
            try (PreparedStatement statement = DBManager.getConnection().prepareStatement(
                    "SELECT * FROM planes WHERE length BETWEEN ? AND ? ORDER BY length")) {
                statement.setString(1, request.queryParams("min"));
                statement.setString(2, request.queryParams("max"));
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        planes.add(new Plane(UUID.fromString(rs.getString("uuid")),
                                rs.getString("name"),
                                rs.getDouble("length"),
                                rs.getDouble("wingspan"),
                                PlaneStorage.convertSQLDateToLocalDate(rs.getDate("firstFlight")),
                                rs.getString("category")));
                    }
                }
            }
            return mapper.writeValueAsString(planes);
        });

        // GET - get by id
        // curl -X GET "http://localhost:8080/plane/e2956180-4cb5-4ab4..."
        get("/plane/:id", (request, response) -> {
            UUID uuid = UUID.fromString(request.params(":id"));
            if (!isUUIDAvailable(uuid)) {
                response.status(404);
                return mapper.writeValueAsString(FAILURE);
            }

            Plane plane;
            try (PreparedStatement statement = DBManager.getConnection().prepareStatement(
                    "SELECT * FROM planes WHERE uuid=?")) {
                statement.setString(1, uuid.toString());
                try (ResultSet rs = statement.executeQuery()) {
                    plane = new Plane(UUID.fromString(rs.getString("uuid")),
                            rs.getString("name"),
                            rs.getDouble("length"),
                            rs.getDouble("wingspan"),
                            PlaneStorage.convertSQLDateToLocalDate(rs.getDate("firstFlight")),
                            rs.getString("category"));
                }
            }
            return mapper.writeValueAsString(plane);
        });
    }

    public static void main(String[] args) throws IOException, SQLException {
        DBManager.setConnection(
                DBManager.JDBC_Driver_SQLite,
                DBManager.JDBC_URL_SQLite);
        String planesPath = "java/code/src/main/resources/text/planes.csv";
        List<Plane> planes = PlaneStorage.loadFromFile(Path.of(planesPath));
        PlaneStorage.saveToDB(planes, DBManager.getConnection());
        new JDBCServer().run();
    }
}