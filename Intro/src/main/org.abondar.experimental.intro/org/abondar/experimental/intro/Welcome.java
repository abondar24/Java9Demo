package org.abondar.experimental.intro;

public class Welcome {

    public static void main(String[] args) {
        System.out.println("Java 9 Modular Welcome");

        Module module =  Welcome.class.getModule();
        System.out.printf("Module name: %s%n",module.getName());
    }
}
