package org.abondar.experimental.stackwalking;

import java.lang.StackWalker;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import static java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE;
import static java.lang.StackWalker.Option.SHOW_REFLECT_FRAMES;

public class GetCallerClass {
    public static void main(String[] args) {
        m1(Set.of());
        m1(Set.of(RETAIN_CLASS_REFERENCE, SHOW_REFLECT_FRAMES));

        try {
            Class<?> cls = StackWalker.getInstance(RETAIN_CLASS_REFERENCE).getCallerClass();
            System.out.printf("In main method, Caller Class: %s\n", cls.getName());
        } catch (IllegalCallerException ex) {
            System.out.printf("In main method,Exception: %s\n", ex.getMessage());
        }

    }

    public static void m1(Set<StackWalker.Option> options) {
        m2(options);
    }

    public static void m2(Set<java.lang.StackWalker.Option> options) {
        try {
            GetCallerClass.class
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
        try {
            Class<?> cls = StackWalker.getInstance(options)
                    .getCallerClass();
            System.out.printf("Caller class: %s\n",cls.getName());
        } catch (UnsupportedOperationException ex){
            System.out.printf("Inside m3(): %s\n",ex.getMessage());
        }
    }
}
