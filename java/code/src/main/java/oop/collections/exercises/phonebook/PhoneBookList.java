package oop.collections.exercises.phonebook;

import oop.utils.Student;

import java.util.ArrayList;

/**
 * A PhoneBook implementation internally using ArrayList To be used for small
 * and simple applications. Slow!
 *
 * @author Nicola Bicocchi
 * @see PhoneBook
 */
public class PhoneBookList implements PhoneBook {
    ArrayList<Student> pb;

    public PhoneBookList() {
        pb = new ArrayList<>();
    }

    @Override
    public void addPerson(Student p) {
        pb.add(p);
    }

    @Override
    public Student searchByName(String name) {
        for (Student p : pb) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Student searchByLastname(String lastname) {
        for (Student p : pb) {
            if (p.getLastname().equals(lastname)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Student searchByNumber(String phone) {
        for (Student p : pb) {
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
            pb.remove(p);
    }
}
