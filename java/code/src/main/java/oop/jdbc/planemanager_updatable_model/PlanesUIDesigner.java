package oop.jdbc.planemanager_updatable_model;

import oop.utils.DBManager;
import oop.utils.Plane;
import oop.utils.PlaneStorage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private PlanesModel planes;

    public PlanesUIDesigner() {
        super();

        JMenuBar menu = generateMenu();
        setJMenuBar(menu);
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(370, 270);
        setResizable(false);
        setVisible(true);

        btPrevious.addActionListener(e -> {
            planes.previous();
            update();
        });

        btNext.addActionListener(e -> {
            planes.next();
            update();
        });

        btInsert.addActionListener(e -> {
            String[] v = JOptionPane.showInputDialog(this, "Insert plane (name, length, wingspan, firstFlight, category)").split(";");
            Plane plane = new Plane(v[0], Double.parseDouble(v[1]), Double.parseDouble(v[2]), LocalDate.parse(v[3]), v[4]);
            planes.insert(plane);
            update();
        });

        btRemove.addActionListener(e -> {
            planes.remove();
            update();
        });

        tfName.addActionListener(e -> {
            planes.setName(tfName.getText());
        });

        tfLength.addActionListener(e -> {
            planes.setLength(Double.parseDouble(tfLength.getText()));
        });

        tfWingspan.addActionListener(e -> {
            planes.setWingspan(Double.parseDouble(tfWingspan.getText()));
        });

        tfFirstFlight.addActionListener(e -> {
            planes.setFirstFlight(Date.valueOf(tfFirstFlight.getText()));
        });

        cbCategory.addActionListener(e -> {
            planes.setCategory(cbCategory.getSelectedItem().toString());
        });

        try {
            initData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        update();
    }

    private void initData() throws SQLException {
        DBManager.setConnection(
                DBManager.JDBC_Driver_MySQL,
                DBManager.JDBC_URL_MySQL);
        Statement statement = DBManager.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        planes = new PlanesModel(statement);
    }

    private void update() {
        Plane plane = planes.getSelected();
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
                    Statement statement = DBManager.getConnection().createStatement();
                    List<Plane> planes = PlaneStorage.loadFromFile(chooser.getSelectedFile().toPath());
                    PlaneStorage.saveToDB(planes, statement);
                    initData();
                    statement.close();
                } catch (IOException|SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                update();
            }
        });
        quit.addActionListener(e -> dispose());
        return menu;
    }
}
