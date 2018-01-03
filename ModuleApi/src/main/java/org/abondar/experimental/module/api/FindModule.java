package org.abondar.experimental.module.api;

import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;

public class FindModule {
    public static void main(String[] args) {
        Path mp1 = Paths.get("/home/abondar/IdeaProjects/Java9Demo/Intro/target/Intro-1.0.jar");
        Path mp2 = Paths.get("/home/abondar/IdeaProjects/Java9Demo/Prime/target/Prime-1.0.jar");

        ModuleFinder finder = ModuleFinder.of(mp1,mp2);
        Set<ModuleReference> moduleReferences = finder.findAll();
        moduleReferences.forEach(FindModule::printInfo);

    }

    private static void printInfo(ModuleReference moduleReference) {
        ModuleDescriptor md = moduleReference.descriptor();
        Optional<URI> location = moduleReference.location();
        URI uri = null;
        if (location.isPresent()){
            uri = location.get();
        }

        System.out.printf("Module: %s, Location: %s\n",md.name(),uri);

    }
}
