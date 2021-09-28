package org.nbicocchi.basics;

/**
 * Write a program to find all duplicates characters in a given string
 *
 * @author Nicola Bicocchi
 */
public class FindDuplicates {

    public static void main(String[] args) {
        String input = "Attaccapanni";
        String seen = "";
        String duplicates = "";

        for (int i = 0; i < input.length(); i++) {
            String tmp = String.valueOf(input.charAt(i));
            if (seen.contains(tmp) && !duplicates.contains(tmp)) {
                duplicates += tmp;
            } else {
                seen += tmp;
            }
        }
        System.out.println(duplicates);
    }
}
