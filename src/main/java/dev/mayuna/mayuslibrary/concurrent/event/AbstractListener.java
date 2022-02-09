package dev.mayuna.mayuslibrary.concurrent.event;

import lombok.Getter;

import java.util.UUID;
import java.util.function.Consumer;

public abstract class AbstractListener<T> {

    private final @Getter String name;
    private final @Getter Consumer<T> consumer;

    public AbstractListener(String name, Consumer<T> consumer) {
        this.name = name;
        this.consumer = consumer;
    }

    public AbstractListener(Consumer<T> consumer) {
        this.name = UUID.randomUUID().toString();
        this.consumer = consumer;
    }

    public void process(T object) {
        consumer.accept(object);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof AbstractListener))
            return false;

        if (name == null)
            return false;

        AbstractListener that = (AbstractListener) o;
        return name.equals(that.name);
    }

}
