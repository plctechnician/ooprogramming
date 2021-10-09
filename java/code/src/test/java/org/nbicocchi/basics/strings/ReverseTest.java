package org.nbicocchi.basics.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseTest {

    @Test
    public void reverse() {
        String input = "String test";
        String output = Reverse.reverse(input);
        assertEquals("tset gnirtS", output);
    }

    @Test
    public void reverseFast() {
        String input = "String test";
        String output = Reverse.reverse(input);
        assertEquals("tset gnirtS", output);
    }
}