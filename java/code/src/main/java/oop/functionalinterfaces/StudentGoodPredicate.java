package oop.functionalinterfaces;

import oop.utils.Student;

class StudentGoodPredicate implements StudentPredicate {
    public boolean test(Student s) {
        return s.getAverage() >= 25;
    }
}
