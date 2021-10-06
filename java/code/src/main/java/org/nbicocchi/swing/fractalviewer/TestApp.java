package org.nbicocchi.swing.fractalviewer;

import javax.swing.*;

public class TestApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fractal viewer");
        frame.setContentPane(new MandelbrotPanel(255));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.invalidate();
    }
}
