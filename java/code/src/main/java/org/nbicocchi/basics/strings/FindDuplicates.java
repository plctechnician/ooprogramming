package org.nbicocchi.basics.strings;

/**
 * Write a program to find all duplicates characters in a given string
 *
 * @author Nicola Bicocchi
 */
public class FindDuplicates {

    public static void main(String[] args) {
        String input = "Attaccapanni";
        StringBuilder seen = new StringBuilder();
        StringBuilder duplicates = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            String tmp = String.valueOf(input.charAt(i));
            if (seen.toString().contains(tmp) && !duplicates.toString().contains(tmp)) {
                duplicates.append(tmp);
            } else {
                seen.append(tmp);
            }
        }
        System.out.println(duplicates.toString());
    }
}
