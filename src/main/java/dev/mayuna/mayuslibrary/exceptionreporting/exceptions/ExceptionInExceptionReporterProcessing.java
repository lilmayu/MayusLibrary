package dev.mayuna.mayuslibrary.exceptionreporting.exceptions;

public class ExceptionInExceptionReporterProcessing extends RuntimeException {

    public ExceptionInExceptionReporterProcessing(String message, Throwable throwable) {
        super(message, throwable);
    }
}
