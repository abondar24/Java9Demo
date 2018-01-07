package org.abondar.experimental.processdemo;

import java.util.concurrent.ExecutionException;

public class ManagingProcessPermission {
    public static void main(String[] args) {
        long count = ProcessHandle.allProcesses().count();
        System.out.printf("Process count: %d\n", count);

        Process p = Job.startProcess(5, 15);

        try {
            p.toHandle().onExit().get();
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex.getMessage());
        }

        SecurityManager sm = System.getSecurityManager();
        if (sm == null) {
            System.setSecurityManager(new SecurityManager());
            System.out.println("Security manager installed");
        }

        try {
            count = ProcessHandle.allProcesses().count();
            System.out.printf("Process count: %d\n", count);
        } catch (RuntimeException ex) {
            System.out.printf("Can't get a process count: %s", ex.getMessage());
        }


        try {
            p.toHandle().onExit().get();
        } catch (InterruptedException | ExecutionException | RuntimeException ex) {
            System.out.printf("Can't get a process count: %s", ex.getMessage());
        }
    }
}
