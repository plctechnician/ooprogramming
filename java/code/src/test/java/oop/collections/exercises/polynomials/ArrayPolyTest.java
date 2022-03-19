package oop.collections.exercises.polynomials;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayPolyTest {

    @Test
    void testEquals() {
        ArrayPoly p1 = new ArrayPoly(new double[]{1,2,3,4});
        ArrayPoly p2 = new ArrayPoly(new double[]{1,2,3,4});
        ArrayPoly p3 = new ArrayPoly(new double[]{1,2,3,5});
        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
    }

    @Test
    void degree() {
        ArrayPoly p = new ArrayPoly(new double[]{1,2,3,4});
        assertEquals(3, p.degree());
    }

    @Test
    void derivative() {
        ArrayPoly p = new ArrayPoly(new double[]{1,2,3,4});
        assertEquals(new ArrayPoly(new double[]{2,6,12}), p.derivative());
    }

    @Test
    void coefficient() {
        ArrayPoly p = new ArrayPoly(new double[]{1,2,3,4});
        assertEquals(1, p.coefficient(0));
        assertEquals(2, p.coefficient(1));
        assertEquals(3, p.coefficient(2));
        assertEquals(4, p.coefficient(3));
    }

    @Test
    void coefficients() {
        ArrayPoly p = new ArrayPoly(new double[]{1,2,3,4});
        assertArrayEquals(new double[]{1, 2, 3, 4}, p.coefficients());
    }
}