package lilmayu.mayuslibrary.base;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class BaseListenerClass<T> {

    private final @Getter List<BaseListener<T>> listeners = new ArrayList<>();

    public void process(T object) {
        listeners.forEach(listener -> listener.process(object));
    }

    public boolean addListener(BaseListener<T> listener) {
        return listeners.add(listener);
    }

    public boolean addListener(String name, Consumer<T> consumer) {
        return listeners.add(new BaseListener<T>(name, consumer){});
    }

    public boolean removeListener(BaseListener<T> listener) {
        return listeners.remove(listener);
    }

    public boolean removeListener(String name) {
        return listeners.remove(new BaseListener<T>(name, null) {});
    }
}
