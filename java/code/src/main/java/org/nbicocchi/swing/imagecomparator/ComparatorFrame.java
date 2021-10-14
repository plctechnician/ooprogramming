package org.nbicocchi.swing.imagecomparator;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.HashMap;

public class ComparatorFrame extends JFrame implements ActionListener, PropertyChangeListener {
    private static final long serialVersionUID = 1L;
    private final ComparatorPanel firstImagePanel;
    private final ComparatorPanel secondImagePanel;
    private final JProgressBar progressBar;
    private final HashMap<String, ImageComparator> comparators;
    private ImageComparator comparator;

    public ComparatorFrame() {
        super("Image Comparator");

        // create available comparators
        comparators = new HashMap<>();
        comparators.put("Binary", new ImageComparatorBinary());
        comparators.put("Standard", new ImageComparatorStandard());

        generateMenu();

        firstImagePanel = new ComparatorPanel();
        secondImagePanel = new ComparatorPanel();
        progressBar = new JProgressBar();

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        p.add(new JScrollPane(firstImagePanel));
        p.add(new JScrollPane(secondImagePanel));

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(p, BorderLayout.CENTER);
        contentPane.add(progressBar, BorderLayout.SOUTH);

        setSize(1024, 768);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void generateMenu() {
        JMenuItem fileFirst = new JMenuItem("Open First...");
        fileFirst.addActionListener(this);

        JMenuItem fileSecond = new JMenuItem("Open Second...");
        fileSecond.addActionListener(this);

        JMenuItem fileCompare = new JMenuItem("Compare...");
        fileCompare.addActionListener(this);

        JMenuItem fileQuit = new JMenuItem("Quit");
        fileQuit.addActionListener(this);

        JMenu file = new JMenu("File");
        file.add(fileFirst);
        file.add(fileSecond);
        file.add(fileCompare);
        file.add(fileQuit);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(file);

        setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Open First...")) {
            JFileChooser open = new JFileChooser();
            int option = open.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    firstImagePanel.setImage(ImageIO.read(open.getSelectedFile()));
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(this, "Something went wrong...");
                }
            }
        }

        if (e.getActionCommand().equals("Open Second...")) {
            JFileChooser open = new JFileChooser();
            int option = open.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    secondImagePanel.setImage(ImageIO.read(open.getSelectedFile()));
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(this, "Something went wrong...");
                }
            }
        }

        if (e.getActionCommand().equals("Compare...")) {
            String selection = (String) JOptionPane.showInputDialog(
                    this,
                    null,
                    "Select Comparator",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    comparators.keySet().toArray(),
                    comparators.keySet().toArray()[0]);

            comparator = comparators.get(selection);
            comparator.setImages(firstImagePanel.getImage(), secondImagePanel.getImage());
            comparator.removeAllPropertyChangeListener();
            comparator.addPropertyChangeListener(this);
            Thread t = new Thread(comparator);
            t.start();
        }

        if (e.getActionCommand().equals("Quit")) {
            dispose();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("completed")) {
            int percent = (Integer) evt.getNewValue();
            progressBar.setValue(percent);
            if (percent == 100) {
                JOptionPane.showMessageDialog(this,
                        "Similarity = " + comparator.getSimilarity() +
                                "; Coverage = " + comparator.getCoverage());
            }
        }
    }
}
