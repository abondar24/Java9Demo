package org.abondar.experimental.module.api;

import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class LayerTest {
    public static void main(String[] args) {
        final String MODULE_LOCATION = "/home/abondar/IdeaProjects/Java9Demo/LayerInfo/target/LayerInfo-1.0.jar";

        Set<String> rootModules = Set.of("org.abondar.experimental.layer.info");
        ModuleLayer customLayer = createLayer(MODULE_LOCATION, rootModules);
        ModuleLayer bootLayer = ModuleLayer.boot();
        testLayer(bootLayer);
        System.out.println();
        testLayer(customLayer);
    }

    private static void testLayer(ModuleLayer bootLayer) {
        final String moduleName = "org.abondar.experimental.layer.info";
        final String className = "org.abondar.experimental.layer.info.LayerInfo";
        final String methodName = "printInfo";

        try {
            Class<?> cls = bootLayer.findLoader(moduleName).loadClass(className);
            Object obj = cls.getConstructor().newInstance();
            Method method = cls.getMethod(methodName);
            method.invoke(obj);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static ModuleLayer createLayer(String moduleLocation, Set<String> rootModules) {
        Path path = Paths.get(moduleLocation);

        ModuleFinder beforeFinder = ModuleFinder.of(path);
        ModuleFinder afterFinder = ModuleFinder.of();

        Configuration parentConfig = ModuleLayer.boot().configuration();
        Configuration config = parentConfig.resolve(beforeFinder, afterFinder, rootModules);

        ClassLoader sysLoader = ClassLoader.getSystemClassLoader();
        ModuleLayer parentLayer = ModuleLayer.boot();
        ModuleLayer layer = parentLayer.defineModulesWithOneLoader(config, sysLoader);
        if (layer.modules().isEmpty()) {
            System.out.println("\nModule not found " + rootModules
                    + " at " + moduleLocation + ". "
                    + "Please make sure that org.abondar.experimental.layer.info.v.2.4.jar exists at location");
        }


        return layer;
    }
}
