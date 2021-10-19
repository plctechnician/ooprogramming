package org.nbicocchi.swing.tetris;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.*;

public class TetrisPanel extends JPanel implements KeyListener, ActionListener {
    private static final long serialVersionUID = -8715353373678321308L;
    private static final int BOARD_MAX_X = 12;
    private static final int BOARD_MAX_Y = 23;
    private static final int BOARD_BLOCK = 26;

    private long score;
    private Color[][] board;
    private Piece currentPiece;

    public TetrisPanel() {
        super();

        initBoard();
        generatePiece();

        addKeyListener(this);
        setPreferredSize(new Dimension(
                BOARD_MAX_X * BOARD_BLOCK,
                BOARD_MAX_Y * BOARD_BLOCK));
        setFocusable(true);
        Timer timer = new Timer(1000, this);
        timer.start();
    }

    private void initBoard() {
        board = new Color[BOARD_MAX_X][BOARD_MAX_Y];
        for (int i = 0; i < BOARD_MAX_X; i++) {
            for (int j = 0; j < BOARD_MAX_Y; j++) {
                if (i == 0 || i == BOARD_MAX_X - 1 || j == BOARD_MAX_Y - 1) {
                    board[i][j] = Color.GRAY;
                } else {
                    board[i][j] = Color.BLACK;
                }
            }
        }
    }

    private void moveDown() {
        if (!currentPiece.moveDown()) {
            fixPieceToBoard();
            clearRows();
            generatePiece();
        }
    }

    private void fixPieceToBoard() {
        for (Point p : currentPiece.getGeometry()) {
            board[p.x][p.y] = currentPiece.getColor();
        }
    }

    private void clearRows() {

    }

    private void generatePiece() {
        Random rnd = new Random();
        currentPiece = new Piece(board, rnd.nextInt(7), 0, new Point(5, 2));
    }

    @Override
    public void paintComponent(Graphics g) {
        // Paint the well
        g.fillRect(0, 0, 26*12, 26*23);
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 23; j++) {
                g.setColor(board[i][j]);
                g.fillRect(26*i, 26*j, 25, 25);
            }
        }

        // Display the score
        g.setColor(Color.WHITE);
        g.drawString("" + score, 19*12, 25);

        // Draw the currently falling piece
        g.setColor(currentPiece.getColor());
        System.out.println(Arrays.toString(currentPiece.getGeometry()));
        for (Point p : currentPiece.getGeometry()) {
            g.fillRect(p.x * 26, p.y * 26,
                    25, 25);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                currentPiece.rotateRight();
                break;
            case KeyEvent.VK_DOWN:
                currentPiece.rotateLeft();
                break;
            case KeyEvent.VK_LEFT:
                currentPiece.moveRight();
                break;
            case KeyEvent.VK_RIGHT:
                currentPiece.moveLeft();
                break;
            case KeyEvent.VK_SPACE:
                moveDown();
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveDown();
        repaint();
    }
}
