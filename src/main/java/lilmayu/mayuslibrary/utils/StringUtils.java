package lilmayu.mayuslibrary.utils;

public class StringUtils {

    public static String prettyString(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }
}
