package org.abondar.experimental.streamdemo.reactive;

import java.util.Random;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class PeriodicPublisher {

    private final static int MAX_SLEEP_DURATION = 1;

    private static Random sleepTimeGenerator = new Random();

    public static void main(String[] args) {
        SubmissionPublisher<Long> pub = new SubmissionPublisher<>();

        SimpleSubscriber sub1 = new SimpleSubscriber("S1", 2);
        SimpleSubscriber sub2 = new SimpleSubscriber("S2", 5);
        SimpleSubscriber sub3 = new SimpleSubscriber("S3", 6);
        SimpleSubscriber sub4 = new SimpleSubscriber("S4", 10);

        pub.subscribe(sub1);
        pub.subscribe(sub2);
        pub.subscribe(sub3);

        subscribe(pub, sub4, 2);

        Thread pubThread = publish(pub, 5);

        try {
            pubThread.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }


    private static Thread publish(SubmissionPublisher<Long> publisher, long count) {
        Thread t = new Thread(() -> {
            for (long i = 1; i <= count; i++) {
                publisher.submit(i);
                sleep(i);
            }
            publisher.close();
        });

        t.start();
        return t;
    }

    private static void sleep(Long item) {
        int sleepTime = sleepTimeGenerator.nextInt(MAX_SLEEP_DURATION) + 1;

        try {
            System.out.printf("Published: %d. Sleeping for %d dec\n", item, sleepTime);
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void subscribe(SubmissionPublisher<Long> publisher, Flow.Subscriber<Long> subscriber,
                                  long delaySeconds) {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(delaySeconds);
                publisher.subscribe(subscriber);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }).start();
    }
}
