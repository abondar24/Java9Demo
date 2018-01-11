package org.abondar.experimental.streamdemo.reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Predicate;

public class FilterProcessor<T> extends SubmissionPublisher<T> implements Flow.Processor<T,T> {

    private Predicate<? super T> filter;

    public FilterProcessor(Predicate<? super T> filter) {
        this.filter = filter;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        System.out.println("Filter received: "+item);
        if (filter.test(item)){
            this.submit(item);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        this.getExecutor().execute(()-> this.getSubscribers()
                .forEach(s->s.onError(throwable)));
    }

    @Override
    public void onComplete() {
        System.out.println("Filter is complete");

        this.close();
    }
}
