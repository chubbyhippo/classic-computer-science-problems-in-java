package com.example;

public class FibonacciIterative {

    private static int fib(int n) {
        int last = 0, next = 1; // fib(0), fib(1)
        for (var i = 0; i < n; i++) {
            var oldLast = last;
            last = next;
            next = oldLast + next;
        }
        return last;
    }

    public static void main(String[] args) {
        var start = System.nanoTime();
        System.out.println(fib(40));
        var elapsedTime = System.nanoTime() - start;
        System.out.println(elapsedTime);
    }

}
