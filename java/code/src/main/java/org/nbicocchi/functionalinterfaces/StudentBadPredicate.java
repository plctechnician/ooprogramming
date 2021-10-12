package org.nbicocchi.functionalinterfaces;

import org.nbicocchi.utils.Student;

class StudentBadPredicate implements StudentPredicate {
    public boolean test(Student s) {
        return s.getAverage() <= 20;
    }
}
