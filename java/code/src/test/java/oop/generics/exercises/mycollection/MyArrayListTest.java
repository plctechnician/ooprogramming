package oop.generics.exercises.mycollection;

import org.junit.jupiter.api.BeforeEach;

class MyArrayListTest extends MyListTestBase {
    @BeforeEach
    void setUp() {
        l = new MyArrayList<>();
    }
}