package org.nbicocchi.objectoriented;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
        Rational r3 = r1.plus(r2);
        assertEquals(4.0, r3.numerator, 0);
        assertEquals(4.0, r3.denominator, 0);
    }

    @Test
    public void times() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 2);
        assertEquals(1.0, r1.times(r2).numerator, 0);
        assertEquals(4.0, r1.times(r2).denominator, 0);
    }
}