package oop.exceptions.exercises;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionsTest {
    @Test
    void checkString() {
        assertThrows(ParseException.class, () -> Exceptions.checkString("aab3h4z1r4"));
        assertThrows(ParseException.class, () -> Exceptions.checkString("a0b3h4z1rr"));
        assertDoesNotThrow(() -> Exceptions.checkString("a0b3h4z1r4"));
        assertDoesNotThrow(() -> Exceptions.checkString("a0"));
    }

    @Test
    void removeItems() {
        List<String> src = new ArrayList<>(List.of("aab3h4z1r4", "a0b3h4z1rr", "a0b3h4z1r4", "a0"));
        Exceptions.removeItems(src);
        assertEquals(List.of("a0b3h4z1r4", "a0"), src);
    }

    @Test
    void checkInterval() {
        assertThrows(ParseException.class, () -> Exceptions.checkInterval("15-12-2022", "17/12/2022"));
        assertThrows(ParseException.class, () -> Exceptions.checkInterval("15/12-2022", "17/12-2022"));
        assertThrows(ParseException.class, () -> Exceptions.checkInterval("15-32/2022", "17/12-20oo"));
        assertDoesNotThrow(() -> Exceptions.checkInterval("15/12/2022", "17/12/2022"));
        try {
            assertTrue(Exceptions.checkInterval("15/12/2022", "17/12/2022"));
            assertTrue(Exceptions.checkInterval("15/12/2022", "17/12/2122"));
            assertFalse(Exceptions.checkInterval("15/12/2022", "17/12/1922"));
            assertFalse(Exceptions.checkInterval("15/12/2022", "14/12/2022"));
        } catch (ParseException ignored) {

        }
    }

    @Test
    void checkInterval_alternative() {
        assertTrue(Exceptions.checkInterval_alternative("15/12/2022", "17/12/2022"));
        assertTrue(Exceptions.checkInterval_alternative("15/12/2022", "17/12/2122"));
        assertFalse(Exceptions.checkInterval_alternative("15/12/2022", "17/12/1922"));
        assertFalse(Exceptions.checkInterval_alternative("15/12/2022", "14/12/2022"));
        assertFalse(Exceptions.checkInterval_alternative("15-12-2022", "17/12/2022"));
        assertFalse(Exceptions.checkInterval_alternative("15/12-2022", "17/12-2022"));
        assertFalse(Exceptions.checkInterval_alternative("15-32/2022", "17/12-20oo"));
    }

    @Test
    void divide() {
        assertThrows(IllegalArgumentException.class, () -> Exceptions.divide(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> Exceptions.divide(1, 0));
        assertEquals(2.0, Exceptions.divide(4.0, 2.0), 0.001);
        assertEquals(-2.0, Exceptions.divide(-8.0, 4.0), 0.001);
    }

    @Test
    void divideSquared() {
        assertEquals(4.0, Exceptions.divideSquared(4.0, 2.0), 0.001);
        assertEquals(4.0, Exceptions.divideSquared(-8.0, 4.0), 0.001);
        assertEquals(0.0, Exceptions.divideSquared(4.0, 0.0), 0.001);
        assertEquals(0.0, Exceptions.divideSquared(-8.0, 0.0), 0.001);
    }

    @Test
    void completeDelegation() {
        assertThrows(IOException.class, () -> Exceptions.completeDelegation("/tmp/missing"));
    }

    @Test
    void noDelegation() {
        assertNull(Exceptions.noDelegation("/tmp/missing"));
    }

    @Test
    void partialDelegation() {
        assertThrows(RuntimeException.class, () -> Exceptions.partialDelegation("/tmp/missing"));
    }

    @Test
    void checkItems() {
        List<String> src = new ArrayList<>(List.of("aab3h4z1r4", "a0b3h4z1rr", "a0b3h4z1r4", "a0"));
        List<String> dst = Exceptions.checkItems(src);
        assertEquals(List.of("a0b3h4z1r4", "a0"), dst);
    }

    @Test
    void checkLists() {
        List<List<String>> src = new ArrayList<>(List.of(
                List.of("a3b3h4z1r4", "a0b3h4z1r0", "a0b3h4z1r4"),
                List.of("a3b3h4z1r4", "rrrrrrrrrr", "a0b3h4z1r4"),
                List.of("a3b3h4z1r4", "a0b3h4z1r0", "0000000000"),
                List.of("a3b3h4z1r4", "a0b3h4z1r0", "a0b3h4z1r4")));
        List<List<String>> dst = Exceptions.checkLists(src);
        assertEquals(List.of(
                List.of("a3b3h4z1r4", "a0b3h4z1r0", "a0b3h4z1r4"),
                List.of("a3b3h4z1r4", "a0b3h4z1r0", "a0b3h4z1r4")), dst);
    }

}