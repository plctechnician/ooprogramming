package oop.basics.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArraysTest {
    @Test
    public void divideArray() {
        double[] input = {5.0, 4.0, 6.0, 2.0};
        assertArrayEquals(new double[]{2.5, 2.0, 3.0, 1.0}, Arrays.divideArray(input, 2.0), 0.01);
    }

    @Test
    public void divideArrays() {
        double[] v1 = {5.0, 4.0, 6.0, 2.0};
        double[] v2 = {10.0, 2.0, 3.0, 8.0};
        assertArrayEquals(new double[]{0.5, 2.0, 2.0, 0.25}, Arrays.divideArrays(v1, v2), 0.01);
    }

    @Test
    public void bubbleSort() {
        int[] input = {5, 4, 6, 2, 3, 4};
        assertArrayEquals(new int[]{2, 3, 4, 4, 5, 6}, Arrays.bubbleSort(input));
    }

    @Test
    public void fibonacci() {
        assertArrayEquals(new long[]{0}, Arrays.fibonacci(1));
        assertArrayEquals(new long[]{0, 1}, Arrays.fibonacci(2));
        assertArrayEquals(new long[]{0, 1, 1, 2, 3}, Arrays.fibonacci(5));
    }

    @Test
    public void moveZerosEnd() {
        assertArrayEquals(new int[]{1, 2, 3}, Arrays.moveZerosEnd(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{1, 2, 3, 0, 0}, Arrays.moveZerosEnd(new int[]{1, 2, 0, 0, 3}));
        assertArrayEquals(new int[]{1, 2, 3, 0}, Arrays.moveZerosEnd(new int[]{0, 1, 2, 3}));
    }

    @Test
    public void splitter() {
        assertArrayEquals(new int[]{2, 3, 4, 4, 5, 6}, Arrays.splitter(234456));
    }
}