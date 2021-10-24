package dev.mayuna.mayuslibrary.exceptions;

public class ExceptionInExceptionReporterProcessing extends RuntimeException {

    public ExceptionInExceptionReporterProcessing(String text, Throwable throwable) {
        super(text, throwable);
    }
}
