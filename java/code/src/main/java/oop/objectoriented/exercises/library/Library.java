package oop.objectoriented.exercises.library;

public class Library {
    Rent[] rents;

    public Library(Rent[] rents) {
        this.rents = rents;
    }

    public Rent getLongestRent() {
        Rent longestRent = rents[0];
        for (Rent r : rents) {
            if ((r.getEnd().getTime() - r.getBegin().getTime()) >
                    (longestRent.getEnd().getTime() - longestRent.getBegin().getTime())) {
                longestRent = r;
            }
        }
        return longestRent;
    }
}
