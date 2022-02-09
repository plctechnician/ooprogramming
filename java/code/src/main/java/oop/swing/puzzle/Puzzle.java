package oop.swing.puzzle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Puzzle extends JFrame implements ActionListener {
    private final JMenuItem openFile, shuffleFile, closeFile;
    private final int TILE_X = 3, TILE_Y = 3;
    private final int TILE_WIDTH = 150, TILE_HEIGHT = 150;

    private final JPanel gamePanel;
    private final List<ImageButton> buttons;

    public Puzzle() {
        super("Puzzle");

        // menu
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        menuBar.add(file);

        openFile = new JMenuItem("Open...");
        openFile.addActionListener(this);
        file.add(openFile);

        shuffleFile = new JMenuItem("Shuffle");
        shuffleFile.addActionListener(this);
        file.add(shuffleFile);

        closeFile = new JMenuItem("Close");
        closeFile.addActionListener(this);
        file.add(closeFile);

        setJMenuBar(menuBar);

        // game panel
        gamePanel = new JPanel();
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.gray));
        gamePanel.setLayout(new GridLayout(TILE_Y, TILE_X, 0, 0));
        setContentPane(gamePanel);

        // buttons
        buttons = new LinkedList<>();

        // frame setup
        setSize(TILE_X * TILE_WIDTH, TILE_Y * TILE_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JMenuItem) {
            checkMenu(e);
        }
        if (e.getSource() instanceof ImageButton) {
            swapButtons(e);
        }

        updatePanel();

        if (isSolved()) {
            JOptionPane.showMessageDialog(this, "Solved!");
        }
    }

    private void buildPuzzle(String filename) throws IOException {
        BufferedImage source = ImageIO.read(new File(filename));
        BufferedImage target = new BufferedImage(
                    TILE_X * TILE_WIDTH,
                    TILE_Y * TILE_HEIGHT,
                    BufferedImage.TYPE_INT_ARGB);

        // resize image to fit properly
        Graphics2D g = target.createGraphics();
        g.drawImage(source, 0, 0, TILE_X * TILE_WIDTH, TILE_Y * TILE_HEIGHT, null);
        g.dispose();

        // split image in buttons
        for (int i = 0; i < TILE_Y; i++) {
            for (int j = 0; j < TILE_X; j++) {
                Image image = createImage(
                        new FilteredImageSource(target.getSource(),
                        new CropImageFilter(
                                j * TILE_WIDTH,
                                i * TILE_HEIGHT,
                                TILE_WIDTH,
                                TILE_HEIGHT)));

                ImageButton button = new ImageButton(image, i, j);
                button.addActionListener(this);
                buttons.add(button);
            }
        }
        buttons.get(buttons.size() - 1).setEmpty();
        updatePanel();
    }

    private void checkMenu(ActionEvent e) {
        if (e.getSource() == closeFile) {
            dispose();
        } else if (e.getSource() == this.shuffleFile) {
            Collections.shuffle(buttons);
            updatePanel();
        } else if (e.getSource() == this.openFile) {
            JFileChooser open = new JFileChooser();
            int option = open.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    buildPuzzle(open.getSelectedFile().getAbsolutePath());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Something went wrong...");
                }
            }
        }
    }

    private void swapButtons(ActionEvent e) {
        // look for empty button
        int emptyIndex = 0;
        for (ImageButton button : buttons) {
            if (button.isEmpty()) {
                emptyIndex = buttons.indexOf(button);
            }
        }

        // look for clicked button
        ImageButton button = (ImageButton) e.getSource();
        int clickedIndex = buttons.indexOf(button);

        // eventually swap
        if ((clickedIndex - 1 == emptyIndex) || (clickedIndex + 1 == emptyIndex) || (clickedIndex - TILE_X == emptyIndex) || (clickedIndex + TILE_X == emptyIndex)) {
            Collections.swap(buttons, clickedIndex, emptyIndex);
        }
    }

    private void updatePanel() {
        gamePanel.removeAll();
        for (ImageButton btn : buttons) {
            gamePanel.add(btn);
        }
        gamePanel.validate();
    }

    private boolean isSolved() {
        for (int row = 0; row < TILE_Y; row++) {
            for (int column = 0; column < TILE_X; column++) {
                int index = row * TILE_X + column;
                if (!buttons.get(index).getCorrectPosition().equals(new Point(row, column))) {
                    return false;
                }
            }
        }
        return true;
    }
}
