package oop.basics.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArraysTest {
    @Test
    public void divideArray() {
        double[] input = {5.0, 4.0, 6.0, 2.0};
        double f = 2.0;
        double[] output = {2.5, 2.0, 3.0, 1.0};
        assertArrayEquals(output, Arrays.divideArray(input, f), 0.01);
    }

    @Test
    public void divideArrays() {
        double[] v1 = {5.0, 4.0, 6.0, 2.0};
        double[] v2 = {10.0, 2.0, 3.0, 8.0};
        double[] output = {0.5, 2.0, 2.0, 0.25};
        assertArrayEquals(output, Arrays.divideArrays(v1, v2), 0.01);
    }

    @Test
    public void bubbleSort() {
        int[] input = {5, 4, 6, 2, 3, 4};
        int[] output = {2, 3, 4, 4, 5, 6};
        assertArrayEquals(output, Arrays.bubbleSort(input));
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
        int[] output = {2, 3, 4, 4, 5, 6};
        assertArrayEquals(output, Arrays.splitter(234456));
    }
}