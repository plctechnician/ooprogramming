package oop.multithreading.producerconsumer;

import javax.swing.SwingUtilities;

public class TestApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProducerConsumerUI::new);
    }
}
