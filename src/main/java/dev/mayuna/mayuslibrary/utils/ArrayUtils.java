package dev.mayuna.mayuslibrary.utils;

import java.util.Arrays;

public class ArrayUtils {

    public static Object getLast(Object[] array) {
        if (array == null || array.length == 0)
            return null;

        return array[array.length - 1];
    }

    @Deprecated
    public static String makePrettyList(Object[] array) {
        return Arrays.toString(array);
    }

    public static String makeVerticalList(Object[] array) {
        if (array == null || array.length == 0)
            return "";

        String string = "";

        for (Object object : array) {
            string += object.toString() + "\n";
        }

        return string;
    }
}
