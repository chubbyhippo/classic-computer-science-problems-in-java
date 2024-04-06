package org.github.chubbyhippo.fibonacci;

import java.util.stream.IntStream;

public class FibonacciStreamReduce {

    private FibonacciStreamReduce() {
        throw new IllegalStateException("Utility class");
    }

    public static int fib(int n) {

        int[] fibonacci = IntStream.rangeClosed(1, n)
                .boxed()
                .reduce(new int[]{0, 1},
                        (a, c) -> new int[]{a[1], a[0] + a[1]},
                        (a, b) -> a
                );
        return fibonacci[0];
    }

}
