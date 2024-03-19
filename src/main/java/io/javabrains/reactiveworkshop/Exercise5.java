package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        System.out.println("***** Exercise 1 *****");
        ReactiveSources.intNumberMono()
                .subscribe(
                        number -> System.out.println("number " + number + " emitted"),  // This is called for each value emitted.
                        throwable -> System.out.println("Error: " + throwable),         // This is called for an error emitted.
                        () -> System.out.println("The mono has completed"));            // This is called when the mono/flux has completed.


        // Subscribe to a flux using an implementation of BaseSubscriber
        System.out.println("***** Exercise 1 *****");
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());


        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe happened");
        request(1);     // Immediately request 1 item when the subscription is made. Signals that this subscription is ready for 1 emitted value.
    }

    public void hookOnNext(T value) {
        System.out.println(value.toString() + " received");
        request(1); // Each time a value is emitted, signal that the subscription is ready for 1 more emitted value.
    }

    public void hookOnError(Throwable throwable) {
        System.out.println("Error received: " + throwable);
    }

}