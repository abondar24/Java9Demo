package org.abondar.experimental.module.api;

import org.abondar.experimental.prime.PrimeChecker;

import java.lang.module.ModuleDescriptor;
import java.sql.Driver;
import java.util.Set;

public class ModuleInfo {
    public static void main(String[] args) {
        Class<ModuleInfo> cls = ModuleInfo.class;
        Module module = cls.getModule();

        printInfo(module);
        System.out.println("-----------------------");

        printInfo(PrimeChecker.class.getModule());
        System.out.println("-----------------------");

        printInfo(Driver.class.getModule());
    }

    private static void printInfo(Module module) {
        String moduleName = module.getName();
        boolean isNamed = module.isNamed();

        System.out.println("Module Name: " + moduleName);
        System.out.println("Module Named: " + isNamed);

        ModuleDescriptor descriptor = module.getDescriptor();
        if (descriptor == null) {
            Set<String> currPackages = module.getPackages();
            System.out.println("Packages: " + currPackages);
        }

        System.out.println("Requires: " + descriptor.requires());
        System.out.println("Exports: " + descriptor.exports());
        System.out.println("Uses: " + descriptor.uses());
        System.out.println("Provides: "+descriptor.provides());
        System.out.println("Packages: "+descriptor.packages());


    }
}
