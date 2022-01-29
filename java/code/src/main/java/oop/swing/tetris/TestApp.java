package oop.swing.tetris;

import javax.swing.*;

public class TestApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris");
        TetrisPanel tetris = new TetrisPanel();

        frame.setContentPane(tetris);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
