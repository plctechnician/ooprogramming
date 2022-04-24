package oop.jdbc.planemanager_forward;

import oop.utils.DBManager;
import oop.utils.Plane;
import oop.utils.PlaneStorage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PlanesUIDesigner extends JFrame {
    private JPanel mainPanel;
    private JButton btPrevious;
    private JButton btNext;
    private JButton btInsert;
    private JButton btRemove;
    private JTextField tfName;
    private JTextField tfLength;
    private JTextField tfWingspan;
    private JTextField tfFirstFlight;
    private JComboBox<String> cbCategory;
    private List<Plane> planes;
    private int selected;

    public PlanesUIDesigner() {
        super();

        btPrevious.addActionListener(e -> {
            selected = Math.max(0, selected - 1);
            update();
        });

        btNext.addActionListener(e -> {
            selected = Math.min(planes.size() - 1, selected + 1);
            update();
        });

        btInsert.addActionListener(e -> {
            String[] v = JOptionPane.showInputDialog(this, "Insert plane (name, length, wingspan, firstFlight, category)").split(";");
            Plane plane = new Plane(v[0], Double.parseDouble(v[1]), Double.parseDouble(v[2]), LocalDate.parse(v[3]), v[4]);

            try (PreparedStatement insertPlane = DBManager.getConnection().prepareStatement(
                    "INSERT INTO planes (uuid, name, length, wingspan, firstFlight, category) VALUES (?, ?, ?, ?, ?, ?)")) {
                insertPlane.setString(1, plane.getUUID().toString());
                insertPlane.setString(2, plane.getName());
                insertPlane.setDouble(3, plane.getLength());
                insertPlane.setDouble(4, plane.getWingspan());
                insertPlane.setDate(5, Date.valueOf(plane.getFirstFlight()));
                insertPlane.setString(6, plane.getCategory());
                insertPlane.executeUpdate();
                planes.add(plane);
                selected = planes.size() - 1;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            update();
        });

        btRemove.addActionListener(e -> {
            if (planes.isEmpty()) {
                return;
            }

            try (PreparedStatement deletePlane = DBManager.getConnection().prepareStatement(
                    "DELETE FROM planes WHERE uuid=?")) {
                deletePlane.setString(1, getSelected().getUUID().toString());
                deletePlane.executeUpdate();
                planes.remove(selected);
                selected = Math.max(0, selected - 1);
            } catch (IndexOutOfBoundsException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            update();
        });

        tfName.addActionListener(e -> {
            try (PreparedStatement updatePlane = DBManager.getConnection().prepareStatement(
                    "UPDATE planes SET name=? WHERE uuid=?")) {
                updatePlane.setString(1, tfName.getText());
                updatePlane.setString(2, getSelected().getUUID().toString());
                updatePlane.executeUpdate();
                getSelected().setName(tfName.getText());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        tfLength.addActionListener(e -> {
            try (PreparedStatement updatePlane = DBManager.getConnection().prepareStatement(
                    "UPDATE planes SET length=? WHERE uuid=?")) {
                updatePlane.setDouble(1, Double.parseDouble(tfLength.getText()));
                updatePlane.setString(2, getSelected().getUUID().toString());
                updatePlane.executeUpdate();
                getSelected().setLength(Double.parseDouble(tfLength.getText()));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        tfWingspan.addActionListener(e -> {
            try (PreparedStatement updatePlane = DBManager.getConnection().prepareStatement(
                    "UPDATE planes SET wingspan=? WHERE uuid=?")) {
                updatePlane.setDouble(1, Double.parseDouble(tfWingspan.getText()));
                updatePlane.setString(2, getSelected().getUUID().toString());
                updatePlane.executeUpdate();
                getSelected().setWingspan(Double.parseDouble(tfWingspan.getText()));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        tfFirstFlight.addActionListener(e -> {
            try (PreparedStatement updatePlane = DBManager.getConnection().prepareStatement(
                    "UPDATE planes SET firstFlight=? WHERE uuid=?")) {
                updatePlane.setDate(1, Date.valueOf(tfFirstFlight.getText()));
                updatePlane.setString(2, getSelected().getUUID().toString());
                updatePlane.executeUpdate();
                getSelected().setFirstFlight(LocalDate.parse(tfFirstFlight.getText()));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cbCategory.addActionListener(e -> {
            try (PreparedStatement updatePlane = DBManager.getConnection().prepareStatement(
                    "UPDATE planes SET category=? WHERE uuid=?")) {
                updatePlane.setString(1, cbCategory.getSelectedItem().toString());
                updatePlane.setString(2, getSelected().getUUID().toString());
                updatePlane.executeUpdate();
                getSelected().setCategory(cbCategory.getSelectedItem().toString());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        try {
            DBManager.setConnection(
                    DBManager.JDBC_Driver_SQLite,
                    DBManager.JDBC_URL_SQLite);
            List<Plane> planes = PlaneStorage.loadFromDB(DBManager.getConnection());
            initData(planes);
            setPanelEnabled(mainPanel, true);
            update();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            setPanelEnabled(mainPanel, false);
        }

        JMenuBar menu = generateMenu();
        setJMenuBar(menu);
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(370, 270);
        setResizable(false);
        setVisible(true);
    }

    private void initData(List<Plane> l) {
        planes = l;
        selected = 0;
    }

    void setPanelEnabled(JPanel panel, Boolean isEnabled) {
        panel.setEnabled(isEnabled);
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                setPanelEnabled((JPanel) component, isEnabled);
            }
            component.setEnabled(isEnabled);
        }
    }

    private void update() {
        Plane plane = getSelected();
        if (plane == null) {
            tfName.setText("");
            tfLength.setText("");
            tfWingspan.setText("");
            tfFirstFlight.setText("");
            cbCategory.setSelectedIndex(0);
        } else {
            tfName.setText(plane.getName());
            tfLength.setText(Double.toString(plane.getLength()));
            tfWingspan.setText(Double.toString(plane.getWingspan()));
            tfFirstFlight.setText(plane.getFirstFlight().toString());
            cbCategory.setSelectedItem(plane.getCategory());
        }
    }

    private Plane getSelected() {
        if (!planes.isEmpty()) {
            return planes.get(selected);
        }
        return null;
    }

    private JMenuBar generateMenu() {
        JMenuItem fill = new JMenuItem("Fill DB...");
        JMenuItem quit = new JMenuItem("Quit");
        JMenu file = new JMenu("File");
        file.add(fill);
        file.add(quit);
        JMenuBar menu = new JMenuBar();
        menu.add(file);
        fill.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int option = chooser.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    List<Plane> planes = PlaneStorage.loadFromFile(chooser.getSelectedFile().toPath());
                    PlaneStorage.saveToDB(planes, DBManager.getConnection());
                    initData(planes);
                    setPanelEnabled(mainPanel, true);
                    update();
                } catch (IOException|SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        quit.addActionListener(e -> {
            try {
                DBManager.close();
            } catch (SQLException ignored) {}
            dispose();
        });
        return menu;
    }
}
