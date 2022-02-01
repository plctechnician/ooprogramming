package oop.basics;

public class TypesWrapper {
    public static void test_int() {
        int n = 3;
        Integer N = n;    /* autoboxing */
        String n_string = String.valueOf(n);
        N = Integer.valueOf(n_string);
        n = Integer.parseInt(n_string);
    }

    public static void test_double() {
        double d = 3.14;
        Double D = d;    /* autoboxing */
        String n_string = String.valueOf(d);
        D = Double.valueOf(n_string);
        d = Double.parseDouble(n_string);
    }

    public static void test_boolean() {
        boolean b = true;
        Boolean B = b;    /* autoboxing */
        String n_string = String.valueOf(b);
        B = Boolean.valueOf(n_string);
        b = Boolean.parseBoolean(n_string);
    }

    public static void main(String[] args) {
        test_int();
        test_double();
        test_boolean();
    }
}
