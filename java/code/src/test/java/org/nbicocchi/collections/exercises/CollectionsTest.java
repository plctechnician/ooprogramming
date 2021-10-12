package org.nbicocchi.collections.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class CollectionsTest {

    @Test
    public void firstRecurringCharacter() {
        assertEquals("e", Collections.firstRecurringCharacter("elisabetta").toString());
        assertEquals("t", Collections.firstRecurringCharacter("Elisabetta").toString());
    }
}