package oop.exceptions;

import java.io.FileReader;
import java.io.IOException;

public class NoDelegation {
    public void f() {
        g();
    }

    public void g() {
        try {
            FileReader reader = new FileReader("/tmp/missingfile");
            reader.read();
            reader.close();
        } catch (IOException e) {
            System.out.println("IO Error Occurred!");
        }
    }

    public static void main(String[] args) {
        NoDelegation im = new NoDelegation();
        im.f();
    }
}