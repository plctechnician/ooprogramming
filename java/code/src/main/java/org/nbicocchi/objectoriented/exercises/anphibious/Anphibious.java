package org.nbicocchi.objectoriented.exercises.anphibious;

public class Anphibious implements LandVehicle, WaterVehicle {

    @Override
    public void sail() {
        System.out.println("Anphibious sailing...");
    }

    @Override
    public void run() {
        System.out.println("Anphibious running...");
    }

}
