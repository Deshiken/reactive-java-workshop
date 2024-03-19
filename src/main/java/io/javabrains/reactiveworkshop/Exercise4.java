package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        System.out.println("***** Exercise 1 *****");
        ReactiveSources.intNumberMono().subscribe(value -> System.out.println(value));

        // Get the value from the Mono into an integer variable
        System.out.println("***** Exercise 2 *****");
        Optional<Integer> number = ReactiveSources.intNumberMono().blockOptional(); // To store the value emitted we need to block in order to wait for the response
        if (number.isPresent()) {
            System.out.println(number.get());
        }

        System.out.println("Press a key to end");
        System.in.read();
    }

}
