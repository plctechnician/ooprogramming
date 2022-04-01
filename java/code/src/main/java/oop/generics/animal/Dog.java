package oop.generics.animal;

public class Dog extends Animal {
    double barkingRate;

    public Dog(double respiratoryRate, double barkingRate) {
        super(respiratoryRate);
        this.barkingRate = barkingRate;
    }

    @Override
    public String toString() {
        return "Dog{" + "respiratoryRate=" + respiratoryRate + ", barkingRate=" + barkingRate + '}';
    }
}
