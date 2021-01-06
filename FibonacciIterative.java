public class FibonacciIterative {

    private static int fib(int n) {
        int last = 0, next = 1; // fib(0), fib(1)
        for (int i = 0; i < n; i++) {
            int oldLast = last;
            last = next;
            next = oldLast + next;
        }
        return last;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(fib(40));
        long elapsedTime = System.nanoTime() - start;
        System.out.println(elapsedTime);
    }

}
