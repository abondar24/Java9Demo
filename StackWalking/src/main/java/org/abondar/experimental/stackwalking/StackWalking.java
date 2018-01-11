package org.abondar.experimental.stackwalking;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.stream.Stream;

import static java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE;
import static java.lang.StackWalker.Option.SHOW_REFLECT_FRAMES;

public class StackWalking {

    public static void main(String[] args) {
        m1(Set.of());
        System.out.println();

        m1(Set.of(RETAIN_CLASS_REFERENCE, SHOW_REFLECT_FRAMES));
    }

    public static void m1(Set<java.lang.StackWalker.Option> options) {
        m2(options);
    }

    public static void m2(Set<java.lang.StackWalker.Option> options) {
        try {
            System.out.println("Using stackwalker options: " + options);
            StackWalking.class
                    .getMethod("m3", Set.class)
                    .invoke(null, options);
        } catch (NoSuchMethodException |
                InvocationTargetException |
                IllegalAccessException |
                SecurityException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void m3(Set<java.lang.StackWalker.Option> options) {
        java.lang.StackWalker.getInstance(options)
                .walk(StackWalking::processStack);
    }

    public static Void processStack(Stream<java.lang.StackWalker.StackFrame> stackFrame) {
        stackFrame.forEach(frame -> {
            int codeIndex = frame.getByteCodeIndex();
            String className = frame.getClassName();
            Class<?> classRef = null;

            try {
                classRef = frame.getDeclaringClass();
            } catch (UnsupportedOperationException ex) {
                System.out.println(ex.getMessage());
            }

            String fileName = frame.getFileName();
            int lineNumber = frame.getLineNumber();
            String methodName = frame.getMethodName();
            boolean isNative = frame.isNativeMethod();

            StackTraceElement ste = frame.toStackTraceElement();

            System.out.printf("Native Method: %b\n",isNative);
            System.out.printf("Byte code Index: %d\n",codeIndex);
            System.out.printf("Module Name: %s\n",ste.getModuleName());
            System.out.printf("Module Version: %s\n",ste.getModuleVersion());
            System.out.printf("Class Name: %s\n",className);
            System.out.printf("Class Reference: %s\n",classRef);
            System.out.printf("File Name: %s\n",fileName);
            System.out.printf("Line Number: %s\n",lineNumber);
            System.out.printf("Method Name: %s\n",methodName);
        });

        return null;
    }


}
