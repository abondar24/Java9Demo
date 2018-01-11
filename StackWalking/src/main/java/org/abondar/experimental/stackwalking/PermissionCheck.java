package org.abondar.experimental.stackwalking;

public class PermissionCheck {

    public static void main(String[] args) {
        System.out.println("Before installing security manager:");
        printStackFrames();

        SecurityManager sm = System.getSecurityManager();
        if (sm == null) {
            sm = new SecurityManager();
            System.setSecurityManager(sm);
        }

        System.out.println("After installing security manager:");
        printStackFrames();
    }

    public static void printStackFrames() {
        try {
            StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                    .forEach(System.out::println);

        } catch (SecurityException ex){
            System.out.printf("Can't create a stackwalker: %s\n",ex.getMessage());
        }
    }
}
