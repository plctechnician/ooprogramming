package org.nbicocchi.swing.bouncingballs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GamePanel extends JPanel implements ActionListener {
    private final Properties properties;
    private List<Ball> balls;
    private Timer timer;

    public GamePanel(Properties properties) {
        super();
        this.properties = properties;
    }

    public void init() {
        // generate balls
        balls = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(properties.getProperty("balls")); i++) {
            balls.add(new Ball(getWidth(), getHeight()));
        }

        // start timer
        int delay = 1000 / Integer.parseInt(properties.getProperty("fps"));
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawString("FPS:" + properties.getProperty("fps"), 4, 14);
        for (Ball ball : balls) {
            ball.paintComponent(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {

            // eventually update fps
            int delay = 1000 / Integer.parseInt(properties.getProperty("fps"));
            timer = new Timer(delay, this);
            timer.start();

            // pause
            if (properties.getProperty("pause").equals("on")) {
                return;
            }

            // main loop
            for (Ball ball : balls) {
                if (ball.collideHorizontalWall(new Dimension(getWidth(), getHeight()))) {
                    ball.velocity.y = -ball.velocity.y;
                }
                if (ball.collideVerticalWall(new Dimension(getWidth(), getHeight()))) {
                    ball.velocity.x = -ball.velocity.x;
                }
                for (Ball other : balls) {
                    if ((ball != other) && (ball.collideBall(other))) {
                        ball.revolve(other);
                    }
                }
                ball.move();
            }
            repaint();
        }
    }
}