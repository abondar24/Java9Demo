package org.abondar.experimental.processdemo;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;

public class CurrentProcessInfo {

    public static void main(String[] args) {
        ProcessHandle current = ProcessHandle.current();

        printInfo(current);
    }

    public static void printInfo(ProcessHandle handle) {
        long pid = handle.pid();

        boolean isAlive = handle.isAlive();

        ProcessHandle.Info info = handle.info();
        String cmd = info.command().orElse("");
        String [] args = info.arguments().orElse(new String[]{});
        String commandLine = info.commandLine().orElse("");
        ZonedDateTime startTime = info.startInstant().orElse(Instant.now()).atZone(ZoneId.systemDefault());
        Duration duration = info.totalCpuDuration().orElse(Duration.ZERO);
        String owner = info.user().orElse("Unknown");
        long childrenCount = handle.children().count();

        System.out.printf("PID: %d\n",pid);
        System.out.printf("IsAlive: %b\n",isAlive);
        System.out.printf("Command: %s\n",cmd);
        System.out.printf("Arguments: %s\n", Arrays.asList(args));
        System.out.printf("CommandLine: %s\n",commandLine);
        System.out.printf("Start time: %s\n",startTime);
        System.out.printf("CPU time: %s\n",duration);
        System.out.printf("Owner: %s\n",owner);
        System.out.printf("Children count: %s\n",childrenCount);
    }
}
