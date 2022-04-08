package oop.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Listeners extends JFrame implements ComponentListener, KeyListener, ActionListener {
    JLabel summary;
    Timer timer;

    int x, y, w, h;
    int keycode;
    char keychar;
    int uptime;

    public Listeners() {
        super();

        summary = new JLabel("");
        timer = new Timer(1000, this);
        timer.start();

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(summary, BorderLayout.SOUTH);

        setContentPane(panel);
        addComponentListener(this);
        addKeyListener(this);
        setTitle(getClass().getName());
        setSize(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void updateSummary() {
        String str = String.format("x: %d, y: %d, w: %d, h: %d, keychar: %c, uptime: %d",
                x, y, w, h,keychar, uptime);
        summary.setText(str);
    }

    public void componentResized(ComponentEvent e) {
        componentMoved(e);
    }

    public void componentMoved(ComponentEvent e) {
        x = e.getComponent().getX();
        y = e.getComponent().getY();
        w = e.getComponent().getWidth();
        h = e.getComponent().getHeight();
        updateSummary();
    }

    public void componentShown(ComponentEvent e) {
    }

    public void componentHidden(ComponentEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        keycode = e.getKeyCode();
        keychar = e.getKeyChar();
        updateSummary();
    }

    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        uptime += 1;
        updateSummary();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Listeners::new);
    }
}