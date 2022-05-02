package dev.mayuna.mayuslibrary.util;

public class ArrayUtils {

    /**
     * Gets last element from array.
     * @param array Array
     * @return Returns null if supplied array is null or is empty. Otherwise, returns last element from array.
     */
    public static Object getLast(Object[] array) {
        if (array == null || array.length == 0)
            return null;

        return array[array.length - 1];
    }

    /**
     * Formats array into vertical list with specified delimiter <br>
     * Example:<br>
     * Supplied array: [0, 1, 2, 3, 4]<br>
     * Supplied delimiter: ","<br>
     * Returned String:<br>
     * 0,<br>
     * 1,<br>
     * 2,<br>
     * 3,<br>
     * 4<br>
     * @param array Array
     * @param delimiter Delimiter which will be inserted at the end of line
     * @return Returns empty string if supplied array is null or empty. Otherwise, returns string in said format.
     */
    public static String formatVerticalList(Object[] array, String delimiter) {
        if (array == null || array.length == 0)
            return "";

        String string = "";

        for (Object object : array) {
            string += object.toString() + delimiter + "\n";
        }

        return string;
    }

    /**
     * Formats array into vertical list with empty delimiter
     * @see #formatVerticalList(Object[], String) #formatVerticalList(Object[], String) for more infomation
     * @param array Array
     * @return Returns empty string if supplied array is null or empty. Otherwise, returns string in said format.
     */
    public static String formatVerticalList(Object[] array) {
        return formatVerticalList(array, "");
    }
}
