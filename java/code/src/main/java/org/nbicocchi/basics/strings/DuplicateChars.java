package org.nbicocchi.basics.strings;

/**
 * Write a function accepting a String and returning
 * all duplicate characters as a char[]
 *
 * @author Nicola Bicocchi
 */
public class DuplicateChars {
    public static char[] duplicateChars(String input) {
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
        return duplicates.toString().toCharArray();
    }

    public static void main(String[] args) {
        String input = "whistleblower";
        char[] output = duplicateChars(input);
        for (char c : output) {
            System.out.println(c);
        }
    }
}
