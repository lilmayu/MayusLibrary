package dev.mayuna.mayuslibrary.util;

import lombok.NonNull;

/**
 * Some string utils
 */
public final class StringUtils {

    private StringUtils() {
    }

    /**
     * Capitalizes letters by specified settings in specified string<br>
     *
     * @param string                      String to capitalize letters in
     * @param stringCapitalizeStrategy    String capitalize strategy
     * @param skipNonAlphabeticCharacters Determines if non-alphabetic characters should be skipped and ignored
     *
     * @return Capitalized string
     */
    public static String capitalizeString(@NonNull String string, @NonNull StringCapitalizeStrategy stringCapitalizeStrategy, boolean skipNonAlphabeticCharacters) {
        if (string.isEmpty()) {
            return string;
        }

        string = string.toLowerCase();

        // First letter only
        if (stringCapitalizeStrategy == StringCapitalizeStrategy.FIRST_LETTER_ONLY) {
            int letterIndex = -1;

            if (skipNonAlphabeticCharacters) {
                for (int i = 0; i < string.length(); i++) {
                    char ch = string.charAt(i);

                    if (Character.isLetter(ch)) {
                        letterIndex = i;
                        break;
                    }
                }

                if (letterIndex == -1) {
                    return string; // No letters
                }
            } else {
                letterIndex = 0;
            }

            char[] charArray = string.toCharArray();
            charArray[letterIndex] = Character.toUpperCase(charArray[letterIndex]);
            return new String(charArray);
        }

        // Every letter
        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = true;

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (Character.isWhitespace(ch)) {
                sb.append(ch);
                capitalizeNext = true;
                continue;
            }

            if (capitalizeNext && Character.isLetter(ch)) {
                sb.append(Character.toUpperCase(ch));
                capitalizeNext = false;
                continue;
            }

            sb.append(ch);

            if (!skipNonAlphabeticCharacters) {
                capitalizeNext = false;
            }
        }

        return sb.toString();
    }

    /**
     * Invokes {@link #capitalizeString(String, StringCapitalizeStrategy, boolean)} with specified values and <code>true</code>
     *
     * @param string                   String to capitalize letters in
     * @param stringCapitalizeStrategy String capitalize strategy
     *
     * @return Capitalized string
     */
    public static String capitalizeString(@NonNull String string, @NonNull StringCapitalizeStrategy stringCapitalizeStrategy) {
        return capitalizeString(string, stringCapitalizeStrategy, true);
    }

    /**
     * Checks if string starts with any specified prefix in an array
     *
     * @param string   String to check prefixes for
     * @param prefixes Array of strings
     *
     * @return True if string starts with any specified string in an array
     */
    public static boolean startsWithAny(@NonNull String string, @NonNull String[] prefixes) {
        for (String prefix : prefixes) {
            if (string.startsWith(prefix)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Replaces any string specified in an array by specified replacement
     *
     * @param string      String to process
     * @param regexes     Array of strings to look for
     * @param replacement Replacement
     *
     * @return String with replaced all specified regexes
     */
    public static String replaceAny(@NonNull String string, @NonNull String[] regexes, @NonNull String replacement) {
        for (String regex : regexes) {
            string = string.replaceAll(regex, replacement);
        }

        return string;
    }

    /**
     * Counts the number of occurrences of one String in another.
     *
     * @param string    The string to search in.
     * @param subString The string to search for.
     *
     * @return The number of occurrences of {@code subString} in {@code string}.
     */
    public static int countMatches(@NonNull String string, @NonNull String subString) {
        if (string.isEmpty() || subString.isEmpty()) {
            return 0;
        }

        int count = 0;
        int idx = 0;
        while ((idx = string.indexOf(subString, idx)) != -1) {
            count++;
            idx += subString.length();
        }

        return count;
    }
}
