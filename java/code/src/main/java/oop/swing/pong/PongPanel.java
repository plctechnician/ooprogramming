package oop.swing.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class PongPanel extends JPanel implements ActionListener, KeyListener {
    Timer timer;
    HashMap<String, GameObject> gameObjects;

    public PongPanel() {
        super();
        setBackground(Color.BLACK);

        addKeyListener(this);
        setFocusable(true);
    }

    public void init() {
        RandomGenerator rnd = RandomGeneratorFactory.getDefault().create();
        gameObjects = new HashMap<>();

        gameObjects.put("ball", new Ball(this, gameObjects,
                20, 20,
                getWidth() / 2, getHeight() / 2,
                rnd.nextInt(6) + 3, rnd.nextInt(6) + 3));

        gameObjects.put("player_sx", new Player(this, gameObjects,
                20, 60,
                0, (getHeight() - 60) / 2,
                0, 0));

        gameObjects.put("player_dx", new Player(this, gameObjects,
                20, 60,
                getWidth() - 20, (getHeight() - 60) / 2,
                0, 0));

        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Player p1 = ((Player) gameObjects.get("player_sx"));
        Player p2 = ((Player) gameObjects.get("player_dx"));

        if (p1.getScore() >= 10) {
            JOptionPane.showMessageDialog(this, "Player 1 Wins!");
            p1.setScore(0);
            p2.setScore(0);
        }

        if (p2.getScore() >= 10) {
            JOptionPane.showMessageDialog(this, "Player 2 Wins!");
            p1.setScore(0);
            p2.setScore(0);
        }

        if (e.getSource() == timer) {
            for (GameObject object : gameObjects.values()) {
                object.update();
            }
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (GameObject go : gameObjects.values()) go.paint(g);

        String str = String.format("Player 1: %d vs Player 2: %d",
                ((Player) gameObjects.get("player_sx")).getScore(),
                ((Player) gameObjects.get("player_dx")).getScore());
        g.drawChars(str.toCharArray(), 0, str.length(), 0, getHeight() - 5);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e);
        if (e.getKeyCode() == KeyEvent.VK_UP)
            gameObjects.get("player_dx").setSpeedY(-4);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            gameObjects.get("player_dx").setSpeedY(4);
        if (e.getKeyChar() == '>') gameObjects.get("player_sx").setSpeedY(-4);
        if (e.getKeyChar() == '<') gameObjects.get("player_sx").setSpeedY(4);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) gameObjects.get("player_dx").setSpeedY(0);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            gameObjects.get("player_dx").setSpeedY(0);
        if (e.getKeyChar() == '>') gameObjects.get("player_sx").setSpeedY(0);
        if (e.getKeyChar() == '<') gameObjects.get("player_sx").setSpeedY(0);
    }
}
