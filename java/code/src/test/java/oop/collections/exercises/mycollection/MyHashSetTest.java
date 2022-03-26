package oop.collections.exercises.mycollection;

import org.junit.jupiter.api.BeforeEach;

class MyHashSetTest extends MySetTestBase {
    @BeforeEach
    void setUp() {
        s = new MyHashSet();
    }
}