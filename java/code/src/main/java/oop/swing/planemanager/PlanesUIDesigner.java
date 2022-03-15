package oop.swing.planemanager;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlanesUIDesigner extends JFrame {
    private JPanel mainPanel;
    private JButton btPrevious;
    private JButton btNext;
    private JButton btInsert;
    private JButton btRemove;
    private JTextField tfWidth;
    private JTextField tfHeight;
    private JTextField tfWingSpan;
    private JTextField tfCode;
    private List<Plane> planes;
    private int selected;

    public PlanesUIDesigner() {
        super();

        initData();

        btPrevious.addActionListener(e -> {
            selected = Math.max(0, selected - 1);
            setData();
        });

        btNext.addActionListener(e -> {
            selected = Math.min(planes.size() - 1, selected + 1);
            setData();
        });

        btInsert.addActionListener(e -> {
            String[] v = JOptionPane.showInputDialog(this, "Insert plane (width;height;wings;code)").split(";");
            Plane plane = new Plane(Double.parseDouble(v[0]), Double.parseDouble(v[1]), Double.parseDouble(v[2]), v[3]);
            planes.add(selected, plane);
            setData();
        });

        btRemove.addActionListener(e -> {
            if (planes.isEmpty()) {
                return;
            }
            planes.remove(selected);
            selected = Math.max(0, selected - 1);
            setData();
        });

        tfWidth.addActionListener(e -> getSelected().setWidth(Double.parseDouble(tfWidth.getText())));

        tfHeight.addActionListener(e -> getSelected().setHeight(Double.parseDouble(tfHeight.getText())));

        tfWingSpan.addActionListener(e -> getSelected().setWingSpan(Double.parseDouble(tfWingSpan.getText())));

        tfCode.addActionListener(e -> getSelected().setCode(tfCode.getText()));

        JMenuBar jmenu = generateMenu();
        setJMenuBar(jmenu);
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 250);
        setResizable(false);
        setVisible(true);
    }

    private void initData() {
        planes = new ArrayList<>();
        selected = 0;
    }

    private void initData(List<Plane> l) {
        planes = l;
        selected = 0;
    }

    private void setData() {
        Plane plane = getSelected();
        if (plane == null) {
            tfWidth.setText("");
            tfHeight.setText("");
            tfWingSpan.setText("");
            tfCode.setText("");
        } else {
            tfWidth.setText(Double.toString(plane.getWidth()));
            tfHeight.setText(Double.toString(plane.getHeight()));
            tfWingSpan.setText(Double.toString(plane.getWingSpan()));
            tfCode.setText(plane.getCode());
        }
    }

    private Plane getSelected() {
        if (!planes.isEmpty()) {
            return planes.get(selected);
        }
        return null;
    }

    private JMenuBar generateMenu() {
        JMenuItem open = new JMenuItem("Open...");
        JMenuItem save = new JMenuItem("Save...");
        JMenuItem quit = new JMenuItem("Quit");
        JMenu file = new JMenu("File");
        file.add(open);
        file.add(save);
        file.add(quit);
        JMenuBar menu = new JMenuBar();
        menu.add(file);
        open.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int option = chooser.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    initData(PlaneStorage.load(chooser.getSelectedFile().toPath()));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Reading file failed!");
                }
                setData();
            }
        });
        save.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int option = chooser.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    PlaneStorage.save(planes, chooser.getSelectedFile().toPath());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Writing file failed!");
                }
            }
        });
        quit.addActionListener(e -> dispose());
        return menu;
    }
}
