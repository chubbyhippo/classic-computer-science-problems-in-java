package com.example.fibonacci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

import static com.example.fibonacci.FibonacciStreamReduce.fib;
import static org.assertj.core.api.Assertions.assertThat;

class FibonacciStreamReduceTest {
    private static final Logger log = LoggerFactory.getLogger(FibonacciStreamReduceTest.class);

    @Test
    @DisplayName("should throw illegal state exception when initialized")
    void shouldThrowIllegalStateExceptionWhenInitialized() {
        var constructor = FibonacciStreamReduce.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        try {
            constructor.newInstance();
        } catch (IllegalStateException | InstantiationException | IllegalAccessException |
                 InvocationTargetException exception) {
            assertThat(exception.getCause().getClass()).isEqualTo(IllegalStateException.class);
            assertThat(exception.getCause().getMessage()).isEqualTo("Utility class");
        }
    }

    @Test
    @DisplayName("should return fib recursive")
    void shouldReturnFibRecursive() {

        var start = System.nanoTime();
        log.info("fib:{}", fib(40));
        var elapsedTime = System.nanoTime() - start;
        log.info("elapsed time:{}", elapsedTime);

        assertThat(fib(1)).isPositive();

    }

}