package com.leetcode.essential.seventyFive.arraystring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GCDOfStringsTest {
    /**
     * Test {@link GCDOfStrings#gcdOfStrings(String, String)}.
     * <ul>
     *   <li>When {@code Str1}.</li>
     *   <li>Then return empty string.</li>
     * </ul>
     * <p>
     * Method under test: {@link GCDOfStrings#gcdOfStrings(String, String)}
     */
    @Test
    @DisplayName("Test gcdOfStrings(String, String); when 'Str1'; then return empty string")
    void testGcdOfStrings_whenStr1_thenReturnEmptyString() {
        // Arrange, Act and Assert
        assertEquals("", (new GCDOfStrings()).gcdOfStrings("Str1", "Str2"));
    }

    /**
     * Test {@link GCDOfStrings#gcdOfStrings(String, String)}.
     * <ul>
     *   <li>When {@code Str1}.</li>
     *   <li>Then return {@code Str1}.</li>
     * </ul>
     * <p>
     * Method under test: {@link GCDOfStrings#gcdOfStrings(String, String)}
     */
    @Test
    @DisplayName("Test gcdOfStrings(String, String); when 'Str1'; then return 'Str1'")
    void testGcdOfStrings_whenStr1_thenReturnStr1() {
        // Arrange, Act and Assert
        assertEquals("Str1", (new GCDOfStrings()).gcdOfStrings("Str1", ""));
    }
}
