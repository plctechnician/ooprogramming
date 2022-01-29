package oop.exceptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DelegationModels {

    public void f() {
        g();
    }

    public void g() {
        // IOException (Checked)
        try {
            FileReader reader = new FileReader("/tmp/missingfile");
            reader.read();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int h() {
        // RuntimeException (Unchecked)
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(5, 10, 15, 20));
        return l.get(15);
    }

    public static void main(String[] args) {
        DelegationModels im = new DelegationModels();
        im.f();
    }
}