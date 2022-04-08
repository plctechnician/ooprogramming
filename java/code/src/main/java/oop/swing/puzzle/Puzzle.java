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
import java.util.LinkedList;

public class Puzzle extends JFrame implements ActionListener {
    private final int TILE_X = 3, TILE_Y = 3;
    private final int TILE_WIDTH = 150, TILE_HEIGHT = 150;

    private final JPanel gamePanel;
    private final LinkedList<Piece> pieces;

    public Puzzle() {
        super("Puzzle");
        pieces = new LinkedList<>();

        generateMenu();

        gamePanel = new JPanel();
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.gray));
        gamePanel.setLayout(new GridLayout(TILE_Y, TILE_X, 0, 0));

        setContentPane(gamePanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(TILE_X * TILE_WIDTH, TILE_Y * TILE_HEIGHT);
        setResizable(false);
        setVisible(true);
    }

    void generateMenu() {
        JMenuItem openFile = new JMenuItem("Open...");
        openFile.addActionListener(e -> {
            JFileChooser open = new JFileChooser();
            int option = open.showOpenDialog(null);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    buildPuzzle(open.getSelectedFile().getAbsolutePath());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong...");
                }
            }
        });

        JMenuItem closeFile = new JMenuItem("Close");
        closeFile.addActionListener(e -> dispose());

        JMenu file = new JMenu("File");
        file.add(openFile);
        file.add(closeFile);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(file);
        setJMenuBar(menuBar);
    }

    void buildPuzzle(String filename) throws IOException {
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
        for (int y = 0; y < TILE_Y; y++) {
            for (int x = 0; x < TILE_X; x++) {
                Image image = createImage(
                        new FilteredImageSource(target.getSource(),
                                new CropImageFilter(
                                        x * TILE_WIDTH,
                                        y * TILE_HEIGHT,
                                        TILE_WIDTH,
                                        TILE_HEIGHT)));

                Piece p = new Piece(image, new Point(x, y));
                p.addActionListener(this);
                pieces.add(p);
            }
        }
        pieces.peekLast().setEmpty();
        updatePanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Piece clicked = (Piece) e.getSource();
        Piece empty = null;

        for (Piece piece : pieces) {
            if (piece.isEmpty()) {
                empty = piece;
                break;
            }
        }

        if ((Math.abs(clicked.currentPosition.x - empty.currentPosition.x) == 1) &&
                (clicked.currentPosition.y == empty.currentPosition.y)) {
            swap(empty, clicked);
        } else if ((Math.abs(clicked.currentPosition.y - empty.currentPosition.y) == 1) &&
                (clicked.currentPosition.x == empty.currentPosition.x)) {
            swap(empty, clicked);
        }

        updatePanel();

        if (isSolved()) {
            JOptionPane.showMessageDialog(null, "Solved!");
        }
    }

    void swap(Piece empty, Piece clicked) {
        Point tmp = new Point(clicked.currentPosition);
        clicked.currentPosition = empty.currentPosition;
        empty.currentPosition = tmp;
    }

    void positionToOrder() {
        pieces.sort((o1, o2) -> {
            int cmp = (int)(o1.currentPosition.getY() - o2.currentPosition.getY());
            if (cmp == 0) {
                cmp = (int)(o1.currentPosition.getX() - o2.currentPosition.getX());
            }
            return cmp;
        });
    }

    void updatePanel() {
        positionToOrder();
        gamePanel.removeAll();
        for (Piece p : pieces) gamePanel.add(p);
        gamePanel.validate();
    }

    boolean isSolved() {
        for (Piece p : pieces) {
            if (!p.isOK()) {
                return false;
            }
        }
        return true;
    }
}
