package org.nbicocchi.swing.bouncingballs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GamePanel extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
    private static final int maxBalls = 15;
    private final Properties properties;
    private final List<Ball> balls;

    public GamePanel(Properties properties) {
        super();
        this.properties = properties;
        this.balls = new ArrayList<>();
    }

    @Override
    public void run() {
        long sleepTime, skipTicks, nextTick = System.nanoTime();

        // generate balls
        for (int i = 0; i < maxBalls; i++) {
            balls.add(new Ball(getWidth(), getHeight()));
        }

        while (true) {
            // game pause option
            // if paused sleeps in chunks of 100ms
            while (properties.getProperty("pause").equals("on")) {
                try {
                    Thread.sleep(100);
                    nextTick = System.nanoTime();
                } catch (InterruptedException ignored) {
                }
            }

            // fps manager
            skipTicks = (long) (Math.pow(10, 9) / Integer.parseInt(properties.getProperty("fps")));
            nextTick += skipTicks;
            sleepTime = nextTick - System.nanoTime();

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime / 1000000);
                } catch (InterruptedException ignored) {
                }
            }

            // main loop
            for (Ball ball : balls) {
                if (ball.collideHorizontalWall(getWidth(), getHeight())) {
                    ball.velocity.y = -ball.velocity.y;
                }
                if (ball.collideVerticalWall(getWidth(), getHeight())) {
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

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawString("FPS:", 4, 14);
        for (Ball ball : balls) {
            ball.paintComponent(g);
        }
    }
}