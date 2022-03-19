package oop.objectoriented.exercises.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DvdTest {
    @Test
    void getTitle() {
        Dvd dvd = new Dvd("Moon", 2011, 130);
        assertEquals("Moon", dvd.getTitle());
    }

    @Test
    void setTitle() {
        Dvd dvd = new Dvd("Moon", 2011, 130);
        dvd.setTitle("Sun");
        assertEquals("Sun", dvd.getTitle());
    }

    @Test
    void getYear() {
        Dvd dvd = new Dvd("Moon", 2011, 130);
        assertEquals(2011, dvd.getYear());
    }

    @Test
    void setYear() {
        Dvd dvd = new Dvd("Moon", 2011, 130);
        dvd.setYear(2012);
        assertEquals(2012, dvd.getYear());
    }

    @Test
    void getDuration() {
        Dvd dvd = new Dvd("Moon", 2011, 130);
        assertEquals(130, dvd.getDuration());
    }

    @Test
    void setDuration() {
        Dvd dvd = new Dvd("Moon", 2011, 130);
        dvd.setDuration(140);
        assertEquals(140, dvd.getDuration());
    }
}