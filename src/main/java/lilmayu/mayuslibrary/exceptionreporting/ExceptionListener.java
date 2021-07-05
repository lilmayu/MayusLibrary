package lilmayu.mayuslibrary.exceptionreporting;

import lilmayu.mayuslibrary.base.BaseListener;
import lombok.Getter;

import java.util.function.Consumer;

public class ExceptionListener extends BaseListener<ExceptionReport> {

    private final @Getter String packageName;

    public ExceptionListener(String name, String packageName, Consumer<ExceptionReport> consumer) {
        super(name, consumer);

        this.packageName = packageName;
    }

    public void processException(Throwable throwable, ExceptionReport exceptionReport) {
        for (StackTraceElement element : throwable.getStackTrace()) {
            if (packageName == null || element.getClassName().contains(packageName)) {
                getConsumer().accept(exceptionReport);
                break;
            }
        }
    }
}
