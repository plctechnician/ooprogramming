package oop.io.exercises.trains;

import java.io.*;

public class Train implements Serializable {
    static final long serialVersionUID = 1L;
    static final double priceKm = 0.1;

    String starttime;
    String endtime;
    int numberOfStops;
    double totalDistance;

    public Train(String starttime, String endtime, int numberOfStops, double totalDistance) {
        this.starttime = starttime;
        this.endtime = endtime;
        this.numberOfStops = numberOfStops;
        this.totalDistance = totalDistance;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getNumberOfStops() {
        return numberOfStops;
    }

    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    @Override
    public String toString() {
        return "Train{" +
                "starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", numberOfStops=" + numberOfStops +
                ", totalDistance=" + totalDistance +
                '}';
    }
}
