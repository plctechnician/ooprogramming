package oop.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

public class KeyboardListener extends JFrame implements KeyListener {
    LinkedList<Integer> lastChars;
    JPanel panel;
    JLabel label;

    public KeyboardListener() {
        super("KeyboardListener");
        lastChars = new LinkedList<>(List.of(0, 0, 0));

        panel = new JPanel(new BorderLayout());
        label = new JLabel();
        panel.add(label, BorderLayout.PAGE_END);

        setContentPane(panel);
        getContentPane().setFocusable(true);
        getContentPane().addKeyListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        // update last chars
        int keyCode = e.getKeyCode();
        char keyChar = e.getKeyChar();
        lastChars.addFirst(keyCode);
        lastChars.removeLast();

        // update label
        label.setText("RGB = " + lastChars);

        // update terminal
        System.out.print("RGB = " + lastChars);
        System.out.println("\tkeyPressed: VK Code is " + keyCode + ", Key char is " + keyChar);

        // update panel color
        panel.setBackground(new Color(lastChars.get(0), lastChars.get(1), lastChars.get(2)));
        repaint();
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KeyboardListener::new);
    }
}
