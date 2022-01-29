package oop.io.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Write a program for reading a text file and counting the total number of both
 * lines and chars. The program should output two lines as per below:
 * lines: x
 * chars: y
 *
 * @author Nicola Bicocchi
 */
public class LineCounter {
    public static void main(String[] args) {
        int lines = 0, chars = 0;
        String line;

        try (BufferedReader in = new BufferedReader(new FileReader("java/code/src/main/resources/text/webpage.html"))) {
            while ((line = in.readLine()) != null) {
                chars += line.length();
                lines += 1;
            }
            System.out.println("lines: " + lines);
            System.out.println("chars: " + chars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
