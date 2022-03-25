package oop.collections.exercises.polynomials;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListPolyTest {

    @Test
    void testEquals() {
        Poly p1 = new ListPoly(new double[]{1,2,3,4});
        Poly p2 = new ListPoly(new double[]{1,2,3,4});
        Poly p3 = new ListPoly(new double[]{1,2,3,5});
        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
    }

    @Test
    void degree() {
        ListPoly p = new ListPoly(new double[]{1,2,3,4});
        assertEquals(3, p.degree());
    }

    @Test
    void derivative() {
        ListPoly p = new ListPoly(new double[]{1,2,3,4});
        assertEquals(new ListPoly(new double[]{2,6,12}), p.derivative());
    }

    @Test
    void coefficient() {
        ListPoly p = new ListPoly(new double[]{1,2,3,4});
        assertEquals(1, p.coefficient(0));
        assertEquals(2, p.coefficient(1));
        assertEquals(3, p.coefficient(2));
        assertEquals(4, p.coefficient(3));
    }

    @Test
    void coefficients() {
        ListPoly p = new ListPoly(new double[]{1,2,3,4});
        assertArrayEquals(new double[]{1, 2, 3, 4}, p.coefficients());
    }
}