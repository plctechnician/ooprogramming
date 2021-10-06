package org.nbicocchi.basics.strings;

/**
 * Write a program for transforming a String[]
 * into a single String using StringBuilder
 *
 * @author Nicola Bicocchi
 */
public class StringComposition {
    public static String compose(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"Hello", " ", "World", "!"};
        System.out.println(compose(strings));
    }

}
