package dev.mayuna.mayuslibrary.utils.objects;

import lombok.Getter;

public class ParsedStackTraceElement {

    // Core
    private final @Getter StackTraceElement stackTraceElement;

    // Parsed data
    private @Getter String className;

    public ParsedStackTraceElement(StackTraceElement stackTraceElement) {
        this.stackTraceElement = stackTraceElement;
        parse();
    }

    private void parse() {
        String fullClassName = getFullyQualifiedClassName();

        className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
    }

    public String getFullyQualifiedClassName() {
        return stackTraceElement.getClassName();
    }

    public String getMethodName() {
        return stackTraceElement.getMethodName();
    }

    public String getFileName() {
        return stackTraceElement.getFileName();
    }

    public int getLineNumber() {
        return stackTraceElement.getLineNumber();
    }

    public boolean isNativeMethod() {
        return stackTraceElement.isNativeMethod();
    }
}
