package dev.mayuna.mayuslibrary.arguments;

import dev.mayuna.mayuslibrary.util.NumberUtils;
import lombok.Getter;
import lombok.NonNull;

public class Argument {

    // Data
    private final @Getter String value;

    /**
     * Creates {@link Argument} with specified non-null value
     *
     * @param value Argument's value
     */
    public Argument(@NonNull String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    /**
     * Gets argument's value as {@link Number}
     *
     * @return {@link Number} if parsable, otherwise null
     */
    public Number getValueAsNumber() {
        return NumberUtils.parseNumber(value);
    }
}
