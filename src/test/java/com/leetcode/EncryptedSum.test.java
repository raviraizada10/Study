package com.leetcode;

import com.leetcode.random.EncryptedSum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncryptedSumTest {

    @Test
    public void testSumOfEncryptedIntRepeatedNumbers() {
        com.leetcode.random.EncryptedSum encryptedSum = new com.leetcode.random.EncryptedSum();
        int[] nums = {11, 22, 33, 11, 22};
        int result = encryptedSum.sumOfEncryptedInt(nums);
        assertEquals(99, result);
    }

    @Test
    public void testSumOfEncryptedIntAllZeros() {
        com.leetcode.random.EncryptedSum encryptedSum = new com.leetcode.random.EncryptedSum();
        int[] nums = {0, 0, 0, 0, 0};
        int result = encryptedSum.sumOfEncryptedInt(nums);
        assertEquals(0, result);
    }

    @Test
    public void testSumOfEncryptedIntMultiDigitNumbers() {
        com.leetcode.random.EncryptedSum encryptedSum = new com.leetcode.random.EncryptedSum();
        int[] nums = {12, 345, 6789, 101};
        int result = encryptedSum.sumOfEncryptedInt(nums);
        assertEquals(22 + 555 + 9999 + 111, result);
    }

    @Test
    public void testSumOfEncryptedIntSingleNumber() {
        com.leetcode.random.EncryptedSum encryptedSum = new com.leetcode.random.EncryptedSum();
        int[] nums = {123};
        int result = encryptedSum.sumOfEncryptedInt(nums);
        assertEquals(333, result);
    }

    @Test
    public void testSumOfEncryptedIntSingleDigitNumbers() {
        com.leetcode.random.EncryptedSum encryptedSum = new EncryptedSum();
        int[] nums = {1, 2, 3, 4, 5};
        int result = encryptedSum.sumOfEncryptedInt(nums);
        assertEquals(15, result);
    }

}
