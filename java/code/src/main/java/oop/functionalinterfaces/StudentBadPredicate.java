package oop.functionalinterfaces;

import oop.utils.Student;

class StudentBadPredicate implements StudentPredicate {
    public boolean test(Student s) {
        return s.getAverage() <= 20;
    }
}
