package oop.rest.jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import oop.utils.DBManager;
import oop.utils.Plane;
import oop.utils.PlaneStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static spark.Spark.*;

public class JDBCServer {
    static Logger logger = LoggerFactory.getLogger(JDBCServer.class);
    ObjectMapper mapper;

    public void run() {
        mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        mapper.findAndRegisterModules();

        try {
            dbConnection();
        } catch (IOException|SQLException e) {
            e.printStackTrace();
        }

        // Start embedded server at this port
        port(8080);

        // Configure resources

        // POST - Add new
        // For testing:
        // curl -X POST -d name=xyz -d length=1.0 -d wingspan=1.0 -d firstFlight=2020-01-01 -d category=Airliner
        // http://localhost:8080/plane/add
        post("/plane/add", (request, response) -> {
            String name = request.queryParams("name");
            double length = Double.parseDouble(request.queryParams("length"));
            double wingspan = Double.parseDouble(request.queryParams("wingspan"));
            LocalDate firstFlight = LocalDate.parse(request.queryParams("firstFlight"));
            String category = request.queryParams("category");

            Plane plane = new Plane(name, length, wingspan, firstFlight, category);
            String sql = String.format("INSERT INTO planes (uuid, name, length, wingspan, firstFlight, category) VALUES ('%s', '%s', %f, %f, '%s', '%s')",
                    plane.getUUID(),
                    plane.getName(),
                    plane.getLength(),
                    plane.getWingspan(),
                    plane.getFirstFlight().toString(),
                    plane.getCategory());
            executeUpdate(sql);
            response.status(201);
            return mapper.writeValueAsString(plane);
        });

        // PUT - Update
        // For testing: curl -X PUT -d name=abc -d length=1.0 -d wingspan=1.0 -d firstFlight=2000-01-01 -d
        // category=Airliner http://localhost:8080/plane/e2956180-4cb5-4ab4...
        put("/plane/:id", (request, response) -> {
            UUID uuid = UUID.fromString(request.params(":id"));
            String name = request.queryParams("name");
            double length = Double.parseDouble(request.queryParams("length"));
            double wingspan = Double.parseDouble(request.queryParams("wingspan"));
            LocalDate firstFlight = LocalDate.parse(request.queryParams("firstFlight"));
            String category = request.queryParams("category");

            if (!isUUIDAvailable(uuid)) {
                response.status(404);
                return mapper.writeValueAsString("{status: failed}");
            }

            Plane plane = new Plane(uuid, name, length, wingspan, firstFlight, category);
            String sql = String.format(
                    "UPDATE planes SET name='%s', length=%f, wingspan=%f, firstFlight='%s', category='%s' WHERE uuid " +
                            "= '%s'",
                    plane.getName(),
                    plane.getLength(),
                    plane.getWingspan(),
                    plane.getFirstFlight().toString(),
                    plane.getCategory(),
                    plane.getUUID());
            executeUpdate(sql);
            return mapper.writeValueAsString(plane);
        });

        // DELETE - delete
        // For testing:
        // curl -X DELETE http://localhost:8080/plane/e2956180-4cb5-4ab4...
        delete("/plane/:id", (request, response) -> {
            UUID uuid = UUID.fromString(request.params(":id"));

            if (!isUUIDAvailable(uuid)) {
                response.status(404);
                return mapper.writeValueAsString("{status: failed}");
            }

            String sql = String.format("DELETE FROM planes WHERE uuid = '%s'", uuid);
            executeUpdate(sql);
            return mapper.writeValueAsString("{status: ok}");
        });

        // GET - get all
        // For testing: curl -X GET http://localhost:8080/plane
        get("/plane", (request, response) -> {
            String sql = "SELECT * FROM planes";
            Statement statement = DBManager.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);

            List<Plane> planes = new ArrayList<>();
            while (rs.next()) {
                planes.add(new Plane(UUID.fromString(rs.getString("uuid")),
                        rs.getString("name"),
                        rs.getDouble("length"),
                        rs.getDouble("wingspan"),
                        LocalDate.parse(rs.getString("firstFlight")),
                        rs.getString("category")));
            }
            statement.close();
            return mapper.writeValueAsString(planes);
        });

        // GET - get by length
        // For testing:
        // curl -X GET "http://localhost:8080/plane/bylength?min=30&max=40"
        get("/plane/bylength", (request, response) -> {
            String min = request.queryParams("min");
            String max = request.queryParams("max");

            String sql = String.format("SELECT * FROM planes WHERE length BETWEEN %s AND %s ORDER BY length", min,
                    max);
            Statement statement = DBManager.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            List<Plane> planes = new ArrayList<>();
            while (rs.next()) {
                planes.add(new Plane(UUID.fromString(rs.getString("uuid")),
                        rs.getString("name"),
                        rs.getDouble("length"),
                        rs.getDouble("wingspan"),
                        LocalDate.parse(rs.getString("firstFlight")),
                        rs.getString("category")));
            }
            statement.close();
            return mapper.writeValueAsString(planes);
        });

        // GET - get by id
        // For testing:
        // curl -X GET "http://localhost:8080/plane/e2956180-4cb5-4ab4..."
        get("/plane/:id", (request, response) -> {
            UUID uuid = UUID.fromString(request.params(":id"));

            if (!isUUIDAvailable(uuid)) {
                response.status(404);
                return mapper.writeValueAsString("{status: failed}");
            }

            String sql = String.format("SELECT * FROM planes WHERE uuid = '%s'", uuid);
            Statement statement = DBManager.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            Plane plane = new Plane(UUID.fromString(rs.getString("uuid")),
                    rs.getString("name"),
                    rs.getDouble("length"),
                    rs.getDouble("wingspan"),
                    LocalDate.parse(rs.getString("firstFlight")),
                    rs.getString("category"));
            statement.close();
            return mapper.writeValueAsString(plane);
        });
    }

    private void executeUpdate(String sql) throws SQLException {
        Statement statement = DBManager.getConnection().createStatement();
        statement.executeUpdate(sql);
        statement.close();
    }

    private boolean isUUIDAvailable(UUID uuid) throws SQLException {
        String sql = String.format("SELECT * FROM planes WHERE uuid = '%s'", uuid);
        Statement statement = DBManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql);
        boolean isUUIDAvailable = rs.next();
        rs.close();
        return isUUIDAvailable;
    }

    private void dbConnection() throws SQLException, IOException {
        List<Plane> planes =
                PlaneStorage.loadFromFile(new File("java/code/src/main/resources/text/planes.csv").toPath());

        DBManager.setConnection(
                DBManager.JDBC_Driver_SQLite,
                DBManager.JDBC_URL_SQLite);
        Statement statement = DBManager.getConnection().createStatement();
        PlaneStorage.saveToDB(planes, statement);
        statement.close();
    }

    public static void main(String[] args) {
        new JDBCServer().run();
    }
}