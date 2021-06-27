package lilmayu.logging.coloring;

import lilmayu.console.colors.Color;
import lilmayu.console.colors.Colors;
import lilmayu.logging.types.*;

public class ConsoleColoring extends BaseColoring {

    public ConsoleColoring() {
        addColoring(new ColoringString(new InfoLogType(), new Color().setForeground(Colors.LIGHT_GRAY).build(), Color.RESET));
        addColoring(new ColoringString(new WarningLogType(), new Color().setForeground(Colors.LIGHT_YELLOW).build(), Color.RESET));
        addColoring(new ColoringString(new ErrorLogType(), new Color().setForeground(Colors.RED).build(), Color.RESET));
        addColoring(new ColoringString(new DebugLogType(), new Color().setForeground(Colors.DARK_GRAY).build(), Color.RESET));
        addColoring(new ColoringString(new TraceLogType(), new Color().setForeground(Colors.MAGENTA).build(), Color.RESET));
    }
}
