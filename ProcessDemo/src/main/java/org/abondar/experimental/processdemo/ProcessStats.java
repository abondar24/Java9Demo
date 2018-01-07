package org.abondar.experimental.processdemo;

import java.time.Duration;
import java.time.Instant;

public class ProcessStats {

    public static void main(String[] args) {
        System.out.println("Longest CPU User Process:");
        ProcessHandle.allProcesses()
                .max(ProcessStats::compareCPUtime)
                .ifPresent(CurrentProcessInfo::printInfo);

        System.out.println("\nLongest Running Process:");
        ProcessHandle.allProcesses()
                .max(ProcessStats::compareStartTime)
                .ifPresent(CurrentProcessInfo::printInfo);
    }

    private static int compareStartTime(ProcessHandle ph1, ProcessHandle ph2) {
        return ph1.info()
                .startInstant()
                .orElse(Instant.now())
                .compareTo(ph2.info()
                        .startInstant()
                        .orElse(Instant.now()));
    }

    private static int compareCPUtime(ProcessHandle ph1, ProcessHandle ph2) {
        return ph1.info()
                .totalCpuDuration()
                .orElse(Duration.ZERO)
                .compareTo(ph2.info()
                        .totalCpuDuration()
                        .orElse(Duration.ZERO));

    }
}
