package oop.swing.paint;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener {
    Point click, current;
    Rectangle rectangle;
    List<Rectangle> rectangleList;

    public PaintPanel() {
        super();
        rectangleList = new ArrayList<>();
        addMouseListener(this);
        addMouseMotionListener(this);
        requestFocus();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new PaintPanel());
        frame.setName("DrawPanel");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        click = new Point(evt.getX(), evt.getY());
        current = new Point(evt.getX(), evt.getY());
    }

    @Override
    public void mouseReleased(MouseEvent evt) {
        rectangleList.add(rectangle);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent evt) {
        current.setLocation(evt.getX(), evt.getY());
        int upperLeftX = Math.min((int)current.getX(), (int) click.getX());
        int upperLeftY = Math.min((int)current.getY(), (int) click.getY());
        int lowerRightX = Math.max((int)current.getX(), (int) click.getX());
        int lowerRightY = Math.max((int)current.getY(), (int) click.getY());
        rectangle = new Rectangle(upperLeftX, upperLeftY, lowerRightX - upperLeftX, lowerRightY - upperLeftY);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.drawRoundRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height, 30, 30);

        g.setColor(Color.GREEN);
        for (Rectangle r : rectangleList) {
            g.drawRoundRect(r.x, r.y, r.width, r.height, 30, 30);
        }
    }
}