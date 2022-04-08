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
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser open = new JFileChooser();
                int option = open.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    try {
                        buildPuzzle(open.getSelectedFile().getAbsolutePath());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Something went wrong...");
                    }
                }
            }
        });

        JMenuItem closeFile = new JMenuItem("Close");
        closeFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

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
        Piece empty = null, clicked = null;

        clicked = (Piece) e.getSource();
        for (Piece piece : pieces) {
            if (piece.isEmpty()) {
                empty = piece;
            }
        }

        eventuallySwap(empty, clicked);

        updatePanel();
        if (isSolved()) {
            JOptionPane.showMessageDialog(this, "Solved!");
        }
    }


    void eventuallySwap(Piece empty, Piece clicked) {


    }

    void updatePanel() {
        gamePanel.removeAll();
        for (Piece p : pieces) {
            gamePanel.add(p);
        }
        gamePanel.validate();
    }

    boolean isSolved() {
        for (Piece p : pieces) {
            if (!p.isOK())
                return false;
        }
        return true;
    }
}
