package org.nbicocchi.swing.tetris;

import java.awt.*;

public class Piece {
    private final Point[][][] tetraminosGeometry = {
            // I-Piece
            {
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
            },

            // J-Piece
            {
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
            },

            // L-Piece
            {
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
            },

            // O-Piece
            {
                    { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
                    { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
                    { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
                    { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
            },

            // S-Piece
            {
                    { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
                    { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
                    { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
                    { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
            },

            // T-Piece
            {
                    { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
                    { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
                    { new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
            },

            // Z-Piece
            {
                    { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
                    { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
                    { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
                    { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
            }
    };

    private final Color[] tetraminoColor = {
            Color.cyan, Color.blue, Color.orange, Color.yellow, Color.green, Color.pink, Color.red
    };

    Color[][] board;
    int type;
    Point position;
    int rotation;

    public Piece(Color[][] board, int type, int rotation, Point position) {
        this.board = board;
        this.type = type;
        this.rotation = rotation;
        this.position = position;
    }

    public Color getColor() {
        return tetraminoColor[type];
    }

    public Point[] getGeometry() {
        int size = tetraminosGeometry[type][rotation].length;
        Point[] points = new Point[size];

        for (int i = 0; i < size; i++) {
            points[i] = new Point(tetraminosGeometry[type][rotation][i].x + position.x,
                    tetraminosGeometry[type][rotation][i].y + position.y);
        }
        return points;
    }

    // Collision test for the dropping piece
    public boolean collides() {
        for (Point p : getGeometry()) {
            if (board[p.x][p.y] != Color.BLACK) {
                return true;
            }
        }
        return false;
    }

    public void rotateRight() {
        int oldValue = rotation;
        rotation = (++rotation) % 4;
        if (collides()) {
            rotation = oldValue;
        }
    }

    public void rotateLeft() {
        int oldValue = rotation;
        rotation = (--rotation) % 4;
        if (rotation < 0) rotation = 3;
        if (collides()) {
            rotation = oldValue;
        }
    }

    public void moveLeft() {
        position.x += 1;
        if (collides()) {
            position.x -= 1;
        }
    }

    public void moveRight() {
        position.x -= 1;
        if (collides()) {
            position.x += 1;
        }
    }

    public boolean moveDown() {
        position.y += 1;
        if (collides()) {
            position.y -= 1;
            return false;
        }
        return true;
    }
}
