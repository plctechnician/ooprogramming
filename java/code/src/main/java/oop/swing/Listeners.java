package oop.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listeners extends JFrame implements ComponentListener, KeyListener {
    private final JLabel summary;

    public Listeners() {
        super();

        summary = new JLabel("");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(summary, BorderLayout.SOUTH);

        setContentPane(panel);
        addComponentListener(this);
        addKeyListener(this);
        setTitle(getClass().getName());
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void componentResized(ComponentEvent e) {
        String text = String.format("x: %d; y: %d; w: %d; h: %d\n", e.getComponent().getX(),
                e.getComponent().getY(),
                e.getComponent().getWidth(),
                e.getComponent().getHeight());
        summary.setText(text);
    }

    public void componentMoved(ComponentEvent e) {
        String text = String.format("x: %d; y: %d; w: %d; h: %d\n", e.getComponent().getX(),
                e.getComponent().getY(),
                e.getComponent().getWidth(),
                e.getComponent().getHeight());
        summary.setText(text);
    }

    public void componentShown(ComponentEvent e) {
    }

    public void componentHidden(ComponentEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        String text = String.format("keycode: %d; keychar: %c\n", e.getKeyCode(), e.getKeyChar());
        summary.setText(text);
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Listeners::new);
    }
}