package oop.jdbc.planemanager_updatable;

import oop.utils.DBManager;
import oop.utils.Plane;
import oop.utils.PlaneStorage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
    private ResultSet planes;

    public PlanesUIDesigner() {
        super();

        btPrevious.addActionListener(e -> {
            try {
                if (!planes.isFirst())
                    planes.previous();
            } catch (SQLException ignored) {}
            update();
        });

        btNext.addActionListener(e -> {
            try {
                if (!planes.isLast())
                    planes.next();
            } catch (SQLException ignored) {}
            update();
        });

        btInsert.addActionListener(e -> {
            String[] v = JOptionPane.showInputDialog(this, "Insert plane (name, length, wingspan, firstFlight, category)").split(";");
            Plane plane = new Plane(v[0], Double.parseDouble(v[1]), Double.parseDouble(v[2]), LocalDate.parse(v[3]), v[4]);

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
            update();
        });

        btRemove.addActionListener(e -> {
            try {
                planes.deleteRow();
            } catch (SQLException ignored) {}
            update();
        });

        tfName.addActionListener(e -> {
            try {
                planes.updateString("name", tfName.getText());
                planes.updateRow();
            } catch (SQLException ignored) {}
        });

        tfLength.addActionListener(e -> {
            try {
                planes.updateDouble("length", Double.parseDouble(tfLength.getText()));
                planes.updateRow();
            } catch (SQLException ignored) {}
        });

        tfWingspan.addActionListener(e -> {
            try {
                planes.updateDouble("wingspan", Double.parseDouble(tfWingspan.getText()));
                planes.updateRow();
            } catch (SQLException ignored) {}
        });

        tfFirstFlight.addActionListener(e -> {
            try {
                planes.updateDate("firstFlight", Date.valueOf(tfFirstFlight.getText()));
                planes.updateRow();
            } catch (SQLException ignored) {}
        });

        cbCategory.addActionListener(e -> {
            try {
                planes.updateString("category", cbCategory.getSelectedItem().toString());
                planes.updateRow();
            } catch (SQLException ignored) {}
        });

        JMenuBar menu = generateMenu();
        setJMenuBar(menu);
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(370, 270);
        setResizable(false);
        setVisible(true);

        try {
            initData();
            update();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            setPanelEnabled(mainPanel,false);
        }
    }

    private void initData() throws SQLException {
        DBManager.setConnection(
                DBManager.JDBC_Driver_MySQL,
                DBManager.JDBC_URL_MySQL);
        PreparedStatement statement = DBManager.getConnection().prepareStatement(
                "SELECT * FROM planes",
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        planes = statement.executeQuery();
        planes.first();
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
                    initData();
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
