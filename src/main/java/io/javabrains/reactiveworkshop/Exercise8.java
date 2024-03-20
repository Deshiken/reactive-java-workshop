package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        ReactiveSources.intNumbersFluxWithException()
                .doOnError(error -> System.out.println("Error!" + error.getMessage()))    // Performs the action when an error occurs, but still passes the error further down the pipeline.
                // By default, a subscription will end when an error occurs.
                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and continue on errors
        ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((error, item) -> System.out.println("Error!" + error.getMessage()))    // Catches the error and continues to pass emitted values down the pipeline
                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(error -> Flux.just(-1, -2))   // When an error is emitted, the error is caught and a new flux is passed down the pipeline
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
