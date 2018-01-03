package org.abondar.experimental.module.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Module module = Main.class.getModule();

        Annotation[] a = module.getAnnotations();
        Arrays.asList(a).forEach(System.out::println);

        Deprecated deprecated = module.getAnnotation(Deprecated.class);
        if (deprecated!=null){
            System.out.printf("Deprecated: since: %s, forRemoval=%b\n",
                    deprecated.since(),deprecated.forRemoval());
        }

        Version version = module.getAnnotation(Version.class);
        if (version!=null){}
        System.out.printf("Version: major=%d, minor=%d\n",version.major(),version.minor());
    }
}
