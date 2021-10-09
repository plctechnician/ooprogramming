package org.nbicocchi.basics.strings;

/**
 * Write a function accepting a String and returning the inverted String
 *
 * @author Nicola Bicocchi
 */
public class Reverse {
    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();

        // more compact version
        // return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        String input = "String test";
        System.out.println(input);
        System.out.println(reverse(input));
    }
}
