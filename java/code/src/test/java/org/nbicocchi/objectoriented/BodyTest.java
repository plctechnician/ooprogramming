package org.nbicocchi.objectoriented;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BodyTest {
    @Test
    public void setSpeed() {
        Body b = new Body(0, 0, 5, 5);
        b.setSpeed(7, 7);
        assertEquals(7.0, b.getVX(), 0.0);
    }

    @Test
    public void progress() {
        Body b = new Body(0, 0, 3, 2);
        b.progress(2);
        assertEquals(6.0, b.getX(), 0.0);
        assertEquals(4.0, b.getY(), 0.0);
    }
}