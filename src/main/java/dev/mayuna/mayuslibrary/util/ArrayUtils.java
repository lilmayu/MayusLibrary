package dev.mayuna.mayuslibrary.util;

/**
 * Some array utils
 */
public final class ArrayUtils {

    private ArrayUtils() {
    }

    /**
     * Gets last element from an array.
     *
     * @param array Array
     *
     * @return Returns null if supplied array is null or is empty. Otherwise, returns last element from array.
     */
    public static <T> T getLast(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        return array[array.length - 1];
    }


    /**
     * Checks whenever the supplied object is the last object in supplied array
     *
     * @param object Object
     * @param array  Array
     *
     * @return True if supplied object is last in supplied array, false otherwise; false can be also returned if the array is null or empty
     */
    public static <T> boolean isLast(T object, T[] array) {
        T lastObject = getLast(array);

        if (lastObject == null) {
            return false;
        }

        return lastObject.equals(object);
    }
}
