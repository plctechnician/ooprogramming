package org.nbicocchi.collections.exercises;

import java.util.HashSet;
import java.util.Set;

/**
 * You can find many more here:
 * https://www.w3resource.com/java-exercises/collection/index.php
 */
public class Collections {

    /**
     * Find in the string s, the first recurring character and return it.
     * Otherwise, return null.
     */
    public static Character firstRecurringCharacter(String s) {
        Set<Character> seenCharacters = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seenCharacters.contains(c)) {
                return c;
            } else {
                seenCharacters.add(c);
            }
        }
        return null;
    }
}