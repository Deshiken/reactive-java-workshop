package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        System.out.println("***** Exercise 1 *****");
//        ReactiveSources.intNumbersFlux()
//                .map(number -> System.out.println(number));

        // Print all users in the ReactiveSources.userFlux stream
        System.out.println("***** Exercise 2 *****");
        // TODO: Write code here

        System.out.println("Press a key to end");
        System.in.read();
    }

}
