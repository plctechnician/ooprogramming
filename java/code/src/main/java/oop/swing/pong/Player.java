package oop.swing.pong;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Player extends AbstractGameObject {
    int score = 0;

    public Player(JPanel parent, HashMap<String, GameObject> hgo,
                  int w, int h, int x, int y, int speedX, int speedY) {
        this.parent = parent;
        this.gameObjects = hgo;
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void update() {
        y += speedY;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRoundRect(x, y, w, h, 10, 10);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }
}
