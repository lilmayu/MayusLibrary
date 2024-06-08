package dev.mayuna.mayuslibrary.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    public static final String TEST_STRING = "YOU CAN (NOT) REDO";
    public static final String TEST_STRING_ALT = "(YOU CAN (NOT) REDO";

    @Test
    public void testCapitalizeString() {
        assertEquals("", StringUtils.capitalizeString("", StringCapitalizeStrategy.FIRST_LETTER_ONLY, false));
        assertEquals("", StringUtils.capitalizeString("", StringCapitalizeStrategy.FIRST_LETTER_ONLY, true));
        assertEquals("", StringUtils.capitalizeString("", StringCapitalizeStrategy.EVERY_LETTER, true));
        assertEquals("", StringUtils.capitalizeString("", StringCapitalizeStrategy.EVERY_LETTER, false));

        assertEquals("!!!", StringUtils.capitalizeString("!!!", StringCapitalizeStrategy.FIRST_LETTER_ONLY, false));
        assertEquals("!!!", StringUtils.capitalizeString("!!!", StringCapitalizeStrategy.FIRST_LETTER_ONLY, true));
        assertEquals("!!!", StringUtils.capitalizeString("!!!", StringCapitalizeStrategy.EVERY_LETTER, true));
        assertEquals("!!!", StringUtils.capitalizeString("!!!", StringCapitalizeStrategy.EVERY_LETTER, false));

        assertEquals("You can (not) redo", StringUtils.capitalizeString(TEST_STRING, StringCapitalizeStrategy.FIRST_LETTER_ONLY, true));
        assertEquals("(You can (not) redo", StringUtils.capitalizeString(TEST_STRING_ALT, StringCapitalizeStrategy.FIRST_LETTER_ONLY, true));
        assertEquals("(you can (not) redo", StringUtils.capitalizeString(TEST_STRING_ALT, StringCapitalizeStrategy.FIRST_LETTER_ONLY, false));

        assertEquals("You Can (Not) Redo", StringUtils.capitalizeString(TEST_STRING, StringCapitalizeStrategy.EVERY_LETTER, true));
        assertEquals("You Can (not) Redo", StringUtils.capitalizeString(TEST_STRING, StringCapitalizeStrategy.EVERY_LETTER, false));

        assertThrows(NullPointerException.class, () -> StringUtils.capitalizeString(null, null, false));
        assertThrows(NullPointerException.class, () -> StringUtils.capitalizeString("", null, false));

        assertEquals(StringUtils.capitalizeString(TEST_STRING, StringCapitalizeStrategy.FIRST_LETTER_ONLY, true), StringUtils.capitalizeString(TEST_STRING, StringCapitalizeStrategy.FIRST_LETTER_ONLY));

        assertEquals(StringUtils.capitalizeString(TEST_STRING_ALT, StringCapitalizeStrategy.FIRST_LETTER_ONLY, true), StringUtils.capitalizeString(TEST_STRING_ALT, StringCapitalizeStrategy.FIRST_LETTER_ONLY));
        assertNotEquals(StringUtils.capitalizeString(TEST_STRING_ALT, StringCapitalizeStrategy.FIRST_LETTER_ONLY, false), StringUtils.capitalizeString(TEST_STRING_ALT, StringCapitalizeStrategy.FIRST_LETTER_ONLY));

        assertThrows(NullPointerException.class, () -> StringUtils.capitalizeString(null, null));
        assertThrows(NullPointerException.class, () -> StringUtils.capitalizeString("", null));
    }

    @Test
    public void testStartsWithAny() {
        assertTrue(StringUtils.startsWithAny(TEST_STRING, new String[]{"A", "B", "ABC", "YOU"}));
        assertTrue(StringUtils.startsWithAny(TEST_STRING, new String[]{"A", "B", "ABC", "Y"}));
        assertFalse(StringUtils.startsWithAny(TEST_STRING, new String[]{"A", "B", "ABC", "CAN"}));
        assertFalse(StringUtils.startsWithAny(TEST_STRING, new String[]{"A", "B", "ABC", "O"}));
        assertFalse(StringUtils.startsWithAny(TEST_STRING, new String[]{}));

        assertThrows(NullPointerException.class, () -> StringUtils.startsWithAny(null, null));
        assertThrows(NullPointerException.class, () -> StringUtils.startsWithAny("", null));
    }

    @Test
    public void testReplaceAny() {
        assertEquals("YWU CAN (NWT) REDW", StringUtils.replaceAny(TEST_STRING, new String[]{"O"}, "W"));
        assertEquals(TEST_STRING, StringUtils.replaceAny(TEST_STRING, new String[]{}, "W"));

        assertThrows(NullPointerException.class, () -> StringUtils.replaceAny(null, null, null));
        assertThrows(NullPointerException.class, () -> StringUtils.replaceAny("", null, null));
        assertThrows(NullPointerException.class, () -> StringUtils.replaceAny("", new String[]{}, null));
    }

    @Test
    public void testCountMatches() {
        assertEquals(0, StringUtils.countMatches("", ""));
        assertEquals(0, StringUtils.countMatches(TEST_STRING, ""));

        assertEquals(1, StringUtils.countMatches(TEST_STRING, TEST_STRING));
        assertEquals(3, StringUtils.countMatches(TEST_STRING, "O"));
        assertEquals(1, StringUtils.countMatches(TEST_STRING, "Y"));
        assertEquals(1, StringUtils.countMatches(TEST_STRING, "YOU"));
        assertEquals(0, StringUtils.countMatches(TEST_STRING, "ABC"));
        assertEquals(1, StringUtils.countMatches(TEST_STRING, "("));
        assertEquals(1, StringUtils.countMatches(TEST_STRING, ")"));
        assertEquals(3, StringUtils.countMatches(TEST_STRING, " "));

        assertThrows(NullPointerException.class, () -> StringUtils.countMatches(null, null));
        assertThrows(NullPointerException.class, () -> StringUtils.countMatches("", null));
    }
}
