package oop.exceptions.exercises;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Use the StringChecker class and Iterators for removing invalid elements from
 * a List of Strings while iterating over it.
 *
 * @author Nicola Bicocchi
 */
public class ListChecker {
    public void check(List<String> strings) {
        StringChecker checker = new StringChecker();
        for (Iterator<String> i = strings.iterator(); i.hasNext(); ) {
            try {
                checker.check(i.next());
            } catch (ParseException e) {
                i.remove();
            }
        }
    }

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("rrr6t8f0d0e");
        l.add("r5r6t8f0d0e");
        l.add("r2r6t8f0d00");
        l.add("z1z0t8f1d7d");

        ListChecker lc = new ListChecker();
        lc.check(l);

        System.out.println(l);
    }
}
