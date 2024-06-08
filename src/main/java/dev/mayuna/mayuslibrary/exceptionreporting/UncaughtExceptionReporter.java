package dev.mayuna.mayuslibrary.exceptionreporting;

import lombok.Getter;
import lombok.NonNull;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Simple way to register consumers, which are invoked upon uncaught exception
 */
public final class UncaughtExceptionReporter implements Thread.UncaughtExceptionHandler {

    private static final @Getter UncaughtExceptionReporter instance = new UncaughtExceptionReporter();
    private static final List<Consumer<ExceptionReport>> exceptionReportConsumers = new LinkedList<>();

    /**
     * Registers the {@link UncaughtExceptionReporter}<br>
     * Calling this method multiple times does not yield any difference.
     */
    public static void register() {
        Thread.setDefaultUncaughtExceptionHandler(getInstance());
        System.setProperty("sun.awt.exception.handler", UncaughtExceptionReporter.class.getName());
    }

    /**
     * Adds specified {@link Consumer} with {@link ExceptionReport} to the registered exception report consumers which are invoked upon uncaught
     * exception
     *
     * @param exceptionReportConsumer Non-null {@link Consumer} with {@link ExceptionReport}
     *
     * @return true (as specified by {@link Collection#add})
     */
    public static boolean addExceptionReportConsumer(@NonNull Consumer<ExceptionReport> exceptionReportConsumer) {
        synchronized (exceptionReportConsumers) {
            return exceptionReportConsumers.add(exceptionReportConsumer);
        }
    }

    /**
     * Removes specified {@link Consumer} with {@link ExceptionReport} from the registered exception report consumers
     *
     * @param exceptionReportConsumer Non-null {@link Consumer} with {@link ExceptionReport}
     *
     * @return true if the registered exception report consumers contained the specified {@link Consumer} with {@link ExceptionReport}
     */
    public static boolean removeExceptionReportConsumer(@NonNull Consumer<ExceptionReport> exceptionReportConsumer) {
        synchronized (exceptionReportConsumers) {
            return exceptionReportConsumers.remove(exceptionReportConsumer);
        }
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        ExceptionReport exceptionReport = new ExceptionReport(thread, throwable);

        synchronized (exceptionReportConsumers) {
            exceptionReportConsumers.forEach(consumer -> consumer.accept(exceptionReport));
        }
    }
}
