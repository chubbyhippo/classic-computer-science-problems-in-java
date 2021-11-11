public class FibonacciRecursive {
    private static int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        var start = System.nanoTime();
        System.out.println(fib(40));
        var elapsedTime = System.nanoTime() - start;
        System.out.println(elapsedTime);
    }
}
