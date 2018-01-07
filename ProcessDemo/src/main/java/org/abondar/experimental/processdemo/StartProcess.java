package org.abondar.experimental.processdemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class StartProcess {

    public static void main(String[] args) {
        Process p = Job.startProcess(5,7);

        if (p == null){
            System.out.println("Can't create a new process");
        }

        ProcessHandle handle = p.toHandle();
        CurrentProcessInfo.printInfo(handle);

        CompletableFuture<ProcessHandle> future = handle.onExit();

        //Print after termination
        future.thenAccept((ProcessHandle ph)-> System.out.printf("Job (pid=%d) terminated\n",ph.pid()));

        try {
            future.get();
        } catch (InterruptedException | ExecutionException ex){
            System.out.println(ex.getMessage());
        }

        CurrentProcessInfo.printInfo(handle);

    }
}
