package oop.objectoriented.exercises.reverse;

public class EngineSlow implements Reverser {
    @Override
    public String reverse(String s) {
        String output = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            output += s.charAt(i);
        }
        return output;
    }
}
