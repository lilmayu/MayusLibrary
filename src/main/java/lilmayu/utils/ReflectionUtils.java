package lilmayu.utils;

import java.lang.reflect.Method;

public class ReflectionUtils {

    public static String getMethodNameFromStack(int num) {
        return Thread.currentThread().getStackTrace()[num].getMethodName();
    }

    public static String getClassNameFromStack(int num) {
        return Thread.currentThread().getStackTrace()[num].getClassName();
    }

    public static Method getMethodFromStack(int num) throws ClassNotFoundException, NoSuchMethodException {
        String methodName = getMethodNameFromStack(num + 1);
        Class<?> clazz = getClassFromStack(num + 2);
        return clazz.getMethod(methodName);
    }

    public static Class<?> getClassFromStack(int num) throws ClassNotFoundException {
        String className = getClassNameFromStack(num + 1);
        return Class.forName(className);
    }
}
