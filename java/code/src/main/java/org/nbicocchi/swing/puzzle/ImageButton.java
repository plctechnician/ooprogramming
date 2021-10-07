package org.nbicocchi.swing.puzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageButton extends JButton {
    private static final long serialVersionUID = 1L;
    private final int correctPosition_x;
    private final int correctPosition_y;

    public ImageButton(Image image, int correctPosition_x, int correctPosition_y) {
        super(new ImageIcon(image));
        this.correctPosition_x = correctPosition_x;
        this.correctPosition_y = correctPosition_y;

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
        return new Point(correctPosition_x, correctPosition_y);
    }
}
