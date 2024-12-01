package com.gfg.gfg160;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsAnagramTest {
    /**
     * Test {@link IsAnagram#areAnagrams(String, String)}.
     * <ul>
     *   <li>When empty string.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link IsAnagram#areAnagrams(String, String)}
     */
    @Test
    @DisplayName("Test areAnagrams(String, String); when empty string; then return 'false'")
    void testAreAnagrams_whenEmptyString_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(IsAnagram.areAnagrams("", "S2"));
    }

    /**
     * Test {@link IsAnagram#areAnagrams(String, String)}.
     * <ul>
     *   <li>When empty string.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link IsAnagram#areAnagrams(String, String)}
     */
    @Test
    @DisplayName("Test areAnagrams(String, String); when empty string; then return 'true'")
    void testAreAnagrams_whenEmptyString_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(IsAnagram.areAnagrams("", ""));
    }

    /**
     * Test {@link IsAnagram#areAnagrams(String, String)}.
     * <ul>
     *   <li>When {@code S1}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link IsAnagram#areAnagrams(String, String)}
     */
    @Test
    @DisplayName("Test areAnagrams(String, String); when 'S1'; then return 'false'")
    void testAreAnagrams_whenS1_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(IsAnagram.areAnagrams("S1", "S2"));
    }
}
