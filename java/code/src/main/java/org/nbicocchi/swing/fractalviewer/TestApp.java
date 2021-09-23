package org.nbicocchi.swing.fractalviewer;

import javax.swing.*;
import java.awt.*;

/**
 * Simple Java program to display the Mandelbrot set.
 **/
public class TestApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Fractal viewer");
            JPanel mandelbrotPanel = new MandelbrotPanel(255);
            frame.setContentPane(mandelbrotPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            frame.setVisible(true);
        });
    }
}
