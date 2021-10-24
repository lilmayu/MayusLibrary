package dev.mayuna.mayuslibrary.logging;

import dev.mayuna.mayuslibrary.logging.coloring.ColoringString;
import dev.mayuna.mayuslibrary.logging.types.BaseLogType;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Log {

    // Base
    private @Getter @Setter BaseLogType baseLogType;
    private @Getter @Setter String text;

    // Additional
    private @Getter @Setter Date date;
    private @Getter @Setter String className;
    private @Getter @Setter String methodName;
    private @Getter @Setter String threadName;

    // Static
    private static @Getter @Setter Consumer<String> formattedLogBeforeColoring = string -> {};
    private static @Getter @Setter BiFunction<Log, String, String> customFormatConsumer = (log, string) -> string;

    public Log(String text) {
        this.text = text;
    }

    /**
     * @deprecated Deprecated in favor for constructor with className
     */
    @Deprecated
    public Log(BaseLogType baseLogType, String text, Date date, String methodName, String threadName) {
        this.baseLogType = baseLogType;
        this.text = text;
        this.date = date;
        this.methodName = methodName;
        this.threadName = threadName;
    }

    public Log(BaseLogType baseLogType, String text, Date date, String className, String methodName, String threadName) {
        this.baseLogType = baseLogType;
        this.text = text;
        this.date = date;
        this.methodName = methodName;
        this.threadName = threadName;
        this.className = className;
    }

    // Java

    public String getFormattedLog() {
        ColoringString coloringString = Logger.getColoring().getColoringForLogType(baseLogType);
        String formattedLog = getFormattedLogNoColors();

        formattedLogBeforeColoring.accept(formattedLog);

        if (coloringString != null) {
            formattedLog = coloringString.getColor() + formattedLog + coloringString.getResetColor();
        }

        return formattedLog;
    }

    public String getFormattedLogNoColors() {
        String formattedLog = Logger.getFormat();

        if (date != null) {
            formattedLog = formattedLog.replace("{time}", new SimpleDateFormat(Logger.getTimePattern()).format(date));
        } else {
            formattedLog = formattedLog.replace("{time}", "");
        }

        if (methodName != null && threadName != null) {
            formattedLog = formattedLog.replace("{method}", methodName).replace("{thread}", threadName);
        } else {
            formattedLog = formattedLog.replace("{method}", "").replace("{thread}", "");
        }

        if (baseLogType != null) {
            formattedLog = formattedLog.replace("{type}", baseLogType.getName());
        } else {
            formattedLog = formattedLog.replace("{type}", "");
        }

        LogPrefix logPrefix = Logger.getLogPrefixByClassName(className);
        if (className != null && logPrefix != null) {
            formattedLog = formattedLog.replace("{prefix}", logPrefix.getPrefix());
        } else {
            formattedLog = formattedLog.replace("{prefix}", "");
        }

        formattedLog = formattedLog.replace("{text}", text);

        formattedLog = customFormatConsumer.apply(this, formattedLog);

        return formattedLog;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logType=" + baseLogType +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", methodName='" + methodName + '\'' +
                ", threadName='" + threadName + '\'' +
                '}';
    }
}
