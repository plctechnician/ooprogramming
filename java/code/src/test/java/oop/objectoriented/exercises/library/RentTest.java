package oop.objectoriented.exercises.library;

import oop.utils.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class RentTest {
    Rent rent;

    @BeforeEach
    void setUp() throws ParseException {
        Item i = new Book("Soffocare", 2002, 170);
        Student s = new Student("0001", "Darrell", "Abbott");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        rent = new Rent(i, s, sdf.parse("15/06/2020"), sdf.parse("15/07/2020"));
    }

    @Test
    void getItem() {
        assertEquals("Soffocare", rent.getItem().getTitle());
    }

    @Test
    void setItem() {
        rent.setItem(new Dvd("Moon", 2011, 130));
        assertEquals("Moon", rent.getItem().getTitle());
    }

    @Test
    void getStudent() {
        assertEquals("Darrell", rent.getStudent().getLastname());
    }

    @Test
    void setStudent() {
        rent.setStudent(new Student("0002", "Nick", "Drake"));
        assertEquals("Nick", rent.getStudent().getLastname());
    }

    @Test
    void getBegin() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        assertEquals(sdf.parse("15/06/2020"), rent.getBegin());
    }

    @Test
    void setBegin() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        rent.setBegin(sdf.parse("16/06/2020"));
        assertEquals(sdf.parse("16/06/2020"), rent.getBegin());
    }

    @Test
    void getEnd() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        assertEquals(sdf.parse("15/07/2020"), rent.getEnd());
    }

    @Test
    void setEnd() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        rent.setEnd(sdf.parse("16/07/2020"));
        assertEquals(sdf.parse("16/07/2020"), rent.getEnd());
    }
}