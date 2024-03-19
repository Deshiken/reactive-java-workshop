package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        System.out.println("***** Exercise 1 *****");
        ReactiveSources.intNumbersFlux()
                .filter(number -> number > 5)
                .log()
                .subscribe(
                        number -> System.out.println(number)
                );
//
//        // Print 10 times each value from intNumbersFlux that's greater than 5
        System.out.println("***** Exercise 2 *****");
        ReactiveSources.intNumbersFlux()
                .filter(number -> number > 5)
                .map(number -> number * 10)
                .subscribe(System.out::println);
//
//        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        System.out.println("***** Exercise 3 *****");
        ReactiveSources.intNumbersFlux()
                .filter(number -> number > 5)
                .take(3)
                .map(number -> number * 10)
                .subscribe(System.out::println);
//
//        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        System.out.println("***** Exercise 4 *****");
        ReactiveSources.intNumbersFlux()
                .filter(number -> number > 20)
                .defaultIfEmpty(-1)
                .subscribe(System.out::println);

        // Switch ints from intNumbersFlux to the right user from userFlux
        System.out.println("***** Exercise 5 *****");
        ReactiveSources.intNumbersFlux()
                .flatMap(number -> ReactiveSources.userFlux()
                        .filter(user -> user.getId() == number))
                .subscribe(System.out::println);

        // Print only distinct numbers from intNumbersFluxWithRepeat
        System.out.println("***** Exercise 6 *****");
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinct()         // Filters out repeat values from the supplied Flux
                .log()
                .subscribe();

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        System.out.println("***** Exercise 7 *****");
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinctUntilChanged() // Prevents the same value from being emitted twice in a row. Uses the equals method to check if emitted values are the same.
                .log()
                .subscribe();

        System.out.println("Press a key to end");
        System.in.read();
    }

}
