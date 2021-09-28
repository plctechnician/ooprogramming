package org.nbicocchi.basics;

/**
 * Write a Java function accepting a String as a parameter and returning the inverted String
 *
 * @author Nicola Bicocchi
 */
public class StringReverse {
    // slow
    public static String reverse1(String s) {
        String output = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            output += s.charAt(i);
        }
        return output;
    }

    // faster
    public static String reverse2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // fastest
    public static String reverse3(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String input = "String test";
        String output = reverse3(input);
        System.out.println(input);
        System.out.println(output);
    }
}
