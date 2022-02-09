package oop.objectoriented.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RationalTest {
    @Test
    public void constructorThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Rational(1, 0));
    }

    @Test
    public void plus() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 2);
        assertEquals(4.0, r1.plus(r2).numerator, 0);
        assertEquals(4.0, r1.plus(r2).denominator, 0);
    }

    @Test
    public void times() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 2);
        assertEquals(1.0, r1.times(r2).numerator, 0);
        assertEquals(4.0, r1.times(r2).denominator, 0);
    }
}