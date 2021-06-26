package lilmayu.console.colors;

import lombok.Getter;

public class Color {

    public static String RESET = "\033[0m";

    private @Getter Colors foregroundColor = Colors.LIGHT_GRAY;
    private @Getter Colors backgroundColor = Colors.BLACK;
    private @Getter boolean isBold = false;
    private boolean hasUnderline = false;

    public Color() {
    }

    public boolean hasUnderline() {
        return this.hasUnderline;
    }

    public Color setBackground(Colors color) {
        this.backgroundColor = color;
        return this;
    }

    public Color setForeground(Colors color) {
        this.foregroundColor = color;
        return this;
    }

    public Color changeBold(boolean boldFlag) {
        this.isBold = boldFlag;
        return this;
    }

    public Color changeUnderline(boolean underlineFlag) {
        this.hasUnderline = underlineFlag;
        return this;
    }

    public String build() {
        String stringColor = "";

        // Foreground
        stringColor += "\033[" + foregroundColor.getColorNumber() + "m";

        // Background
        stringColor += "\033[" + (backgroundColor.getColorNumber() + 10) + "m";

        if (isBold)
            stringColor += "\033[1m";
        if (hasUnderline)
            stringColor += "\033[4m";

        return stringColor;
    }

    @Override
    public String toString() {
        return build();
    }
}
