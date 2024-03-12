package com.example.fibonacci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

public class FibonacciStream {
    private static final Logger log = LoggerFactory.getLogger(FibonacciStream.class);

    public static void main(String[] args) {
        int n = 40;  // Fibonacci number to find

        int[] fibonacci = IntStream.rangeClosed(1, n)
                .boxed()
                .reduce(new int[]{0, 1},
                        (a, c) -> new int[]{a[1], a[0] + a[1]},
                        (a, b) -> a
                );

        log.info("{}", fibonacci[0]);
    }

}
