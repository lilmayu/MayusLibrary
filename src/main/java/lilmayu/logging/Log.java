package lilmayu.logging;

import lilmayu.logging.coloring.BaseColoring;
import lilmayu.logging.coloring.ColoringString;
import lilmayu.logging.types.BaseLogType;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

    // Base
    private @Getter @Setter BaseLogType baseLogType;
    private @Getter @Setter String additionalFormatting;
    private @Getter @Setter String text;

    // Additional
    private @Getter @Setter Date date;
    private @Getter @Setter String methodName;
    private @Getter @Setter String threadName;

    public Log(String text) {
        this.text = text;
    }

    public Log(BaseLogType baseLogType, String text, Date date, String methodName, String threadName) {
        this.baseLogType = baseLogType;
        this.text = text;
        this.date = date;
        this.methodName = methodName;
        this.threadName = threadName;
    }

    // Java

    public String getFormattedLog() {
        ColoringString coloringString = Logger.getColoring().getColoringForLogType(baseLogType);
        String formattedLog = "";

        if (coloringString != null) {
            formattedLog += coloringString.getColor();
        }

        if (date != null) {
            formattedLog += "[" + new SimpleDateFormat(Logger.getTimePattern()).format(date) + "]";
        }

        if (methodName != null && threadName != null) {
            formattedLog += "[" + methodName + "/" + threadName + "]";
        }

        if (baseLogType != null) {
            formattedLog += "[" + baseLogType.getName() + "]";
        }

        if (additionalFormatting != null) {
            formattedLog += additionalFormatting;
        }

        formattedLog += ": " + text;

        if (coloringString != null) {
            formattedLog += coloringString.getResetColor();
        }

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
