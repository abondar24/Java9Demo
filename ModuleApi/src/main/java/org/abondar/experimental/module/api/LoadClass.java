package org.abondar.experimental.module.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class LoadClass {

    public static void main(String[] args) {
        loadClass("org.abondar.experimental.intro.Welcome");
        loadClass("org.abondar.experimental.intro.XYZ");

        String moduleName = "org.abondar.experimental.intro";
        Optional<Module> module = ModuleLayer.boot().findModule(moduleName);
        if (module.isPresent()){
            Module introModule = module.get();
            loadClass(introModule,"org.abondar.experimental.intro.Welcome");
            loadClass(introModule,"org.abondar.experimental.intro.ABC");
        } else {
            System.out.println("Module not found: "+moduleName+
            ". Add module to module path");
        }
    }


    private static void loadClass(String className){
            try {
                Class<?> cls = Class.forName(className);
                System.out.println("Class found: "+cls.getName());
                instantiateClass(cls);
            } catch (ClassNotFoundException e){
                System.out.println("Class not found: "+className);
            }
    }

    private static void loadClass(Module module,String className){
            Class<?> cls = Class.forName(module,className);
            if (cls == null){
                System.out.println("Class not found: "+className);
                return;
            }

            System.out.println("Class found: "+cls.getName());
            instantiateClass(cls);
    }

    private static void instantiateClass(Class<?> cls) {
         try {
             Constructor<?> constructor = cls.getConstructor();
             Object o = constructor.newInstance();
             System.out.println("Instantiated class: "+cls.getName());
         } catch (InstantiationException | IllegalAccessException |
                 IllegalArgumentException| InvocationTargetException ex){
             System.out.println(ex.getMessage());
         } catch (NoSuchMethodException ex){
             System.out.println("No no-args constructor found for class: "+cls.getName());
         }
    }
}
