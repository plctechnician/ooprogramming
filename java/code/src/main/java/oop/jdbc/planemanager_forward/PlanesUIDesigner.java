package oop.jdbc.planemanager_forward;

import oop.utils.DBManager;
import oop.utils.Plane;
import oop.utils.PlaneStorage;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
            String[] v = JOptionPane.showInputDialog(this, "Insert plane (width;height;wings;code)").split(";");
            Plane plane = new Plane(v[0], Double.parseDouble(v[1]), Double.parseDouble(v[2]), LocalDate.parse(v[3]),
                    v[4]);
            planes.add(selected, plane);
            update();
        });

        btRemove.addActionListener(e -> {
            if (planes.isEmpty()) {
                return;
            }
            planes.remove(selected);
            selected = Math.max(0, selected - 1);
            update();
        });

        tfName.addActionListener(e -> getSelected().setName(tfName.getText()));

        tfLength.addActionListener(e -> getSelected().setLength(Double.parseDouble(tfLength.getText())));

        tfWingspan.addActionListener(e -> getSelected().setWingspan(Double.parseDouble(tfWingspan.getText())));

        tfFirstFlight.addActionListener(e -> getSelected().setFirstFlight(LocalDate.parse(tfFirstFlight.getText())));

        cbCategory.addActionListener(e -> getSelected().setCategory(cbCategory.getSelectedItem().toString()));

        JMenuBar menu = generateMenu();
        setJMenuBar(menu);
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(370, 270);
        setResizable(false);
        setVisible(true);

        try {
            DBManager.setConnection(
                    DBManager.JDBC_Driver_SQLite,
                    DBManager.JDBC_URL_SQLite);
            initData(PlaneStorage.loadFromDB());
        } catch (SQLException e) {
            initData();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        update();
    }

    private void initData() {
        planes = new ArrayList<>();
        selected = 0;
    }

    private void initData(List<Plane> l) {
        planes = l;
        selected = 0;
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
                    PlaneStorage.saveToDB(planes);
                    initData(PlaneStorage.loadFromDB());
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
