package org.abondar.experimental.streamdemo.reactive;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

public class ProcessorDemo {
    public static void main(String[] args) {
        CompletableFuture<Void> subTask;

        try (SubmissionPublisher<Long> pub = new SubmissionPublisher<>()){
            SimpleSubscriber subscriber = new SimpleSubscriber("S1",10);

            FilterProcessor<Long> filterProcessor = new FilterProcessor<>(n->n%2==0);

            pub.subscribe(filterProcessor);

            LongStream.range(1L,7L).forEach(pub::submit);
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}
