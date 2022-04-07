package oop.collections.exercises.phonebook;

import oop.utils.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

abstract class PhoneBookTestBase {
    PhoneBook pb;

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
        assertNull(pb.searchByLastname("Bicocchi"));
    }
}