package oop.jdbc.planemanager_rest;

import kong.unirest.UnirestException;
import oop.utils.Plane;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;

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

        tfName.addActionListener(e -> planes.setName(tfName.getText()));
        tfLength.addActionListener(e -> planes.setLength(Double.parseDouble(tfLength.getText())));
        tfWingspan.addActionListener(e -> planes.setWingspan(Double.parseDouble(tfWingspan.getText())));
        tfFirstFlight.addActionListener(e -> planes.setFirstFlight(LocalDate.parse(tfFirstFlight.getText())));
        cbCategory.addActionListener(e -> planes.setCategory(cbCategory.getSelectedItem().toString()));

        try {
            initData();
            update();
        } catch (UnirestException | IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            setPanelEnabled(mainPanel, false);
        }
    }

    private void initData() throws IOException {
        planes = new PlanesModel();
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
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(e -> dispose());

        JMenu file = new JMenu("File");
        file.add(quit);

        JMenuBar menu = new JMenuBar();
        menu.add(file);
        return menu;
    }
}
