package oop.basics.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringsTest {
    @Test
    public void concatenate() {
        assertEquals("Hello World!", Strings.concatenate(new String[]{"Hello", " ", "World", "!"}));
    }

    @Test
    public void duplicateChars() {
        assertEquals("elw", new String(Strings.duplicateChars("whistleblower")));
        assertEquals("ehis", new String(Strings.duplicateChars("headmistressship")));
        assertEquals("es", new String(Strings.duplicateChars("stresslessness")));
    }

    @Test
    public void reverse() {
        assertEquals("tset gnirtS", Strings.reverse("String test"));
        assertEquals("eoD nhoJ", Strings.reverse("John Doe"));
    }

    @Test
    public void removeFirstTwoChars() {
        assertEquals("llo World!", Strings.removeFirstTwoChars("Hello World!"));
        assertEquals("me Sweet Home", Strings.removeFirstTwoChars("Home Sweet Home"));
    }

    @Test
    public void removeFirstTwoCharsIf() {
        assertEquals("Hello World!", Strings.removeFirstTwoCharsIf("Hello World!"));
        assertEquals("Hme Sweet Home", Strings.removeFirstTwoCharsIf("Home Sweet Home"));
    }

    @Test
    public void goodAtTheBeginning() {
        assertTrue(Strings.goodAtTheBeginning("good Sweet Home"));
        assertFalse(Strings.goodAtTheBeginning(" good Sweet Home"));
        assertFalse(Strings.goodAtTheBeginning("No good Sweet Home"));
    }

    @Test
    public void goodAroundTheBeginning() {
        assertTrue(Strings.goodAroundTheBeginning("good Sweet Home"));
        assertTrue(Strings.goodAroundTheBeginning(" good Sweet Home"));
        assertFalse(Strings.goodAroundTheBeginning("No good Sweet Home"));
    }

    @Test
    public void removeFirstLast() {
        assertEquals("Google", Strings.removeFirstLast("Google"));
        assertEquals("oogle", Strings.removeFirstLast("GoogleG"));
    }

    @Test
    public void isPalindrome() {
        assertFalse(Strings.isPalindrome("Google"));
        assertTrue(Strings.isPalindrome("radar"));
    }
}