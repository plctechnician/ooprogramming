package org.nbicocchi.functional;

import org.nbicocchi.utils.Student;

interface StudentPredicate {
    boolean test(Student s);
}