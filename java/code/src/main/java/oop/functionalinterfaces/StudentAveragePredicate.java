package oop.functionalinterfaces;

import oop.utils.Student;

class StudentAveragePredicate implements StudentPredicate {
    public boolean test(Student s) {
        return s.getAverage() >= 20 && s.getAverage() <= 24;
    }
}
