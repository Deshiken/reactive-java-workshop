package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        ReactiveSources.intNumbersFlux()
                .collectList()      // Add all of the emitted values to a list. Wait until all values have been emitted to send the list to the next step in the pipeline..
                .subscribe(result -> System.out.println("result list size: " + result.size() + ", " + result));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
