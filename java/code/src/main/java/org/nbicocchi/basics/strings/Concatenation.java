package org.nbicocchi.basics.strings;

/**
 * Write a function accepting a String[]
 * and returning a single String representing
 * the concatenation of all Strings of the array
 *
 * @author Nicola Bicocchi
 */
public class Concatenation {
    public static String concatenate(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"Hello", " ", "World", "!"};
        System.out.println(concatenate(strings));
    }

}
