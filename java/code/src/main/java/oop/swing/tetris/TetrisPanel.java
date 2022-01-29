package oop.swing.tetris;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

public class TetrisPanel extends JPanel implements KeyListener, ActionListener {
    private static final int BOARD_MAX_X = 12;
    private static final int BOARD_MAX_Y = 26;
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
            increaseScore();
            fixPieceToBoard();
            deleteFullRows();
            generatePiece();
        }
    }

    private void increaseScore() {
        score += 1;
    }

    private void fixPieceToBoard() {
        for (Point p : currentPiece.getGeometry()) {
            board[p.x][p.y] = currentPiece.getColor();
        }
    }

    private void deleteFullRows() {
        boolean gap;

        for (int row = BOARD_MAX_Y - 2; row > 0;) {
            gap = false;
            for (int column = BOARD_MAX_X - 2; column > 0; column--) {
                if (board[column][row] == Color.BLACK) {
                    gap = true;
                    break;
                }
            }
            if (gap) {
                row--;
            } else {
                deleteFullRow(row);
            }
        }
    }

    private void deleteFullRow(int rowToDelete) {
        for (int row = rowToDelete; row > 1; row--) {
            for (int column = BOARD_MAX_X - 2; column > 0; column--) {
                board[column][row] = board[column][row - 1];
            }
        }
    }

    private void generatePiece() {
        Random rnd = new Random();
        currentPiece = new Piece(board, rnd.nextInt(7), 0, new Point(BOARD_MAX_X / 2, 1));
    }

    @Override
    public void paintComponent(Graphics g) {
        // Paint the well
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, BOARD_BLOCK * BOARD_MAX_X, BOARD_BLOCK * BOARD_MAX_Y);

        for (int i = 0; i < BOARD_MAX_X; i++) {
            for (int j = 0; j < BOARD_MAX_Y; j++) {
                g.setColor(board[i][j]);
                g.fillRect(BOARD_BLOCK * i, BOARD_BLOCK * j, BOARD_BLOCK - 1, BOARD_BLOCK - 1);
            }
        }

        // Draw the currently falling piece
        g.setColor(currentPiece.getColor());
        for (Point p : currentPiece.getGeometry()) {
            g.fillRect(p.x * BOARD_BLOCK, p.y * BOARD_BLOCK,
                    BOARD_BLOCK - 1, BOARD_BLOCK - 1);
        }

        // Display the score
        g.setColor(Color.WHITE);
        g.drawString("" + score, BOARD_BLOCK * BOARD_MAX_X / 2, BOARD_BLOCK);
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
