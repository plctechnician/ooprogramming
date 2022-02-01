package oop.collections;

import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * Class for showing the speed of insertion and retrieval from ArrayList,
 * LinkedList, HashMap
 *
 * @author Nicola Bicocchi
 */
public class SpeedTest {
    int items;
    long start;
    long stop;
    RandomGenerator rnd;

    public SpeedTest(int items) {
        this.items = items;
        this.rnd = RandomGeneratorFactory.getDefault().create();
    }

    public void fillList(List<Integer> l) {
        start = System.nanoTime();
        for (int i = 0; i < items; i++) {
            l.add(rnd.nextInt(items));
        }
        stop = System.nanoTime();
    }

    public void retrieveFromList(List<Integer> l) {
        start = System.nanoTime();
        for (int i = 0; i < items; i++) {
            retrieveValueFromList(l, rnd.nextInt(items));
        }
        stop = System.nanoTime();
    }

    public void fillSet(Set<Integer> s) {
        start = System.nanoTime();
        for (int i = 0; i < items; i++) {
            s.add(rnd.nextInt(items));
        }
        stop = System.nanoTime();
    }

    public void retrieveFromSet(Set<Integer> s) {
        start = System.nanoTime();
        for (int i = 0; i < items; i++) {
            s.contains(i);
        }
        stop = System.nanoTime();
    }

    public void fillMap(Map<Integer, Integer> m) {
        start = System.nanoTime();
        for (int i = 0; i < items; i++) {
            int n = rnd.nextInt(items);
            m.put(n, n);
        }
        stop = System.nanoTime();
    }

    public void retrieveFromMap(Map<Integer, Integer> m) {
        start = System.nanoTime();
        for (int i = 0; i < items; i++) {
            m.get(rnd.nextInt(items));
        }
        stop = System.nanoTime();
    }

    public void retrieveValueFromList(List<Integer> l, int value) {
        for (Integer integer : l) {
            if (integer.equals(value))
                break;
        }
    }

    public String summary(String verb, String dataStructureName) {
        return String.format("%s %s [items=%d] [time=%.2fms]", verb, dataStructureName, items, (stop - start) / 1000000.0);
    }

    public static void main(String[] args) {
        int items = 5000;
        SpeedTest test = new SpeedTest(items);

        List<Integer> al = new ArrayList<>();
        test.fillList(al);
        System.out.println(test.summary("FILL", "ArrayList"));

        test.retrieveFromList(al);
        System.out.println(test.summary("RETR", "ArrayList"));

        List<Integer> ll = new LinkedList<>();
        test.fillList(ll);
        System.out.println(test.summary("FILL", "LinkedList"));

        test.retrieveFromList(ll);
        System.out.println(test.summary("RETR", "LinkedList"));

        Set<Integer> s = new HashSet<>();
        test.fillSet(s);
        System.out.println(test.summary("FILL", "HashSet"));

        test.retrieveFromSet(s);
        System.out.println(test.summary("RETR", "HashSet"));

        HashMap<Integer, Integer> m = new HashMap<>();
        test.fillMap(m);
        System.out.println(test.summary("FILL", "HashMap"));

        test.retrieveFromMap(m);
        System.out.println(test.summary("RETR", "HashMap"));
    }
}
