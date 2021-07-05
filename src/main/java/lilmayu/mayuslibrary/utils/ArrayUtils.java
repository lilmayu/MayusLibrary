package lilmayu.mayuslibrary.utils;

public class ArrayUtils {

    public static Object getLast(Object[] array) {
        if (array.length == 0)
            return null;
        return array[array.length - 1];
    }

    public static String makePrettyList(Object[] array) {
        if (array.length == 0)
            return "";
        String fullString = "";
        for (Object object : array) {
            fullString += object.toString();
            if (!object.equals(getLast(array))) {
                fullString += ", ";
            }
        }
        return fullString;
    }

    public static String makeVerticalList(Object[] array) {
        String string = "";

        for (Object object : array) {
            string += object.toString() + "\n";
        }

        return string;
    }
}
