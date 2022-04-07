package oop.swing;

import javax.swing.*;

public class CelsiusConverterBare extends JFrame {
    private final JButton FCButton, CFButton;
    private final JTextField fahrenheitTF, celsiusTF;

    public CelsiusConverterBare() {
        super();
        celsiusTF = new JTextField("000");
        fahrenheitTF = new JTextField("032");
        CFButton = new JButton("°C->°F");
        FCButton = new JButton("°F->°C");

        JPanel mainPanel = new JPanel();
        mainPanel.add(celsiusTF);
        mainPanel.add(new JLabel("°C"));
        mainPanel.add(fahrenheitTF);
        mainPanel.add(new JLabel("°F"));
        mainPanel.add(CFButton);
        mainPanel.add(FCButton);

        /* JFrame methods called */
        setContentPane(mainPanel);
        setTitle("Celsius Converter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(350, 75);
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CelsiusConverterBare::new);
    }
}
