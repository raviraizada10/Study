package com.leetcode.essential.seventyFive.arraystring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeStringsAlternativelyTest {
    /**
     * Test {@link MergeStringsAlternatively#mergeAlternately(String, String)}.
     * <ul>
     *   <li>When {@code 42}.</li>
     *   <li>Then return {@code 4W2ord2}.</li>
     * </ul>
     * <p>
     * Method under test:
     * {@link MergeStringsAlternatively#mergeAlternately(String, String)}
     */
    @Test
    @DisplayName("Test mergeAlternately(String, String); when '42'; then return '4W2ord2'")
    void testMergeAlternately_when42_thenReturn4W2ord2() {
        // Arrange, Act and Assert
        assertEquals("4W2ord2", (new MergeStringsAlternatively()).mergeAlternately("42", "Word2"));
    }

    /**
     * Test {@link MergeStringsAlternatively#mergeAlternately(String, String)}.
     * <ul>
     *   <li>When {@code Word1}.</li>
     *   <li>Then return {@code W4o2rd1}.</li>
     * </ul>
     * <p>
     * Method under test:
     * {@link MergeStringsAlternatively#mergeAlternately(String, String)}
     */
    @Test
    @DisplayName("Test mergeAlternately(String, String); when 'Word1'; then return 'W4o2rd1'")
    void testMergeAlternately_whenWord1_thenReturnW4o2rd1() {
        // Arrange, Act and Assert
        assertEquals("W4o2rd1", (new MergeStringsAlternatively()).mergeAlternately("Word1", "42"));
    }

    /**
     * Test {@link MergeStringsAlternatively#mergeAlternately(String, String)}.
     * <ul>
     *   <li>When {@code Word1}.</li>
     *   <li>Then return {@code WWoorrdd12}.</li>
     * </ul>
     * <p>
     * Method under test:
     * {@link MergeStringsAlternatively#mergeAlternately(String, String)}
     */
    @Test
    @DisplayName("Test mergeAlternately(String, String); when 'Word1'; then return 'WWoorrdd12'")
    void testMergeAlternately_whenWord1_thenReturnWWoorrdd12() {
        // Arrange, Act and Assert
        assertEquals("WWoorrdd12", (new MergeStringsAlternatively()).mergeAlternately("Word1", "Word2"));
    }
}
