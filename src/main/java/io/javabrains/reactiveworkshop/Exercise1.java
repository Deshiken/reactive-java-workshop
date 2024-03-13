package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("***** Exercise 1 *****");
        StreamSources.intNumbersStream().forEach(number -> {
            System.out.println(number);
        });


        // Print numbers from intNumbersStream that are less than 5
        System.out.println("***** Exercise 2 *****");
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)   // Only return results greater than 5
                .forEach(number -> System.out.println(number)); // Can also be shortened to System.out::println


        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("***** Exercise 3 *****");
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .skip(1)            // Skip the first number in the stream greater than 5
                .limit(2)      // Limit the number of returned values to two (2nd and 3rd result)
                .forEach(System.out::println);


        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("***** Exercise 4 *****");
        Integer value = StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .findFirst()            // Returns the first value found
                .orElse(-1);      // If no value found, return -1
        System.out.println(value);


        // Print first names of all users in userStream
        System.out.println("***** Exercise 5 *****");
        StreamSources.userStream()
                .map(user -> user.getFirstName()) // Replaces the User being passed to next steps in the stream with the userName
                .forEach(userName -> System.out.println(userName));


        // Print first names in userStream for users that have IDs from number stream
        System.out.println("***** Exercise 6 *****");
        StreamSources.intNumbersStream()
                /* StreamSources.userStream.filter will return a stream that matches the filter criteria. In order to pass
                   the result of that stream, rather than the stream itself, we can use flatMap **/
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(userName -> System.out.println(userName));
    }

}
