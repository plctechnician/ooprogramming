package oop.generics.animal;

import org.jetbrains.annotations.NotNull;

public class Animal implements Comparable<Animal> {
    double respiratoryRate;

    public Animal(double respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    @Override
    public String toString() {
        return "Animal{" + "respiratoryRate=" + respiratoryRate + '}';
    }

    @Override
    public int compareTo(@NotNull Animal o) {
        return (int)(respiratoryRate - o.respiratoryRate);
    }
}
