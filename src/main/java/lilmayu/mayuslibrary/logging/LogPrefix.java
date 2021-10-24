package lilmayu.mayuslibrary.logging;

import lombok.Getter;

public class LogPrefix {

    private final @Getter String prefix;
    private final @Getter Class<?> clazz;

    public LogPrefix(String prefix, Class<?> clazz) {
        this.prefix = prefix;
        this.clazz = clazz;
    }
}
