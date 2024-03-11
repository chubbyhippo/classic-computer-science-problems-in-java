package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.example.FibonacciRecursive.fib;
import static org.assertj.core.api.Assertions.assertThat;

class FibonacciRecursiveTest {
    private static final Logger log = LoggerFactory.getLogger(FibonacciRecursiveTest.class);

    @Test
    @DisplayName("should return fib recursive")
    void shouldReturnFibRecursive() {

        var start = System.nanoTime();
        log.info("{}", fib(40));
        var elapsedTime = System.nanoTime() - start;
        log.info("{}", elapsedTime);

        assertThat(fib(1)).isPositive();

    }

}