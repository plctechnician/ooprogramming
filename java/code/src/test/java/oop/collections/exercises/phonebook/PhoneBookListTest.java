package oop.collections.exercises.phonebook;

import oop.utils.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookListTest {
    PhoneBook pb;

    @BeforeEach
    void setUp() {
        pb = new PhoneBookList();
        pb.addPerson(new Student("Nicola", "Bicocchi", "34567"));
        pb.addPerson(new Student("Marco", "Rizzo", "45243"));
        pb.addPerson(new Student("Luisa", "Poppi", "24564"));
    }

    @Test
    void addPerson() {
        pb.addPerson(new Student("Mario", "Rossi", "12345"));
        assertEquals(pb.searchByName("Mario"), new Student("Mario", "Rossi", "12345"));

    }

    @Test
    void searchByName() {
        assertEquals(new Student("Nicola", "Bicocchi", "34567"), pb.searchByName("Nicola"));
    }

    @Test
    void searchByLastname() {
        assertEquals(new Student("Nicola", "Bicocchi", "34567"), pb.searchByLastname("Bicocchi"));
    }

    @Test
    void searchByNumber() {
        assertEquals(new Student("Nicola", "Bicocchi", "34567"), pb.searchByNumber("34567"));
    }

    @Test
    void deleteByNumber() {
        pb.deleteByNumber("34567");
        assertEquals(null, pb.searchByLastname("Bicocchi"));
    }
}