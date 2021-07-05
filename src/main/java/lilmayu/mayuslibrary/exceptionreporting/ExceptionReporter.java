package lilmayu.mayuslibrary.exceptionreporting;

import lilmayu.mayuslibrary.base.BaseListenerClass;
import lombok.Getter;

public class ExceptionReporter extends BaseListenerClass<ExceptionReport> implements Thread.UncaughtExceptionHandler {

    private static final @Getter ExceptionReporter instance = new ExceptionReporter();

    public static void registerExceptionReporter() {
        Thread.setDefaultUncaughtExceptionHandler(getInstance());
        System.setProperty("sun.awt.exception.handler", ExceptionReporter.class.getName());
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        process(new ExceptionReport(thread, throwable));
    }
}
