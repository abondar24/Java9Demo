package org.abondar.experimental.layer.info;

public class LayerInfo {

    private static final String VERSION = "2.4";

    static {
        System.out.println("Loading LayerInfo version: " + VERSION);
    }

    public void printInfo() {
        Class cls = this.getClass();
        ClassLoader loader = cls.getClassLoader();
        Module module = cls.getModule();
        String moduleName = module.getName();
        ModuleLayer layer = module.getLayer();

        System.out.println("Class Version: " + VERSION);
        System.out.println("Class Name: " + cls.getName());
        System.out.println("Class Loader: " + loader);
        System.out.println("Module Name: "+moduleName);
        System.out.println("Layer Name: "+layer);

    }
}
