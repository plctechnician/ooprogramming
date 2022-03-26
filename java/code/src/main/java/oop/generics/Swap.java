package oop.generics;

import java.util.ArrayList;
import java.util.List;

public class Swap {
    public static void swap(List<?> list, int i, int j) {
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
    }

    public static void addHello(List<?> list) {
        final List l = list;
        l.add("hello");
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,7,8));
        swap(list, 0, 2);
        System.out.println(list);
    }

}
