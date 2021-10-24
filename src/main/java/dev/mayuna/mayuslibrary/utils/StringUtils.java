package dev.mayuna.mayuslibrary.utils;

public class StringUtils {

    public static String prettyString(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }

    public static String prettyStringEx(String string) {
        int firstAlphabeticIndex = 0;
        for (Character character : string.toCharArray()) {
            if (Character.isAlphabetic(character)) {
                break;
            }

            firstAlphabeticIndex++;
        }

        char character = string.charAt(firstAlphabeticIndex);
        return setCharacter(string, Character.toUpperCase(character), firstAlphabeticIndex);
    }

    public static boolean startsWithAny(String string, String[] prefixes) {
        for (String prefix : prefixes) {
            if (string.startsWith(prefix)) {
                return true;
            }
        }

        return false;
    }

    public static String replaceAny(String string, String[] regexes, String replacement) {
        for (String regex : regexes) {
            string = string.replaceAll(regex, replacement);
        }

        return string;
    }

    public static String setCharacter(String string, char character, int index) {
        char[] chars = string.toCharArray();
        chars[index] = character;
        return String.valueOf(chars);
    }
}
