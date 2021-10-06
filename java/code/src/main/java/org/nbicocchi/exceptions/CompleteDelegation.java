package org.nbicocchi.exceptions;

import java.io.FileReader;
import java.io.IOException;

public class CompleteDelegation {
    public void f() throws IOException {
        g();
    }

    public void g() throws IOException {
        FileReader reader = new FileReader("/tmp/missingfile");
        reader.read();
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        CompleteDelegation im = new CompleteDelegation();
        im.f();
    }
}