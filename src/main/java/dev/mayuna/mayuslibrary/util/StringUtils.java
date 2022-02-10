package dev.mayuna.mayuslibrary.util;

import lombok.NonNull;

public class StringUtils {

    /**
     * Capitalizes letters by specified settings in string<br>
     * Examples:<br>
     * (string, true, true, true) - "YOU CAN (NOT) REDO" -> "You Can (not) Redo"<br>
     * (string, false, true, true) - "YOU CAN (NOT) REDO" -> "You Can (Not) Redo"<br>
     * (string, false, false, true) - "YOU CAN (NOT) REDO" -> "You can (not) redo"<br>
     * (string, true, true, false) - "YOU CAN (NOT) REDO" -> "YOU CAN (NOT) REDO"
     * @param string String to capitalize letters in
     * @param skipNonAlphabeticCharacters Determines if non-alphabetic characters should be skipped and ignored
     * @param capitalizeEvery Determines if all letters after space should be capitalized
     * @param normalize Formats string to lower case before capitalization
     * @return Capitalized string
     */
    public static String capitalizeString(@NonNull String string, boolean skipNonAlphabeticCharacters, boolean capitalizeEvery, boolean normalize) {
        if (normalize) {
            string = string.toLowerCase();
        }

        char[] charArray = string.toCharArray();

        for (int index = 0; index < charArray.length; index++) {
            boolean shouldCapitalize = false;

            if (index == 0) {
                shouldCapitalize = true;
            } else {
                if (charArray[index - 1] == ' ') {
                    shouldCapitalize = true;
                }
            }

            if (shouldCapitalize) {
                if (!skipNonAlphabeticCharacters || Character.isAlphabetic(charArray[index])) {
                    setCharacter(string, Character.toUpperCase(charArray[index]), index);

                    if (!capitalizeEvery) {
                        return string;
                    }
                }
            }
        }

        return string;
    }

    public static String prettyStringFirstLetter(String string) {
        return capitalizeString(string, true, false, true);
    }

    public static String prettyStringEveryLetter(String string) {
        return capitalizeString(string, true, true, true);
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
