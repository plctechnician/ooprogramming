package oop.swing;

import javax.swing.*;
import java.awt.*;

public class LayoutManager extends JFrame {
    public LayoutManager() {
        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(new JButton("A"), BorderLayout.PAGE_START);
        p1.add(new JButton("B"), BorderLayout.LINE_END);
        p1.add(new JButton("C"), BorderLayout.CENTER);
        p1.add(new JButton("D"), BorderLayout.LINE_START);
        p1.add(new JButton("E"), BorderLayout.PAGE_END);

        JPanel p2 = new JPanel(new GridLayout(3, 2));
        p2.add(new JButton("F"));
        p2.add(new JButton("G"));
        p2.add(new JButton("H"));
        p2.add(new JButton("I"));
        p2.add(new JButton("J"));
        p2.add(new JButton("K"));

        JPanel p3 = new JPanel(new GridLayout(5, 1));
        p3.add(new JButton("L"));
        p3.add(new JButton("M"));
        p3.add(new JButton("N"));
        p3.add(new JButton("O"));
        p3.add(new JButton("P"));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(p1, BorderLayout.CENTER);
        mainPanel.add(p2, BorderLayout.PAGE_END);
        mainPanel.add(p3, BorderLayout.LINE_END);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LayoutManager::new);
    }
}