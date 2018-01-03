package org.abondar.experimental.resources.access;

import org.abondar.experimental.resources.exported.AppResource;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        String[] resources = {
                "java/lang/Object.class",
                "org/abondar/experimental/resources/access/own.properties",
                "org/abondar/experimental/resources/access/Main.class",
                "ss1.properties",
                "META-INF/ss2.properties",
                "org/abondar/experimental/resources/opened/opened.properties",
                "org/abondar/experimental/resources/exported/AppResource.class",
                "org/abondar/experimental/resources/exported/exported.properties",
                "org/abondar/experimental/resources/encapsulated/Encapsulated.class",
                "org/abondar/experimental/resources/encapsulated/encapsulated.properties"
        };


        System.out.println("Using a module!\n");
        Module otherModule = AppResource.class.getModule();
        for (String res : resources) {
            lookupResource(otherModule, res);
        }

        System.out.println("\nUsing a class!\n");
        Class cls = Main.class;
        for (String res : resources) {
            lookupResource(cls, "/" + res);
        }

        System.out.println("\nUsing the System Classloader!\n");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        for (String res : resources) {
            lookupResource(classLoader, res);
        }

        System.out.println("\nUsing the Platform Classloader!\n");
        ClassLoader platformClassLoader = ClassLoader.getPlatformClassLoader();
        for (String res : resources) {
            lookupResource(platformClassLoader, res);
        }
    }

    private static void lookupResource(Module module, String resource) {
        try {
            InputStream is = module.getResourceAsStream(resource);
            print(resource, is);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    private static void lookupResource(Class cls, String resource) {
        InputStream is = cls.getResourceAsStream(resource);
        print(resource, is);
    }

    private static void lookupResource(ClassLoader classLoader, String resource) {
        InputStream is = classLoader.getResourceAsStream(resource);
        print(resource, is);
    }

    private static void print(String resource, InputStream is) {
        if (is != null) {
            System.out.println("Found: " + resource);
        } else {
            System.out.println("Not Found: " + resource);
        }
    }
}
