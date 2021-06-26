package lilmayu.logging.coloring;

import lilmayu.logging.types.BaseLogType;
import lombok.Getter;

public class ColoringString {

    private final @Getter BaseLogType baseLogType;
    private final @Getter String color;
    private @Getter String resetColor = "";

    public ColoringString(BaseLogType baseLogType, String color) {
        this.baseLogType = baseLogType;
        this.color = color;
    }

    public ColoringString(BaseLogType baseLogType, String color, String resetColor) {
        this.baseLogType = baseLogType;
        this.color = color;
        this.resetColor = resetColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof ColoringString))
            return false;

        ColoringString that = (ColoringString) o;
        return baseLogType.equals(that.baseLogType);
    }
}
