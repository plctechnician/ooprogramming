package oop.collections.exercises.mycollection;

import org.junit.jupiter.api.BeforeEach;

class MyArraySetTest extends MySetTestBase {
    @BeforeEach
    void setUp() {
        s = new MyArraySet();
    }
}