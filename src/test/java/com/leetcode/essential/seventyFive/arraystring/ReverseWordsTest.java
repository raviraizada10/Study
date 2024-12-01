package com.leetcode.essential.seventyFive.arraystring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordsTest {
    /**
     * Test {@link ReverseWords#reverseWords(String)}.
     * <ul>
     *   <li>When {@code foo}.</li>
     *   <li>Then return {@code foo}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ReverseWords#reverseWords(String)}
     */
    @Test
    @DisplayName("Test reverseWords(String); when 'foo'; then return 'foo'")
    void testReverseWords_whenFoo_thenReturnFoo() {
        // Arrange, Act and Assert
        assertEquals("foo", (new ReverseWords()).reverseWords("foo"));
    }
}
