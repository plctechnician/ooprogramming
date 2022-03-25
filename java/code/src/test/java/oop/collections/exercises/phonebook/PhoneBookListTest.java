package oop.collections.exercises.phonebook;

import oop.utils.Student;
import org.junit.jupiter.api.BeforeEach;

class PhoneBookListTest extends PhoneBookTestBase {

    @BeforeEach
    void setUp() {
        pb = new PhoneBookList();
        pb.addPerson(new Student("Nicola", "Bicocchi", "34567"));
        pb.addPerson(new Student("Marco", "Rizzo", "45243"));
        pb.addPerson(new Student("Luisa", "Poppi", "24564"));
    }
}