package lilmayu.mayuslibrary.exceptionreporting;

import lombok.Getter;

public class ExceptionReport {

    private final @Getter Thread thread;
    private final @Getter Throwable throwable;

    public ExceptionReport(Thread thread, Throwable throwable) {
        this.thread = thread;
        this.throwable = throwable;
    }
}
