package com.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class maxRepeatingSubstringTest {
    /**
     * Test {@link maxRepeatingSubstring#maxRepeating(String, String)}.
     * <ul>
     *   <li>When {@code 42}.</li>
     *   <li>Then return zero.</li>
     * </ul>
     * <p>
     * Method under test: {@link maxRepeatingSubstring#maxRepeating(String, String)}
     */
    @Test
    @DisplayName("Test maxRepeating(String, String); when '42'; then return zero")
    void testMaxRepeating_when42_thenReturnZero() {
        // Arrange, Act and Assert
        assertEquals(0, (new maxRepeatingSubstring()).maxRepeating("42", "Word"));
    }

    @Test
    @DisplayName("Test maxRepeating(String, String); when '42'; then return zero")
    void testMaxRepeating_when_ababc_thenReturn2() {
        // Arrange, Act and Assert
        assertEquals(0, (new maxRepeatingSubstring()).maxRepeating("ababc", "ab"));
    }

    @Test
    @DisplayName("Test maxRepeating(String, String); when '42'; then return zero")
    void testMaxRepeating_when_a_thenReturn_1() {
        // Arrange, Act and Assert
        assertEquals(1, (new maxRepeatingSubstring()).maxRepeating("a", "a"));
    }
}
