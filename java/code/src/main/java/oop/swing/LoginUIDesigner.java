package oop.swing;

import javax.swing.*;
import java.util.HashMap;

public class LoginUIDesigner extends JFrame {
    private JButton cancelButton;
    private JButton OKButton;
    private JPasswordField tfPassword;
    private JTextField tfUsername;
    private JPanel mainPanel;

    public LoginUIDesigner() {
        super("LoginUIDesigner");
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        OKButton.addActionListener(e -> {
            char[] user = tfUsername.getText().toCharArray();
            char[] pass = tfPassword.getPassword();
            if (validCredentials(user, pass)) {
                JOptionPane.showMessageDialog(null, "Login Succeeded", "Login", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed", "Login", JOptionPane.WARNING_MESSAGE);
            }
        });
        cancelButton.addActionListener(e -> dispose());
    }

    private boolean validCredentials(char[] user, char[] pass) {
        HashMap<String, String> validCredentials = new HashMap<>();
        validCredentials.put("admin", "admin");
        validCredentials.put("root",  "jlkjN231");
        validCredentials.put("nicola","KOININ82");

        if (!validCredentials.containsKey(String.valueOf(user))) {
            return false;
        }
        return validCredentials.get(String.valueOf(user)).equals(String.valueOf(pass));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginUIDesigner::new);
    }
}
