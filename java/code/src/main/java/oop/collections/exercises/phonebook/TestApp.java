package oop.collections.exercises.phonebook;

import oop.utils.Student;

/**
 * The PhoneBook Interface defines the functionalities of a basic phone book.
 *
 * Provide two different implementations of the PhoneBook interface working with the
 * use case below. The first, (a) internally uses an Arraylist, the second (b) internally uses
 * an HashMap.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBookMap();

        //Uncomment this line for switching implementation
        //PhoneBook pb = new PhoneBookList();
        pb.addPerson(new Student("Nicola", "Bicocchi", "34567"));
        pb.addPerson(new Student("Marco", "Rizzo", "45243"));
        pb.addPerson(new Student("Luisa", "Poppi", "24564"));

        System.out.println(pb.searchByName("Marco"));
        System.out.println(pb.searchByLastname("Poppi"));

        // do not exist!
        System.out.println(pb.searchByNumber("1111"));

        // delete an element!
        pb.deleteByNumber("24564");
        System.out.println(pb.searchByLastname("Poppi"));
    }
}
