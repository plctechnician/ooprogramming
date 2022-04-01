package oop.generics.animal;

import java.util.*;

public class TestApp {

    public static <T extends Comparable<? super T>> T max(List<T> list) {
        T candidate = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            T next = list.get(i);
            if (candidate.compareTo(next) < 0) {
                candidate = next;
            }
        }
        return candidate;
    }

    public static <T extends Comparable<? super T>> T max(List<T> list, Comparator<T> cmp) {
        T candidate = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            T next = list.get(i);
            if (cmp.compare(candidate, next) < 0) {
                candidate = next;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>(List.of(
                new Dog(20.3, 31.3),
                new Dog(22.5, 15.7),
                new Dog(19.5, 17.4),
                new Dog(16.2, 21.6)));
        System.out.println(dogs);
        System.out.println(max(dogs));
        System.out.println(max(dogs, new Comparator<Dog>() {

            @Override
            public int compare(Dog o1, Dog o2) {
                return (int) (o1.barkingRate - o2.barkingRate);
            }
        }));

        List<Animal> animals = new ArrayList<>(dogs);
        System.out.println(animals);
        System.out.println(max(animals));
    }
}
