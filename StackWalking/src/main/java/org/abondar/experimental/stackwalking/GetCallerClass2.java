package org.abondar.experimental.stackwalking;

import java.util.Set;

public class GetCallerClass2 {

    public static void main(String[] args) {
        Set<StackWalker.Option> options = Set.of(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        GetCallerClass.m1(options);
        GetCallerClass.m2(options);
        GetCallerClass.m3(options);

        System.out.println("Calling main() method:");
        GetCallerClass.main(null);

        System.out.println("Using anonymous class:");
        new Object(){
            {
                GetCallerClass.m3(options);
            }
        };

        System.out.println("Using lambda:");
        new Thread(()->GetCallerClass.m3(options))
                .start();

    }
}
