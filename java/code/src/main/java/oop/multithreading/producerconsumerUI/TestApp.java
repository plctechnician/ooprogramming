package oop.multithreading.producerconsumerUI;

import java.awt.*;

public class TestApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(ProducerConsumerGUI::new);
    }
}
