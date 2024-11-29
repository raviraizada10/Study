package com.leetcode.essential.seventyFive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductOfArrayExceptSelfTest {
    /**
     * Test {@link ProductOfArrayExceptSelf#productExceptSelf(int[])}.
     * <p>
     * Method under test: {@link ProductOfArrayExceptSelf#productExceptSelf(int[])}
     */
    @Test
    @DisplayName("Test productExceptSelf(int[])")
    void testProductExceptSelf() {
        // Arrange, Act and Assert
        assertArrayEquals(new int[]{100000, 10000000, 100000, 10000000},
                (new ProductOfArrayExceptSelf()).productExceptSelf(new int[]{1000, 10, 1000, 10}));
    }
}
