package org.nbicocchi.functionalinterfaces;

import org.nbicocchi.utils.Student;

interface StudentPredicate {
    boolean test(Student s);
}