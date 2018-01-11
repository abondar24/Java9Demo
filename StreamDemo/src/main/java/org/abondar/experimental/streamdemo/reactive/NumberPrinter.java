package org.abondar.experimental.streamdemo.reactive;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.LongStream;

public class NumberPrinter {
    public static void main(String[] args) {
        CompletableFuture<Void> subTask;

        try (SubmissionPublisher<Long> pub = new SubmissionPublisher<>()){
            System.out.printf("Subscriber Buffer Size: %d\n",pub.getMaxBufferCapacity());
            subTask = pub.consume(System.out::println);

            LongStream.range(1L,6L)
                    .forEach(pub::submit);
        }

        if (subTask!=null){
            try {
                subTask.get();
            } catch (InterruptedException | ExecutionException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
