package lilmayu.logging.coloring;

import lilmayu.logging.types.BaseLogType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseColoring {

    private final @Getter List<ColoringString> coloringStrings = new ArrayList<>();

    public void addColoring(ColoringString coloringString) {
        coloringStrings.add(coloringString);
    }

    public ColoringString getColoringForLogType(BaseLogType baseLogType) {
        for (ColoringString coloringString : coloringStrings) {
            if (coloringString.getBaseLogType().equals(baseLogType)) {
                return coloringString;
            }
        }

        return null;
    }
}
