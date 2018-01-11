package org.abondar.experimental.streamdemo.reactive;

import java.util.concurrent.Flow;

public class SimpleSubscriber implements Flow.Subscriber<Long> {
    private Flow.Subscription subscription;

    private String name;

    //max items to be processed
    private final long maxCount;

    private long counter;

    public SimpleSubscriber(String name, long maxCount) {
        this.name = name;
        this.maxCount = maxCount <= 0 ? 1 : maxCount;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.printf("%s subscribed with max cound %d\n", name, maxCount);

        subscription.request(maxCount);
    }

    @Override
    public void onNext(Long item) {
        counter++;
        System.out.printf("%s received %d\n", name, item);

        if (counter >= maxCount) {
            System.out.printf("Cancelling %s. Processed items: %d\n", name, counter);
            subscription.cancel();
        }

    }

    @Override
    public void onError(Throwable throwable) {
        System.out.printf("An error occured in %s: %s\n",name,counter);
    }

    @Override
    public void onComplete() {
        System.out.printf("%s complete\n",name);
    }

    public String getName() {
        return name;
    }
}
