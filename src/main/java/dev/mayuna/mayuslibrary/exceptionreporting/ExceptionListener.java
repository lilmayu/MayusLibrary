package dev.mayuna.mayuslibrary.exceptionreporting;

import dev.mayuna.mayuslibrary.concurrent.event.AbstractListener;
import lombok.Getter;

import java.util.function.Consumer;

public class ExceptionListener extends AbstractListener<ExceptionReport> {

    private final @Getter String packageName;

    public ExceptionListener(String name, String packageName, Consumer<ExceptionReport> consumer) {
        super(name, consumer);

        this.packageName = packageName;
    }

    @Override
    public void process(ExceptionReport exceptionReport) {
        try {
            processException(exceptionReport);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private void processException(ExceptionReport exceptionReport) {
        for (StackTraceElement element : exceptionReport.getThrowable().getStackTrace()) {
            if (packageName == null || element.getClassName().contains(packageName)) {
                getConsumer().accept(exceptionReport);
                break;
            }
        }
    }
}
