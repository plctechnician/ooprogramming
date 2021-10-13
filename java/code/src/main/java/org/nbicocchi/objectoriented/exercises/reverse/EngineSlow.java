package org.nbicocchi.objectoriented.exercises.reverse;

public class EngineSlow implements Reverser {
    @Override
    public String reverse(String s) {
        String output = "";
        for (int i = 0; i < s.length(); i++) {
            output += s.charAt(i);
        }
        return output;
    }
}
