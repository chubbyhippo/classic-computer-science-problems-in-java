package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.example.FibonacciIterative.fib;
import static org.assertj.core.api.Assertions.assertThat;

class FibonacciIterativeTest {

    private static final Logger log = LoggerFactory.getLogger(FibonacciIterativeTest.class);

    @Test
    @DisplayName("should return fib iterative")
    void shouldReturnFibIterative() {

        var start = System.nanoTime();
        log.info("fib:{}", fib(40));
        var elapsedTime = System.nanoTime() - start;
        log.info("elapsed time:{}", elapsedTime);

        assertThat(fib(1)).isPositive();

    }

}