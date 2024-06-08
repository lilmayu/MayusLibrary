package dev.mayuna.mayuslibrary.util;

/**
 * Some stack utils
 */
public final class StackUtils {

    private StackUtils() {
    }

    /**
     * Retrieves {@link StackTraceElement} from the current thread's stack at specified index
     *
     * @param index Stack index
     *
     * @return {@link StackTraceElement}
     */
    public static StackTraceElement getStackTraceElementByIndex(int index) {
        return Thread.currentThread().getStackTrace()[index];
    }

    /**
     * Retrieves {@link StackTraceElement} of a current thread's stack, which invoked the method in which this method
     * is invoked (e.g., calls {@link #getStackTraceElementByIndex(int)} with index <code>3</code>)
     *
     * @return {@link StackTraceElement}
     */
    public static StackTraceElement getCallerStackTraceElement() {
        return getStackTraceElementByIndex(3);
    }

    /**
     * Returns class and method name by stack index in the <code>Class#Method()</code> format
     *
     * @param index Stack index
     *
     * @return class and method name in the <code>Class#Method()</code> format
     */
    public static String getClassMethodNameFromStack(int index) {
        StackTraceElement stackTraceElement = getStackTraceElementByIndex(index);
        return getLastElementOfClassHierarchy(stackTraceElement.getClassName()) + "#" + stackTraceElement.getMethodName() + "()";
    }

    /**
     * Return last element of clas hierarchy
     *
     * @param className Class name
     *
     * @return Last element
     */
    private static String getLastElementOfClassHierarchy(String className) {
        return className.substring(className.lastIndexOf(".") + 1);
    }
}
