package oop.jdbc.planemanager_rest;

import javax.swing.*;

/**
 * Works with rest.advanced.Server which exposes planes data
 */
public class TestApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlanesUIDesigner::new);
    }
}
