package org.nbicocchi.collections.exercises;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class SetsTest {

    @Test
    public void firstRecurringCharacter() {
        assertEquals("e", Objects.requireNonNull(Sets.firstRecurringCharacter("elisabetta")).toString());
        assertEquals("t", Objects.requireNonNull(Sets.firstRecurringCharacter("Elisabetta")).toString());
    }
}