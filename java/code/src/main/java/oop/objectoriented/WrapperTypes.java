package oop.objectoriented;

public class WrapperTypes {
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

    public static double speedTest() {
        long begin = System.nanoTime();
        //int n = 0;
        Integer n = 0;
        for (int i = 0; i < 10000000; i++) {
            n = n + 1;
        }
        long end = System.nanoTime();
        return (end - begin) / Math.pow(10, 6);
    }

    public static double speedTestMyInteger() {
        long begin = System.nanoTime();
        myInteger n = new myInteger(0);
        for (int i = 0; i < 10000000; i++) {
            n.setN(n.getN() + 1);
        }
        long end = System.nanoTime();
        return (end - begin) / Math.pow(10, 6);
    }

    public static void main(String[] args) {
        System.out.println(speedTest() + "ms");
        //System.out.println(speedTestMyInteger() + "ms");
    }
}

class myInteger {
    int n;

    public myInteger(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
