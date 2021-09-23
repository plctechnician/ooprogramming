package org.nbicocchi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JTextField tfUsername;
    JTextField tfPassword;
    JButton btnOK;
    JButton btnCancel;

    public Login() throws HeadlessException {
        super("Login");
        tfUsername = new JTextField("");
        tfPassword = new JTextField("");
        btnOK = new JButton("Ok");
        btnCancel = new JButton("Cancel");
        btnOK.addActionListener(this);
        btnCancel.addActionListener(this);

        JPanel p1 = new JPanel(new GridLayout(3,2));
        p1.add(new JLabel("Username:"));
        p1.add(tfUsername);
        p1.add(new JLabel("Password:"));
        p1.add(tfPassword);
        p1.add(btnCancel);
        p1.add(btnOK);

        setContentPane(p1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(250, 150);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("Cancel")) {
            dispose();
        } else if (e.getActionCommand().equals("Ok")) {
            if (tfUsername.getText().equals("admin") && (tfPassword.getText().equals("admin"))) {
                JOptionPane.showMessageDialog(this, "Login Succeeded", "Login",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Login Failed", "Login",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);
    }
}
