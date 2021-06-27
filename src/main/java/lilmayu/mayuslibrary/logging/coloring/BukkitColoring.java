package lilmayu.mayuslibrary.logging.coloring;

import lilmayu.mayuslibrary.logging.types.*;

public class BukkitColoring extends BaseColoring {

    public BukkitColoring() {
        addColoring(new ColoringString(new InfoLogType(), "§7"));
        addColoring(new ColoringString(new WarningLogType(), "§e"));
        addColoring(new ColoringString(new ErrorLogType(), "§c"));
        addColoring(new ColoringString(new DebugLogType(), "§8"));
        addColoring(new ColoringString(new TraceLogType(), "§5"));
    }
}
