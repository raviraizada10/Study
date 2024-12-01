package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncryptedSumTest {

    @Test
    public void testSumOfEncryptedIntRepeatedNumbers() {
        EncryptedSum encryptedSum = new EncryptedSum();
        int[] nums = {11, 22, 33, 11, 22};
        int result = encryptedSum.sumOfEncryptedInt(nums);
        assertEquals(99, result);
    }

    @Test
    public void testSumOfEncryptedIntAllZeros() {
        EncryptedSum encryptedSum = new EncryptedSum();
        int[] nums = {0, 0, 0, 0, 0};
        int result = encryptedSum.sumOfEncryptedInt(nums);
        assertEquals(0, result);
    }

    @Test
    public void testSumOfEncryptedIntMultiDigitNumbers() {
        EncryptedSum encryptedSum = new EncryptedSum();
        int[] nums = {12, 345, 6789, 101};
        int result = encryptedSum.sumOfEncryptedInt(nums);
        assertEquals(22 + 555 + 9999 + 111, result);
    }

    @Test
    public void testSumOfEncryptedIntSingleNumber() {
        EncryptedSum encryptedSum = new EncryptedSum();
        int[] nums = {123};
        int result = encryptedSum.sumOfEncryptedInt(nums);
        assertEquals(333, result);
    }

    @Test
    public void testSumOfEncryptedIntSingleDigitNumbers() {
        EncryptedSum encryptedSum = new EncryptedSum();
        int[] nums = {1, 2, 3, 4, 5};
        int result = encryptedSum.sumOfEncryptedInt(nums);
        assertEquals(15, result);
    }

}
