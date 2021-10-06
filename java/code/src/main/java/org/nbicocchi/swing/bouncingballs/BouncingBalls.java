package org.nbicocchi.swing.bouncingballs;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class BouncingBalls extends JFrame {
    private static final long serialVersionUID = 1L;

    public BouncingBalls() {
        super();
        Properties properties = new Properties();
        properties.setProperty("pause", "off");
        properties.setProperty("fps", "30");

        GamePanel gamePanel = new GamePanel(properties);
        ControlPanel controlPanel = new ControlPanel(properties);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(gamePanel, BorderLayout.CENTER);
        contentPane.add(controlPanel, BorderLayout.SOUTH);
        setSize(600, 400);
        setVisible(true);

        Thread t = new Thread(gamePanel);
        t.start();
    }
}

