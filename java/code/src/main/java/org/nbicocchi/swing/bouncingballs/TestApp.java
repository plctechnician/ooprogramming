package org.nbicocchi.swing.bouncingballs;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class TestApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fractal Viewer");

        Properties properties = new Properties();
        properties.setProperty("pause", "off");
        properties.setProperty("fps", "30");
        properties.setProperty("balls", "15");

        GamePanel gamePanel = new GamePanel(properties);
        ControlPanel controlPanel = new ControlPanel(properties);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(gamePanel, BorderLayout.CENTER);
        contentPane.add(controlPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);

        gamePanel.init();
    }
}
