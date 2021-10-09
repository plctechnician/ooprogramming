package org.nbicocchi.basics.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicateCharsTest {

    @Test
    public void findDuplicates() {
        String input = "whistleblower";
        char[] output = DuplicateChars.duplicateChars(input);
        assertEquals("lwe", new String(output));
    }
}