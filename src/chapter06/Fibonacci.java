package chapter06;

import static testutil.TestAssertions.assertEquals;

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
        assertEquals(0L, solve(0), "Fibonacci(0)");
        assertEquals(1L, solve(1), "Fibonacci(1)");
        assertEquals(55L, solve(10), "Fibonacci(10)");
        assertEquals(12586269025L, solve(50), "Fibonacci(50)");
        try {
            solve(-1);
            throw new AssertionError("negative index rejection: expected IllegalArgumentException, got no exception");
        } catch (IllegalArgumentException expected) {
            // Expected.
        }
    }
}
