package org.nbicocchi.basics.strings;

/**
 * Write a Java function accepting a String as a parameter and returning the inverted String
 *
 * @author Nicola Bicocchi
 */
public class StringReverse {
    // fast
    public static String reverse2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // faster
    public static String reverse3(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        String input = "String test";
        System.out.println(input);
        System.out.println(reverse2(input));
        System.out.println(reverse3(input));
    }
}
