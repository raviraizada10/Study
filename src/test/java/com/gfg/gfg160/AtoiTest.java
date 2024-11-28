package com.gfg.gfg160;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AtoiTest {
    /**
     * Test {@link Atoi#myAtoi(String)}.
     * <ul>
     *   <li>When {@code 42}.</li>
     *   <li>Then return forty-two.</li>
     * </ul>
     * <p>
     * Method under test: {@link Atoi#myAtoi(String)}
     */
    @Test
    @DisplayName("Test myAtoi(String); when '42'; then return forty-two")
    void testMyAtoi_when42_thenReturnFortyTwo() {
        // Arrange, Act and Assert
        assertEquals(42, (new Atoi()).myAtoi("42"));
    }

    /**
     * Test {@link Atoi#myAtoi(String)}.
     * <ul>
     *   <li>When empty string.</li>
     *   <li>Then return zero.</li>
     * </ul>
     * <p>
     * Method under test: {@link Atoi#myAtoi(String)}
     */
    @Test
    @DisplayName("Test myAtoi(String); when empty string; then return zero")
    void testMyAtoi_whenEmptyString_thenReturnZero() {
        // Arrange, Act and Assert
        assertEquals(0, (new Atoi()).myAtoi(""));
    }

    /**
     * Test {@link Atoi#myAtoi(String)}.
     * <ul>
     *   <li>When {@code foo}.</li>
     *   <li>Then return zero.</li>
     * </ul>
     * <p>
     * Method under test: {@link Atoi#myAtoi(String)}
     */
    @Test
    @DisplayName("Test myAtoi(String); when 'foo'; then return zero")
    void testMyAtoi_whenFoo_thenReturnZero() {
        // Arrange, Act and Assert
        assertEquals(0, (new Atoi()).myAtoi("foo"));
    }
}
