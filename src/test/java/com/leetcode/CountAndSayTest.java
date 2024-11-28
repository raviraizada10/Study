package com.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountAndSayTest {
    /**
     * Test {@link CountAndSay#countAndSay(int)}.
     * <p>
     * Method under test: {@link CountAndSay#countAndSay(int)}
     */
    @Test
    @DisplayName("Test countAndSay(int)")
    void testCountAndSay() {
        // Arrange, Act and Assert
        assertEquals("", (new CountAndSay()).countAndSay(3));
    }
}
