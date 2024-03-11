package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.FibonacciRecursive.fib;
import static org.assertj.core.api.Assertions.assertThatCode;

class FibonacciRecursiveTest {

    @Test
    @DisplayName("should return fib recursive")
    void shouldReturnFibRecursive() {

        var start = System.nanoTime();
        System.out.println(fib(40));
        var elapsedTime = System.nanoTime() - start;
        System.out.println(elapsedTime);

        assertThatCode(() -> fib(1)).doesNotThrowAnyException();
    }

}