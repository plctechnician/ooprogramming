package oop.collections.exercises.polynomials;

import org.junit.jupiter.api.BeforeEach;

class ArrayPolyTest extends PolyTestBase {

    @BeforeEach
    void setUp() {
        p = new ArrayPoly(new double[]{1,2,3,4});
    }
}