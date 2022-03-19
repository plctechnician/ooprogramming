package oop.collections.exercises.phonebook;

import oop.utils.Student;

import java.util.ArrayList;

/**
 * A PhoneBook implementation internally using ArrayList. Slow!
 *
 * @author Nicola Bicocchi
 * @see PhoneBook
 */
public class PhoneBookList implements PhoneBook {
    ArrayList<Student> phoneBook;

    public PhoneBookList() {
        phoneBook = new ArrayList<>();
    }

    @Override
    public void addPerson(Student p) {
        phoneBook.add(p);
    }

    @Override
    public Student searchByName(String name) {
        for (Student p : phoneBook) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Student searchByLastname(String lastname) {
        for (Student p : phoneBook) {
            if (p.getLastname().equals(lastname)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Student searchByNumber(String phone) {
        for (Student p : phoneBook) {
            if (p.getPhone().equals(phone)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void deleteByNumber(String phone) {
        Student p = searchByNumber(phone);
        if (p != null)
            phoneBook.remove(p);
    }
}
