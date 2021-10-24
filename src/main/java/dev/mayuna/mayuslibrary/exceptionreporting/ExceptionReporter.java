package dev.mayuna.mayuslibrary.exceptionreporting;

import dev.mayuna.mayuslibrary.exceptions.ExceptionInExceptionReporterProcessing;
import dev.mayuna.mayuslibrary.base.BaseListenerClass;
import lombok.Getter;

public class ExceptionReporter extends BaseListenerClass<ExceptionReport> implements Thread.UncaughtExceptionHandler {

    private static final @Getter ExceptionReporter instance = new ExceptionReporter();

    public static void registerExceptionReporter() {
        Thread.setDefaultUncaughtExceptionHandler(getInstance());
        System.setProperty("sun.awt.exception.handler", ExceptionReporter.class.getName());
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (throwable instanceof ExceptionInExceptionReporterProcessing) {
            throwable.printStackTrace();
            return;
        }

        try {
            process(new ExceptionReport(thread, throwable));
        } catch (Throwable exception) {
            throw new ExceptionInExceptionReporterProcessing("Another exception occurred while processing uncaught exception in ExceptionReporter!", throwable);
        }
    }
}
