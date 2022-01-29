package oop.functionalinterfaces;

import oop.utils.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaFunctionalInterfaces {
    public static <T> List<T> processPredicate(List<T> items, Predicate<T> tester) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (tester.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T> List<T> processPredicateConsumer(List<T> items,
                                                         Predicate<T> tester,
                                                         Consumer<T> consumer) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (tester.test(item)) {
                consumer.accept(item);
                result.add(item);
            }
        }
        return result;
    }

    public static <X, Y> List<X> processPredicateConsumerFunction(List<X> items,
                                               Predicate<X> tester,
                                               Function<X, Y> mapper,
                                               Consumer<Y> consumer) {
        List<X> result = new ArrayList<>();
        for (X item : items) {
            if (tester.test(item)) {
                Y output = mapper.apply(item);
                consumer.accept(output);
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Student> results;
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", 28));
        students.add(new Student("Dimebag", "Darrell", 27));
        students.add(new Student("Gene", "Hoglan", 22));
        students.add(new Student("Tyler", "Durden", 26));
        students.add(new Student("Diana", "Krall", 23));
        students.add(new Student("Melody", "Gardot", 30));
        students.add(new Student("Tim", "Buckley", 21));

        System.out.println("processPredicate()...");
        results = processPredicate(
                students,
                (Student s) -> s.getAverage() >= 20 && s.getAverage() <= 24);
        System.out.println(results);

        System.out.println("processPredicateConsumer()...");
        results = processPredicateConsumer(
                students,
                (Student s) -> s.getAverage() >= 20 && s.getAverage() <= 24,
                System.out::println
        );
        System.out.println(results);

        System.out.println("processPredicateConsumerFunction()...");
        results = processPredicateConsumerFunction(
                students,
                (Student s) -> s.getAverage() >= 20 && s.getAverage() <= 24,
                Student::getName,
                System.out::println
        );
        System.out.println(results);
    }
}
