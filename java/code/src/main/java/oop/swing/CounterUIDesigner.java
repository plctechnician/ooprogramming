package oop.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterUIDesigner extends JFrame {
    private JButton btUp;
    private JTextField tfNumber;
    private JButton btDown;
    private JPanel mainPanel;

    public CounterUIDesigner() {
        super("CounterUIDesigner");
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(tfNumber.getText()) + 1;
                tfNumber.setText(Integer.toString(n));
            }
        });

        btDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(tfNumber.getText()) - 1;
                tfNumber.setText(Integer.toString(n));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CounterUIDesigner::new);
    }
}
