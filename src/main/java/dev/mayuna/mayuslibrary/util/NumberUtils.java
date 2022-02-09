package dev.mayuna.mayuslibrary.util;

import java.text.NumberFormat;

public class NumberUtils {

    /**
     * Checks if supplied string is parsable into {@link Number} object
     * @param string String which you want to test
     * @return Returns true if is parsable, false otherwise.
     */
    public static boolean isNumber(String string) {
        return parseNumber(string) != null;
    }

    /**
     * Tries to parse supplied string as number.
     * @param string String which you want to parse
     * @return Returns {@link Number} object if parsable, null otherwise.
     */
    public static Number parseNumber(String string) {
        try {
            return NumberFormat.getNumberInstance().parse(string);
        } catch (Throwable ignored) {
            return null;
        }
    }

    /**
     * Checks if supplied string is parsable into {@link Integer} object
     * @param string String which you want to test
     * @return Returns true if is parsable, false otherwise.
     */
    public static boolean isInteger(String string) {
        return parseInteger(string) != null;
    }

    public static Integer parseInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (Throwable ignored) {
            return null;
        }
    }

    public static boolean isLong(String string) {
        return parseLong(string) != null;
    }

    public static Long parseLong(String string) {
        try {
            return Long.parseLong(string);
        } catch (Throwable ignored) {
            return null;
        }
    }

    public static boolean isFloat(String string) {
        return parseFloat(string) != null;
    }

    public static Float parseFloat(String string) {
        try {
            return Float.parseFloat(string);
        } catch (Throwable ignored) {
            return null;
        }
    }

    public static boolean isDouble(String string) {
        return parseDouble(string) != null;
    }

    public static Double parseDouble(String string) {
        try {
            return Double.parseDouble(string);
        } catch (Throwable ignored) {
            return null;
        }
    }

    public static boolean isShort(String string) {
        return parseShort(string) != null;
    }

    public static Short parseShort(String string) {
        try {
            return Short.parseShort(string);
        } catch (Throwable ignored) {
            return null;
        }
    }

    public static boolean isByte(String string) {
        return parseByte(string) != null;
    }

    public static Byte parseByte(String string) {
        try {
            return Byte.parseByte(string);
        } catch (Throwable ignored) {
            return null;
        }
    }
}
