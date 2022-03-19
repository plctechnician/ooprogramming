package oop.objectoriented.exercises.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void getTitle() {
        Book book = new Book("Soffocare", 2002, 170);
        assertEquals("Soffocare", book.getTitle());
    }

    @Test
    void setTitle() {
        Book book = new Book("Soffocare", 2002, 170);
        book.setTitle("Soffocare!");
        assertEquals("Soffocare!", book.getTitle());
    }

    @Test
    void getYear() {
        Book book = new Book("Soffocare", 2002, 170);
        assertEquals(2002, book.getYear());
    }

    @Test
    void setYear() {
        Book book = new Book("Soffocare", 2002, 170);
        book.setYear(2001);
        assertEquals(2001, book.getYear());
    }

    @Test
    void getPages() {
        Book book = new Book("Soffocare", 2002, 170);
        assertEquals(170, book.getPages());
    }

    @Test
    void setPages() {
        Book book = new Book("Soffocare", 2002, 170);
        book.setPages(180);
        assertEquals(180, book.getPages());
    }
}