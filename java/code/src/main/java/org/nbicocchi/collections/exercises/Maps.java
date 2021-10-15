package org.nbicocchi.collections.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * You can find many more here:
 * https://www.w3resource.com/java-exercises/collection/index.php
 * Code -> Folding -> Collapse All
 * Code -> Folding -> Expand Doc Comments
 */
public class Maps {

    /**
     *  Write a function to return the number of key-value mappings in a map
     */
    public static int count(Map<Integer, Integer> map) {
        return map.size();
    }

    /**
     *  Write a function to remove all mappings from a map
     */
    public static void empty(Map<Integer, Integer> map) {
        map.clear();
    }

    /**
     *  Write a function to test if a map contains a mapping for the specified key
     */
    public static boolean contains(Map<Integer, Integer> map, int value) {
        return map.containsKey(value);
    }

    /**
     *  Write a function to return the key set of map
     */
    public static Set<Integer> keySet(Map<Integer, Integer> map) {
        return map.keySet();
    }

    /**
     *  Write a function to return "black", "white", or "red" depending on an int input value.
     *  "black" = 0, "white" = 1, "red" = 2
     */
    public static String getColor(int value) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "black");
        map.put(1, "white");
        map.put(2, "red");
        return map.get(value);
    }
}
