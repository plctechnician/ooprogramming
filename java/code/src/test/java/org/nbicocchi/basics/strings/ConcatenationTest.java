package org.nbicocchi.basics.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConcatenationTest {

    @Test
    public void compose() {
        String[] input = {"Hello", " ", "World", "!"};
        String output = Concatenation.concatenate(input);
        assertEquals("Hello World!", output);
    }
}