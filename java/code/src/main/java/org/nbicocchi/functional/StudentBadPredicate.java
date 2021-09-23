package org.nbicocchi.functional;

import org.nbicocchi.utils.Student;

class StudentBadPredicate implements StudentPredicate {
    public boolean test(Student s) {
        return s.getAverage() >= 20 && s.getAverage() <= 24;
    }
}
