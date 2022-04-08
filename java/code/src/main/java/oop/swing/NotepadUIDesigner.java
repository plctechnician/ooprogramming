package oop.swing;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;

public class NotepadUIDesigner extends JFrame {
    private JTextPane textPanel;

    public JMenuBar generateMenu() {
        JMenuItem open = new JMenuItem("Open...");
        open.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int option = chooser.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    textPanel.setText(Files.readString(chooser.getSelectedFile().toPath()));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Read failed!", "Failure!", JOptionPane.ERROR_MESSAGE);
                    dispose();
                }
            }
        });

        JMenuItem save = new JMenuItem("Save...");
        save.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int option = chooser.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    Files.writeString(chooser.getSelectedFile().toPath(), textPanel.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Read failed!", "Failure!", JOptionPane.ERROR_MESSAGE);
                    dispose();
                }
            }
        });

        JMenuItem close = new JMenuItem("Close");
        close.addActionListener(e -> {
            dispose();
        });

        JMenu file = new JMenu("File");
        file.add(open);
        file.add(save);
        file.add(close);

        JMenuBar menu = new JMenuBar();
        menu.add(file);
        return menu;
    }

    public NotepadUIDesigner() {
        super("NotepadUIDesigner");
        setJMenuBar(generateMenu());
        setContentPane(textPanel);
        setSize(800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        SwingUtilities.invokeLater(NotepadUIDesigner::new);
    }
}
