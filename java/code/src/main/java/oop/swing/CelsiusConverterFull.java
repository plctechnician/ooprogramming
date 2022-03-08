package oop.swing;

import javax.swing.*;
import java.awt.*;

public class CelsiusConverterFull extends JFrame {
    private final JButton CFButton;
    private final JButton FCButton;
    private final JTextField fahrenheitTF;
    private final JTextField celsiusTF;

    public CelsiusConverterFull() {
        super();
        celsiusTF = new JTextField("0");
        fahrenheitTF = new JTextField("32");
        CFButton = new JButton("°C->°F");
        FCButton = new JButton("°F->°C");

        CFButton.addActionListener(e -> {
            double tempFahrenheit = Double.parseDouble(celsiusTF.getText()) * 1.8 + 32;
            fahrenheitTF.setText(Double.toString(tempFahrenheit));
            if (tempFahrenheit < 32) {
                JOptionPane.showMessageDialog(null, "Water freezes here!", "Temperature Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        FCButton.addActionListener(e -> {
            double tempCelsius = (Double.parseDouble(fahrenheitTF.getText()) - 32) * 0.555;
            celsiusTF.setText(Double.toString(tempCelsius));
            if (tempCelsius < 0) {
                JOptionPane.showMessageDialog(null, "Water freezes here!", "Temperature Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        JPanel p1 = new JPanel(new GridLayout(2, 2));
        p1.add(celsiusTF);
        p1.add(new JLabel("°C"));
        p1.add(fahrenheitTF);
        p1.add(new JLabel("°F"));

        JPanel p2 = new JPanel(new GridLayout(1, 2));
        p2.add(CFButton);
        p2.add(FCButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(p1, BorderLayout.NORTH);
        mainPanel.add(p2, BorderLayout.SOUTH);

        /* JFrame methods called */
        setContentPane(mainPanel);
        setTitle("Celsius Converter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(200, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CelsiusConverterFull::new);
    }
}
