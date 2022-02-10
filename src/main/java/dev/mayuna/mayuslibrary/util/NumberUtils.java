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

    /**
     * Tries to parse supplied string as {@link Integer} object
     * @param string String which you want to parse
     * @return Returns {@link Integer} object if parsable, null otherwise.
     */
    public static Integer parseInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (Throwable ignored) {
            return null;
        }
    }

    /**
     * Checks if supplied string is parsable into {@link Long} object
     * @param string String which you want to test
     * @return Returns true if is parsable, false otherwise.
     */
    public static boolean isLong(String string) {
        return parseLong(string) != null;
    }

    /**
     * Tries to parse supplied string as {@link Long} object
     * @param string String which you want to parse
     * @return Returns {@link Long} object if parsable, null otherwise.
     */
    public static Long parseLong(String string) {
        try {
            return Long.parseLong(string);
        } catch (Throwable ignored) {
            return null;
        }
    }

    /**
     * Checks if supplied string is parsable into {@link Float} object
     * @param string String which you want to test
     * @return Returns true if is parsable, false otherwise.
     */
    public static boolean isFloat(String string) {
        return parseFloat(string) != null;
    }

    /**
     * Tries to parse supplied string as {@link Float} object
     * @param string String which you want to parse
     * @return Returns {@link Float} object if parsable, null otherwise.
     */
    public static Float parseFloat(String string) {
        try {
            return Float.parseFloat(string);
        } catch (Throwable ignored) {
            return null;
        }
    }

    /**
     * Checks if supplied string is parsable into {@link Double} object
     * @param string String which you want to test
     * @return Returns true if is parsable, false otherwise.
     */
    public static boolean isDouble(String string) {
        return parseDouble(string) != null;
    }

    /**
     * Tries to parse supplied string as {@link Double} object
     * @param string String which you want to parse
     * @return Returns {@link Double} object if parsable, null otherwise.
     */
    public static Double parseDouble(String string) {
        try {
            return Double.parseDouble(string);
        } catch (Throwable ignored) {
            return null;
        }
    }

    /**
     * Checks if supplied string is parsable into {@link Short} object
     * @param string String which you want to test
     * @return Returns true if is parsable, false otherwise.
     */
    public static boolean isShort(String string) {
        return parseShort(string) != null;
    }

    /**
     * Tries to parse supplied string as {@link Short} object
     * @param string String which you want to parse
     * @return Returns {@link Short} object if parsable, null otherwise.
     */
    public static Short parseShort(String string) {
        try {
            return Short.parseShort(string);
        } catch (Throwable ignored) {
            return null;
        }
    }

    /**
     * Checks if supplied string is parsable into {@link Byte} object
     * @param string String which you want to test
     * @return Returns true if is parsable, false otherwise.
     */
    public static boolean isByte(String string) {
        return parseByte(string) != null;
    }

    /**
     * Tries to parse supplied string as {@link Byte} object
     * @param string String which you want to parse
     * @return Returns {@link Byte} object if parsable, null otherwise.
     */
    public static Byte parseByte(String string) {
        try {
            return Byte.parseByte(string);
        } catch (Throwable ignored) {
            return null;
        }
    }
}
