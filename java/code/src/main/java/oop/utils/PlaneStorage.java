package oop.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class PlaneStorage {
    public static List<Plane> loadFromDB() throws SQLException {
        List<Plane> planes = new ArrayList<>();
        Statement statement = DBManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM planes");
        while (rs.next()) {
            planes.add(new Plane(UUID.fromString(rs.getString("uuid")),
                    rs.getString("name"),
                    rs.getDouble("length"),
                    rs.getDouble("wingspan"),
                    LocalDate.parse(rs.getString("firstFlight")),
                    rs.getString("category")));
        }
        statement.close();
        return planes;
    }

    public static void saveToDB(List<Plane> planes) throws SQLException {
        Statement statement = DBManager.getConnection().createStatement();
        statement.executeUpdate("DROP TABLE IF EXISTS planes");
        statement.executeUpdate("CREATE TABLE planes (uuid VARCHAR(50) PRIMARY KEY, name VARCHAR(50), length REAL, " +
                "wingspan REAL, firstFlight DATE, category VARCHAR(50))");

        for (Plane plane : planes) {
            String sql = String.format("INSERT INTO planes (uuid, name, length, wingspan, firstFlight, category) VALUES " +
                            "('%s', '%s', %f, %f, '%s', '%s')",
                    plane.getUUID(),
                    plane.getName(),
                    plane.getLength(),
                    plane.getWingspan(),
                    plane.getFirstFlight().toString(),
                    plane.getCategory());
            statement.executeUpdate(sql);
        }

        statement.close();
    }

    public static List<Plane> loadFromFile(Path path) throws IOException {
        List<Plane> planes = new ArrayList<>();
        Scanner scanner = new Scanner(path);
        while (scanner.hasNextLine()) {
            String[] fields = scanner.nextLine().split(";");
            planes.add(new Plane(fields[0], Double.parseDouble(fields[1]),
                    Double.parseDouble(fields[2]), LocalDate.parse(fields[3]),
                    fields[4]));
        }
        scanner.close();
        return planes;
    }

    public static void saveToFile(List<Plane> planes, Path path) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Plane plane : planes) {
            lines.add(plane.toCSV());
        }
        Files.write(path, lines);
    }
}
