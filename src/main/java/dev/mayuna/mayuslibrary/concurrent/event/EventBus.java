package dev.mayuna.mayuslibrary.concurrent.event;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public abstract class EventBus<T> {

    protected @Getter List<AbstractListener<T>> listeners = Collections.synchronizedList(new ArrayList<>());

    public void callAllListeners(T object) {
        listeners.forEach(listener -> listener.process(object));
    }

    public boolean addListener(AbstractListener<T> listener) {
        return listeners.add(listener);
    }

    public boolean addListener(String name, Consumer<T> consumer) {
        return listeners.add(new AbstractListener<T>(name, consumer){});
    }

    public boolean removeListener(AbstractListener<T> listener) {
        return listeners.remove(listener);
    }

    public boolean removeListener(String name) {
        return listeners.remove(new AbstractListener<T>(name, null) {});
    }
}
