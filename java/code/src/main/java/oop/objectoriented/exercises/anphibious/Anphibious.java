package oop.objectoriented.exercises.anphibious;

public class Anphibious implements LandVehicle, WaterVehicle {
    @Override
    public String sail() {
        return "Anphibious sailing...";
    }

    @Override
    public String run() {
        return "Anphibious running...";
    }
}
