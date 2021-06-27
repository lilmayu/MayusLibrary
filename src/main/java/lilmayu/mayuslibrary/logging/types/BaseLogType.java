package lilmayu.mayuslibrary.logging.types;

public abstract class BaseLogType {

    public abstract String getName();

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof BaseLogType))
            return false;

        BaseLogType that = (BaseLogType) o;
        return getName().equals(that.getName());
    }
}
