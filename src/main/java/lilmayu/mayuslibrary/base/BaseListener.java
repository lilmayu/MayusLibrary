package lilmayu.mayuslibrary.base;

import lombok.Getter;

import java.util.function.Consumer;

public abstract class BaseListener<T> {

    private final @Getter String name;
    private final @Getter Consumer<T> consumer;

    public BaseListener(String name, Consumer<T> consumer) {
        this.name = name;
        this.consumer = consumer;
    }

    public BaseListener(Consumer<T> consumer) {
        this.name = null;
        this.consumer = consumer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof BaseListener))
            return false;

        if (name == null)
            return false;

        BaseListener<T> that = (BaseListener<T>) o;
        return name.equals(that.name);
    }

}
