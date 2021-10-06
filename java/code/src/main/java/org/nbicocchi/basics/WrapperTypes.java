package org.nbicocchi.basics;

public class WrapperTypes {
    public static void test_int() {
        int n = 3;
        Integer N = n;    /* autoboxing */
        String n_string = String.valueOf(n);
        N = Integer.valueOf(n_string);
        n = Integer.parseInt(n_string);
    }

    public static void test_double() {
        double n = 3.14;
        Double N = n;    /* autoboxing */
        String n_string = String.valueOf(n);
        N = Double.valueOf(n_string);
        n = Double.parseDouble(n_string);
    }

    public static void test_boolean() {
        boolean n = true;
        Boolean N = n;    /* autoboxing */
        String n_string = String.valueOf(n);
        N = Boolean.valueOf(n_string);
        n = Boolean.parseBoolean(n_string);
    }

    public static void main(String[] args) {
        test_int();
        test_double();
        test_boolean();
    }
}
