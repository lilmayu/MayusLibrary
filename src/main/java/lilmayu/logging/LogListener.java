package lilmayu.logging;

import lombok.Getter;

import java.util.Objects;
import java.util.function.Consumer;

public class LogListener {

    private final @Getter String name;
    private final @Getter Consumer<Log> consumer;

    public LogListener(String name, Consumer<Log> consumer) {
        this.name = name;
        this.consumer = consumer;
    }

    public LogListener(Consumer<Log> consumer) {
        this.name = null;
        this.consumer = consumer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof LogListener))
            return false;

        if (name == null)
            return false;

        LogListener that = (LogListener) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
