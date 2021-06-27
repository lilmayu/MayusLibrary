package lilmayu.logging;

import lilmayu.logging.coloring.ColoringString;
import lilmayu.logging.types.BaseLogType;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

    // Base
    private @Getter @Setter BaseLogType baseLogType;
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
        String formattedLog = getFormattedLogNoColors();

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

        formattedLog = formattedLog.replace("{text}", text);

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
