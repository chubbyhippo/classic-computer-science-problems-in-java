package com.example.fibonacci;

public class FibonacciIterative {

    private FibonacciIterative() {
        throw new IllegalStateException("Utility class");
    }

    public static int fib(int n) {
        int last = 0;
        int next = 1;
        for (var i = 0; i < n; i++) {
            var oldLast = last;
            last = next;
            next = oldLast + next;
        }
        return last;
    }

}
