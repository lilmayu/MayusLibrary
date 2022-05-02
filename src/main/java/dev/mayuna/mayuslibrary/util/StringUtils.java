package dev.mayuna.mayuslibrary.util;

import lombok.NonNull;

public class StringUtils {

    /**
     * Capitalizes letters by specified settings in string<br>
     * Examples:<br>
     * (string, true, true, true) - "YOU CAN (NOT) REDO" to "You Can (not) Redo"<br>
     * (string, false, true, true) - "YOU CAN (NOT) REDO" to "You Can (Not) Redo"<br>
     * (string, false, false, true) - "YOU CAN (NOT) REDO" to "You can (not) redo"<br>
     * (string, true, true, false) - "YOU CAN (NOT) REDO" to "YOU CAN (NOT) REDO"
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

    /**
     * Capitalizes first letter in specified string<br>
     * This method is calling {@link #capitalizeString(String, boolean, boolean, boolean)} with values true, false, true
     * @param string String to capitalize letter in
     * @return Capitalized string
     */
    public static String prettyStringFirstLetter(@NonNull String string) {
        return capitalizeString(string, true, false, true);
    }

    /**
     * Capitalizes every letter after space in specified string<br>
     * This method is calling {@link #capitalizeString(String, boolean, boolean, boolean)} with values true, true, true
     * @param string String to capitalize letters in
     * @return Capitalized string
     */
    public static String prettyStringEveryLetter(String string) {
        return capitalizeString(string, true, true, true);
    }

    /**
     * Checks if string starts with any specified prefix in an array
     * @param string String to check prefixes for
     * @param prefixes Array of strings
     * @return True if string starts with any specified string in an array
     */
    public static boolean startsWithAny(String string, String[] prefixes) {
        for (String prefix : prefixes) {
            if (string.startsWith(prefix)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Replaces any string specified in an array by specified replacement
     * @param string String to process
     * @param regexes Array of strings to look for
     * @param replacement Replacement
     * @return String with replaced all specified regexes
     */
    public static String replaceAny(String string, String[] regexes, String replacement) {
        for (String regex : regexes) {
            string = string.replaceAll(regex, replacement);
        }

        return string;
    }

    /**
     * Sets character in specified index in a string
     * @param string String
     * @param character Character to set
     * @param index Index position in a string
     * @return String with replaced character at specified index
     */
    public static String setCharacter(String string, char character, int index) {
        char[] chars = string.toCharArray();
        chars[index] = character;
        return String.valueOf(chars);
    }
}
