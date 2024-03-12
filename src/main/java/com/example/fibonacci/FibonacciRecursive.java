package com.example.fibonacci;

public class FibonacciRecursive {
    private FibonacciRecursive() {
        throw new IllegalStateException("Utility class");
    }

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
