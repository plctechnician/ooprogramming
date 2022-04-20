package oop.jdbc.planemanager_updatable_model;

import oop.utils.DBManager;
import oop.utils.Plane;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.UUID;

public class PlanesModel {
    ResultSet planes;

    public PlanesModel(Statement statement) throws SQLException {
        planes = statement.executeQuery("SELECT * FROM planes");
        planes.first();
    }

    public Plane getSelected() {
        try {
            return new Plane(UUID.fromString(planes.getString("uuid")),
                    planes.getString("name"),
                    planes.getDouble("length"),
                    planes.getDouble("wingspan"),
                    LocalDate.parse(planes.getString("firstFlight")),
                    planes.getString("category"));
        } catch (SQLException e) {
            return null;
        }
    }

    public void first() {
        try {
            planes.first();
        } catch (SQLException ignored) {}
    }

    public void last() {
        try {
            planes.last();
        } catch (SQLException ignored) {}
    }

    public void next() {
        try {
            if (!planes.isLast())
                planes.next();
        } catch (SQLException ignored) {}
    }

    public void previous() {
        try {
            if (!planes.isFirst())
                planes.previous();
        } catch (SQLException ignored) {}
    }

    public void insert(Plane plane) {
        try {
            planes.moveToInsertRow();
            planes.updateString("uuid", plane.getUUID().toString());
            planes.updateString("name", plane.getName());
            planes.updateDouble("length", plane.getLength());
            planes.updateDouble("wingspan", plane.getWingspan());
            planes.updateDate("firstFlight", Date.valueOf(plane.getFirstFlight()));
            planes.updateString("category", plane.getCategory());
            planes.insertRow();
            planes.last();
        } catch (SQLException ignored) {}
    }

    public void remove() {
        try {
            planes.deleteRow();
            next();
        } catch (SQLException ignored) {}
    }

    public void setName(String name) {
        try {
            planes.updateString("name", name);
            planes.updateRow();
        } catch (SQLException ignored) {}
    }

    public void setLength(double length) {
        try {
            planes.updateDouble("length", length);
            planes.updateRow();
        } catch (SQLException ignored) {}
    }

    public void setWingspan(double wingspan) {
        try {
            planes.updateDouble("wingspan", wingspan);
            planes.updateRow();
        } catch (SQLException ignored) {}
    }

    public void setFirstFlight(Date firstFlight) {
        try {
            planes.updateDate("firstFlight", firstFlight);
            planes.updateRow();
        } catch (SQLException ignored) {}
    }

    public void setCategory(String category) {
        try {
            planes.updateString("category", category);
            planes.updateRow();
        } catch (SQLException ignored) {}
    }
}
