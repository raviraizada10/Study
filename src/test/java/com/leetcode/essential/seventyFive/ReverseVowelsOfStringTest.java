package com.leetcode.essential.seventyFive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseVowelsOfStringTest {

    /**
     * Test {@link ReverseVowelsOfString#reverseVowels(String)}.
     * <ul>
     *   <li>When {@code 42}.</li>
     *   <li>Then return {@code 42}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ReverseVowelsOfString#reverseVowels(String)}
     */
    @Test
    @DisplayName("Test reverseVowels(String); when '42'; then return '42'")
    void testReverseVowels_when42_thenReturn42() {
        // Arrange, Act and Assert
        assertEquals("AceCreIm", (new ReverseVowelsOfString()).reverseVowels("IceCreAm"));
    }

}
