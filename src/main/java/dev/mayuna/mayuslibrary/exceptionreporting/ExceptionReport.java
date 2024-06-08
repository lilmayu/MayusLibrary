package dev.mayuna.mayuslibrary.exceptionreporting;

import lombok.Getter;

/**
 * Holds information about uncaught exception such as {@link Thread} and the {@link Throwable}
 */
@Getter
public final class ExceptionReport {

    private final Thread thread;
    private final Throwable throwable;

    /**
     * Creates new {@link ExceptionReport}
     *
     * @param thread    Thread on which the uncaught exception occurred
     * @param throwable The uncaught exception
     */
    public ExceptionReport(Thread thread, Throwable throwable) {
        this.thread = thread;
        this.throwable = throwable;
    }
}
