package org.nbicocchi.swing.bouncingballs;

import javax.swing.*;

public class TestApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BouncingBalls::new);
    }
}
