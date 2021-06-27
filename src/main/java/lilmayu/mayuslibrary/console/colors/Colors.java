package lilmayu.mayuslibrary.console.colors;

import lombok.Getter;

public enum Colors {
    BLACK(30),
    RED(31),
    GREEN(32),
    YELLOW(33),
    BLUE(34),
    MAGENTA(35),
    CYAN(36),
    LIGHT_GRAY(37),
    DARK_GRAY(90),
    LIGHT_RED(91),
    LIGHT_GREEN(92),
    LIGHT_YELLOW(93),
    LIGHT_BLUE(94),
    LIGHT_MAGENTA(95),
    LIGHT_CYAN(96),
    WHITE(97),
    RESET(0);

    private @Getter
    int colorNumber = 0;

    Colors(int i) {
        this.colorNumber = i;
    }
}
