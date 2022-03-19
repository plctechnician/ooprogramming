package oop.collections.exercises.phonebook;

import oop.utils.Student;

import java.util.HashMap;

/**
 * A PhoneBook implementation internally using HashMap
 *
 * @author Nicola Bicocchi
 * @see PhoneBook
 */
public class PhoneBookMap implements PhoneBook {
    HashMap<String, Student> phoneBook;

    public PhoneBookMap() {
        phoneBook = new HashMap<>();
    }

    // We use the phone number as key because it is unique
    public void addPerson(Student s) {
        phoneBook.put(s.getPhone(), s);
    }

    public Student searchByName(String name) {
        for (Student s : phoneBook.values()) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    public Student searchByLastname(String lastname) {
        for (Student s : phoneBook.values()) {
            if (s.getLastname().equals(lastname)) {
                return s;
            }
        }
        return null;
    }

    public Student searchByNumber(String phone) {
        if (phoneBook.containsKey(phone)) {
            return phoneBook.get(phone);
        }
        return null;
    }

    public void deleteByNumber(String phone) {
        phoneBook.remove(phone);
    }
}
