package oop.basics.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlowControlTest {
    @Test
    public void sumFirstNumbers() {
        assertEquals(5050, FlowControl.sumFirstNumbers(100));
    }
}