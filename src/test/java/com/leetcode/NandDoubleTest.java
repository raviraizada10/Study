package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NandDoubleTest {

    @Test
    void shouldHandleLargeArraysEfficiently() {
        NandDouble solution = new NandDouble();
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = i;
        }
        arr[99999] = 50000;
        long startTime = System.nanoTime();
        assertTrue(solution.checkIfExist(arr));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        assertTrue(duration < 100, "Execution time should be less than 100ms");
    }

    @Test
    void shouldReturnFalseForEmptyArray() {
        NandDouble solution = new NandDouble();
        int[] arr = {};
        assertFalse(solution.checkIfExist(arr));
    }

    @Test
    void shouldHandleArraysWithNegativeNumbersCorrectly() {
        NandDouble solution = new NandDouble();
        int[] arr = {-2, 0, 10, -10, 5, 4};
        assertTrue(solution.checkIfExist(arr));
    }

    @Test
    void shouldReturnTrueForArrayWithNumberAndItsDouble() {
        NandDouble solution = new NandDouble();
        int[] arr = {10, 2, 5, 3};
        assertTrue(solution.checkIfExist(arr));
    }

}
