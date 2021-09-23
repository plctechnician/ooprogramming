package org.nbicocchi.basics;


public class StringConcatenation {
    public static void main(String[] args) {
        // slow version
        String s = "";
        for (int i = 0; i < 100; i++) {
            s += 'a';
        }
        System.out.println(s);

        // fast version using StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append('a');
        }
        System.out.println(sb.toString());
    }
}
