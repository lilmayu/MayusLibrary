package dev.mayuna.mayuslibrary.exceptionreporting;

import dev.mayuna.mayuslibrary.exceptionreporting.exceptions.ExceptionInExceptionReporterProcessing;
import dev.mayuna.mayuslibrary.concurrent.event.EventBus;
import lombok.Getter;

public class ExceptionReporter extends EventBus<ExceptionReport> implements Thread.UncaughtExceptionHandler {

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
            callAllListeners(new ExceptionReport(thread, throwable));
        } catch (Throwable exception) {
            throw new ExceptionInExceptionReporterProcessing("Another exception occurred while processing uncaught exception in ExceptionReporter!", throwable);
        }
    }
}
