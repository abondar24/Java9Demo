package org.abondar.experimental.module.api;

import java.io.IOException;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReader;
import java.lang.module.ModuleReference;
import java.nio.ByteBuffer;
import java.util.Optional;

public class ReadModuleContents {

    public static void main(String[] args) {
        ModuleFinder moduleFinder = ModuleFinder.ofSystem();
        Optional<ModuleReference> omr = moduleFinder.find("java.base");
        ModuleReference moduleReference = omr.get();

        try (ModuleReader reader = moduleReference.open()) {
            Optional<ByteBuffer> bb = reader.read("java/lang/Object.class");
            bb.ifPresent(byteBuffer -> {
                System.out.println("Object.class Size: "+byteBuffer.limit());

                reader.release(byteBuffer);
            });

            System.out.println("\nFive resources in java.base module: ");
            reader.list().limit(5).forEach(System.out::println);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
