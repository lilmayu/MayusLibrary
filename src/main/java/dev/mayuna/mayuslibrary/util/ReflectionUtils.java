package dev.mayuna.mayuslibrary.util;

import java.lang.reflect.Method;

public class ReflectionUtils {

    /**
     * Retrieves method name from stack at specified index
     * @param index Index
     * @return Method name, if no exception occurred, otherwise null
     */
    public static String getMethodNameFromStack(int index) {
        try {
            return Thread.currentThread().getStackTrace()[index].getMethodName();
        } catch (Exception ignored) {
            return null;
        }
    }

    /**
     * Retrieves class name from stack at specified index
     * @param index Index
     * @return Class name, if no exception occurred, otherwise null
     */
    public static String getClassNameFromStack(int index) {
        try {
            return Thread.currentThread().getStackTrace()[index].getClassName();
        } catch (Exception ignored) {
            return null;
        }
    }

    /**
     * Retrieves {@link Method} object from stack at specified index
     * @param index Index
     * @return {@link Method} object, if no exception occurred, otherwise null
     */
    public static Method getMethodFromStack(int index) {
        try {
            String methodName = getMethodNameFromStack(index + 1);
            Class<?> clazz = getClassFromStack(index + 2);
            return clazz.getMethod(methodName);
        } catch (Exception ignored) {
            return null;
        }
    }

    /**
     * Retrieves {@link Class} object from stack at specified index
     * @param index Index
     * @return {@link Class} object, if no exception occurred, otherwise null
     */
    public static Class<?> getClassFromStack(int index) {
        try {
            String className = getClassNameFromStack(index + 1);
            return Class.forName(className);
        } catch (Exception ignored) {
            return null;
        }
    }
}
