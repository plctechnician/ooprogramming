package oop.swing.puzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Piece extends JButton {
    Point correctPosition;
    Point currentPosition;

    public Piece(Image image, Point position) {
        super(new ImageIcon(image));
        correctPosition = new Point(position);
        currentPosition = new Point(position);

        setBorder(BorderFactory.createLineBorder(Color.gray));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.yellow));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.gray));
            }
        });
    }

    public void setEmpty() {
        setIcon(null);
    }

    public boolean isEmpty() {
        return getIcon() == null;
    }

    public Point getCorrectPosition() {
        return correctPosition;
    }

    public void setCorrectPosition(Point correctPosition) {
        this.correctPosition = correctPosition;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Point currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isOK() {
        return currentPosition == correctPosition;
    }
}
