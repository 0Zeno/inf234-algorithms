package chapter06;

public class Fibonacci {
    /**
     * Input: a non-negative index n.
     * Result: the nth Fibonacci number, with F(0) = 0 and F(1) = 1.
     */
    public static long solve(int n) {
        if (n < 0) throw new IllegalArgumentException("index must be non-negative");
        long previous = 0;
        long current = 1;
        for (int i = 0; i < n; i++) {
            long next = previous + current;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        if (solve(0) != 0 || solve(1) != 1)
            throw new AssertionError("base Fibonacci values are incorrect");
        if (solve(10) != 55)
            throw new AssertionError("expected Fibonacci(10) to be 55");
        if (solve(50) != 12586269025L)
            throw new AssertionError("larger Fibonacci value is incorrect");
        try {
            solve(-1);
            throw new AssertionError("negative indexes should be rejected");
        } catch (IllegalArgumentException expected) {
            // Expected.
        }
    }
}
