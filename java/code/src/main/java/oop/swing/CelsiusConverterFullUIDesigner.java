package oop.swing;

import javax.swing.*;
import java.awt.*;

public class CelsiusConverterFullUIDesigner extends JFrame {
    private JPanel mainPanel;
    private JTextField tfCelsius;
    private JTextField tfFahrenheit;
    private JButton btCelsius;
    private JButton btFahrenheit;

    public CelsiusConverterFullUIDesigner() throws HeadlessException {
        super("CelsiusConverterFullUIDesigner");

        btCelsius.addActionListener(e -> {
            double tempFahrenheit = Double.parseDouble(tfCelsius.getText()) * 1.8 + 32;
            tfFahrenheit.setText(Double.toString(tempFahrenheit));
            if (tempFahrenheit < 32) {
                JOptionPane.showMessageDialog(null, "Water freezes here!", "Temperature Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        btFahrenheit.addActionListener(e -> {
            double tempCelsius = (Double.parseDouble(tfFahrenheit.getText()) - 32) * 0.555;
            tfCelsius.setText(Double.toString(tempCelsius));
            if (tempCelsius < 0) {
                JOptionPane.showMessageDialog(null, "Water freezes here!", "Temperature Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CelsiusConverterFullUIDesigner::new);
    }
}
