package dev.mayuna.mayuslibrary.utils;

import java.text.NumberFormat;

public class NumberUtils {

    public static boolean isNumber(String string) {
        return parseNumber(string) != null;
    }

    public static Number parseNumber(String string) {
        try {
            return NumberFormat.getNumberInstance().parse(string);
        } catch (Throwable ignored) {
            return null;
        }
    }

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
