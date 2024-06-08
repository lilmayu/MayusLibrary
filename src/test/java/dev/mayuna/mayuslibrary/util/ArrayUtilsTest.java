package dev.mayuna.mayuslibrary.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {

    public static final Integer[] TEST_ARRAY = new Integer[]{0, 1, 2, 3, 4};

    @Test
    public void testGetLast() {
        assertEquals(TEST_ARRAY[TEST_ARRAY.length - 1], ArrayUtils.getLast(TEST_ARRAY));
        assertNotEquals(TEST_ARRAY[TEST_ARRAY.length - 2], ArrayUtils.getLast(TEST_ARRAY));
        assertNotEquals(TEST_ARRAY[0], ArrayUtils.getLast(TEST_ARRAY));

        //noinspection ConstantValue
        assertEquals((Object)null, ArrayUtils.getLast(null));
        //noinspection SimplifiableAssertion
        assertEquals(null, ArrayUtils.getLast(new Object[]{}));
    }

    @Test
    public void testIsLast() {
        assertTrue(ArrayUtils.isLast(ArrayUtils.getLast(TEST_ARRAY), TEST_ARRAY));
        assertFalse(ArrayUtils.isLast(TEST_ARRAY[0], TEST_ARRAY));

        assertFalse(ArrayUtils.isLast(null, null));
    }
}
