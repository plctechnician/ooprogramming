package org.nbicocchi.functional;

import org.nbicocchi.utils.Student;

import java.util.ArrayList;
import java.util.List;

public class LambdaBasics {
    public static List<Student> filterStudentsByGrade(List<Student> students, double average) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getAverage() == average) {
                result.add(s);
            }
        }
        return result;
    }

    public static List<Student> filterStudentsByGradeRange(List<Student> students, int low, int high) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (low <= s.getAverage() && s.getAverage() < high) {
                result.add(s);
            }
        }
        return result;
    }

    public static List<Student> filterStudents(List<Student> students, StudentPredicate tester) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (tester.test(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public static <T> List<T> filter(List<T> l, Predicate<T> tester) {
        List<T> result = new ArrayList<>();
        for (T element : l) {
            if (tester.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Student> result;
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", 24));
        students.add(new Student("Dimebag", "Darrell", 25));
        students.add(new Student("Eric", "Baret", 28));
        students.add(new Student("Tyler", "Durden", 20));
        students.add(new Student("Diana", "Krall", 27));
        students.add(new Student("Jack", "Napier", 22));
        students.add(new Student("Rosa", "Luxemburg", 30));

        result = filterStudentsByGrade(students, 24);
        System.out.println("filterStudentsByGrade()...");
        System.out.println(result);

        result = filterStudentsByGradeRange(students, 20, 24);
        System.out.println("filterStudentsByGradeRange()...");
        System.out.println(result);

        result = filterStudents(students, new StudentAveragePredicate());
        System.out.println("filterStudents() with StudentPredicate...");
        System.out.println(result);

        result = filterStudents(students, new StudentPredicate() {
            @Override
            public boolean test(Student p) {
                return p.getAverage() >= 20 && p.getAverage() <= 24;
            }
        });
        System.out.println("filterStudents() with anonymous class...");
        System.out.println(result);

        result = filterStudents(students, (Student s) -> s.getAverage() >= 20 && s.getAverage() <= 24);
        System.out.println("filterStudents() with lambda expression...");
        System.out.println(result);

        result = filter(students, (Student s) -> s.getAverage() >= 20 && s.getAverage() <= 24);
        System.out.println("filter() with lambda expression and a generic method...");
        System.out.println(result);
  }
}
