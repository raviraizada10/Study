package com.gfg.gfg160;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddBinaryTest {
    /**
     * Test {@link AddBinary#addBinary(String, String)}.
     * <ul>
     *   <li>When {@code 0}.</li>
     *   <li>Then return {@code 1001000}.</li>
     * </ul>
     * <p>
     * Method under test: {@link AddBinary#addBinary(String, String)}
     */
    @Test
    @DisplayName("Test addBinary(String, String); when '0'; then return '1001000'")
    void testAddBinary_when0_thenReturn1001000() {
        // Arrange, Act and Assert
        assertEquals("1001000", (new AddBinary()).addBinary("0", "S2"));
    }

    /**
     * Test {@link AddBinary#addBinary(String, String)}.
     * <ul>
     *   <li>When {@code S1}.</li>
     *   <li>Then return {@code 10001111}.</li>
     * </ul>
     * <p>
     * Method under test: {@link AddBinary#addBinary(String, String)}
     */
    @Test
    @DisplayName("Test addBinary(String, String); when 'S1'; then return '10001111'")
    void testAddBinary_whenS1_thenReturn10001111() {
        // Arrange, Act and Assert
        assertEquals("10001111", (new AddBinary()).addBinary("S1", "S2"));
    }
}
