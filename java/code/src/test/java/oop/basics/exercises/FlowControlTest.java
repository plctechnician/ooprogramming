package oop.basics.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlowControlTest {
    @Test
    public void sumFirstHundredNumbers() {

        assertEquals(5050, FlowControl.sumFirstHundredNumbers());
    }

    @Test
    public void sumFirstNNumbers() {

        assertEquals(5050, FlowControl.sumFirstNNumbers(100));
    }
}