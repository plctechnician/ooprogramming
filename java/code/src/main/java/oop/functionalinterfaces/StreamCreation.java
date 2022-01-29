package oop.functionalinterfaces;

import oop.utils.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) {
        Stream<Student> s;

        /* Builder and accept() */
        s = getStreamBuilderAccept();
        s.forEach(System.out::println);

        /* Builder and add() */
        s = getStreamBuilderAdd();
        s.forEach(System.out::println);

        /* Stream.of() */
        s = getStreamOf();
        s.forEach(System.out::println);

        /* Stream from List */
        s = getStreamFromList();
        s.forEach(System.out::println);

        /* Stream from Array */
        s = getStreamFromArray();
        s.forEach(System.out::println);
    }

    // accept() return void
    public static Stream<Student> getStreamBuilderAccept() {
        Stream.Builder<Student> builder = Stream.builder();
        builder.accept(new Student("Dimebag", "Darrell", 27));
        builder.accept(new Student("Diana", "Krall", 23));
        builder.accept(new Student("Melody", "Gardot", 30));
        return builder.build();
    }

    // add() return another Builder
    public static Stream<Student> getStreamBuilderAdd() {
        Stream.Builder<Student> builder = Stream.builder();
        return builder.add(new Student("Dimebag", "Darrell", 27))
                .add(new Student("Diana", "Krall", 23))
                .add(new Student("Melody", "Gardot", 30))
                .build();
    }

    // Stream.of() creates a Stream<T> from T instances
    public static Stream<Student> getStreamOf() {
        return Stream.of(
                new Student("Dimebag", "Darrell", 27),
                new Student("Diana", "Krall", 23),
                new Student("Melody", "Gardot", 30));
    }

    public static Stream<Student> getStreamFromList() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", 28));
        students.add(new Student("Dimebag", "Darrell", 27));
        students.add(new Student("Gene", "Hoglan", 22));
        students.add(new Student("Tyler", "Durden", 26));
        students.add(new Student("Diana", "Krall", 23));
        students.add(new Student("Melody", "Gardot", 30));
        students.add(new Student("Tim", "Buckley", 21));
        return students.stream();
    }

    public static Stream<Student> getStreamFromArray() {
        Student[] students = new Student[3];
        students[0] = new Student("John", "Doe", 28);
        students[1] = new Student("Dimebag", "Darrell", 27);
        students[2] = new Student("Gene", "Hoglan", 22);
        return Arrays.stream(students);
    }
}
