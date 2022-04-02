package oop.swing.paint;

import javax.swing.*;

public class TestApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Paint");
        PaintPanel p = new PaintPanel();
        frame.setContentPane(p);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
