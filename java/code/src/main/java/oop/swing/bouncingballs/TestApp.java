package oop.swing.bouncingballs;

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

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(gamePanel, BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.AFTER_LAST_LINE);

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);

        gamePanel.init();
    }
}
