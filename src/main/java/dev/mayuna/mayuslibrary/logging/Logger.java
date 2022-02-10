package dev.mayuna.mayuslibrary.logging;

import dev.mayuna.mayuslibrary.logging.coloring.BaseColoring;
import dev.mayuna.mayuslibrary.logging.coloring.ColoringString;
import dev.mayuna.mayuslibrary.logging.coloring.ConsoleColoring;
import dev.mayuna.mayuslibrary.logging.types.*;
import dev.mayuna.mayuslibrary.util.ReflectionUtils;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

public class Logger {

    // Listeners
    private static final @Getter List<LogListener> beforeLogListeners = new ArrayList<>();
    private static final @Getter List<LogListener> logListeners = new ArrayList<>();

    // Runtime
    private static final @Getter List<Log> logs = new ArrayList<>();
    private static final @Getter List<LogPrefix> prefixes = new ArrayList<>();

    // Settings
    private static @Getter @Setter boolean saveLogsToList = false;
    private static @Getter @Setter boolean saveLogsToFile = false;
    private static @Getter @Setter String fileName = "log.txt";
    private static @Getter @Setter String timePattern = "HH:mm:ss.sss";
    private static @Getter @Setter String format = "[{time}][{method}/{thread}][{type}]:{prefix} {text}";
    private static @Getter @Setter BaseColoring coloring = new ConsoleColoring();

    // Default values
    public static Consumer<Log> printLogic = log -> {
        System.out.println(log.getFormattedLog());
    };

    public static int reflectionDepth = 4;

    // = Main

    public static void info(String text) {
        processLog(new InfoLogType(), text);
    }

    public static void warning(String text) {
        processLog(new WarningLogType(), text);
    }

    public static void error(String text) {
        processLog(new ErrorLogType(), text);
    }

    public static void debug(String text) {
        processLog(new DebugLogType(), text);
    }

    public static void trace(String text) {
        processLog(new TraceLogType(), text);
    }

    public static void custom(BaseLogType baseLogType, String text) {
        processLog(baseLogType, text);
    }

    public static void processLog(BaseLogType baseLogType, String text) {
        String methodName = ReflectionUtils.getMethodNameFromStack(reflectionDepth);
        String className = ReflectionUtils.getClassNameFromStack(reflectionDepth);
        processLog(new Log(baseLogType, text, new Date(System.currentTimeMillis()), className, methodName, Thread.currentThread()
                .getName()));
    }

    public static void processLog(Log log) {
        beforeLogListeners.forEach(beforeLogListener -> {
            beforeLogListener.getConsumer().accept(log);
        });

        if (saveLogsToList) {
            logs.add(log);
        }

        if (saveLogsToFile) {
            try {
                Files.write(Paths.get(fileName), (log.getFormattedLogNoColors() + "\n").getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            } catch (IOException exception) {
                throw new RuntimeException("Error occurred while writing log to file (" + fileName + ")!", exception);
            }
        }

        printLogic.accept(log);
        logListeners.forEach(logListener -> logListener.getConsumer().accept(log));
    }

    // = Other

    // - LogListeners

    public static void addLogListener(LogListener logListener) {
        logListeners.add(logListener);
    }

    public static void removeLogListener(LogListener logListener) {
        logListeners.remove(logListener);
    }

    public static void removeLogListener(String name) {
        logListeners.remove(new LogListener(name, null));
    }

    // - BeforeLogListeners

    public static void addBeforeLogListener(LogListener logListener) {
        beforeLogListeners.add(logListener);
    }

    public static void removeBeforeLogListener(LogListener logListener) {
        beforeLogListeners.remove(logListener);
    }

    public static void removeBeforeLogListener(String name) {
        beforeLogListeners.remove(new LogListener(name, null));
    }

    // - Coloring

    public static void addColoringString(ColoringString coloringString) {
        getColoring().addColoring(coloringString);
    }

    // - Prefixes

    public static void addLogPrefix(LogPrefix logPrefix) {
        prefixes.add(logPrefix);
    }

    public static LogPrefix getLogPrefixByClassName(String className) {
        for (LogPrefix logPrefix : prefixes) {
            if (logPrefix.getClazz().getName().equalsIgnoreCase(className)) {
                return logPrefix;
            }
        }

        return null;
    }
}
