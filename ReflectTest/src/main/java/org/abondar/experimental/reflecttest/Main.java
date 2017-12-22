package org.abondar.experimental.reflecttest;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("org.abondar.experimental.reflect.Item");

        Field[] fields = cls.getDeclaredFields();
        for (Field f: fields){
            printFieldVal(f);
        }
    }

    private static void printFieldVal(Field f) throws Exception {
        String fieldName = f.getName();

        f.setAccessible(true);
        System.out.println(fieldName+" : "+f.get(null));
    }
}
