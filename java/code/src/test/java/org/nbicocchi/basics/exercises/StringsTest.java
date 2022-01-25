package org.nbicocchi.basics.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringsTest {
    @Test
    public void concatenate_simple() {
        assertEquals("HelloWorld", Strings.concatenate_simple("Hello", "World"));
    }

    @Test
    public void concatenate() {
        String[] input = {"Hello", " ", "World", "!"};
        assertEquals("Hello World!", Strings.concatenate(input));
    }

    @Test
    public void duplicateChars() {
        String input = "whistleblower";
        assertEquals("lwe", new String(Strings.duplicateChars(input)));
    }

    @Test
    public void reverse() {
        String input = "String test";
        assertEquals("tset gnirtS", Strings.reverse(input));
    }

    @Test
    public void removeFirstTwoChars() {
        String input = "Hello World!";
        assertEquals("llo World!", Strings.removeFirstTwoChars(input));

        input = "Home Sweet Home";
        assertEquals("me Sweet Home", Strings.removeFirstTwoChars(input));
    }

    @Test
    public void removeFirstTwoCharsIf() {
        String input = "Hello World!";
        assertEquals("Hello World!", Strings.removeFirstTwoCharsIf(input));

        input = "Home Sweet Home";
        assertEquals("Hme Sweet Home", Strings.removeFirstTwoCharsIf(input));
    }

    @Test
    public void goodAtTheBeginning() {
        String input = "good Sweet Home";
        assertTrue(Strings.goodAtTheBeginning(input));

        input = " good Sweet Home";
        assertFalse(Strings.goodAtTheBeginning(input));

        input = "No good Sweet Home";
        assertFalse(Strings.goodAtTheBeginning(input));
    }

    @Test
    public void goodAtTheBeginningHard() {
        String input = "good Sweet Home";
        assertTrue(Strings.goodAtTheBeginningHard(input));

        input = " good Sweet Home";
        assertFalse(Strings.goodAtTheBeginningHard(input));

        input = "No good Sweet Home";
        assertFalse(Strings.goodAtTheBeginningHard(input));
    }

    @Test
    public void goodAtTheBeginningExt() {
        String input = "good Sweet Home";
        assertTrue(Strings.goodAtTheBeginningExt(input));

        input = " good Sweet Home";
        assertTrue(Strings.goodAtTheBeginningExt(input));

        input = "No good Sweet Home";
        assertFalse(Strings.goodAtTheBeginningExt(input));
    }

    @Test
    public void removeFirstLast() {
        String input = "Google";
        assertEquals("Google", Strings.removeFirstLast(input));

        input = "GoogleG";
        assertEquals("oogle", Strings.removeFirstLast(input));
    }

    @Test
    public void isPalindrome() {
        String input = "Google";
        assertFalse(Strings.isPalindrome(input));

        input = "radar";
        assertTrue(Strings.isPalindrome(input));
    }
}