package chapter06;

import static testutil.TestAssertions.assertEquals;

public class Fibonacci {
    /**
     * Input: a non-negative index n.
     * Result: the nth Fibonacci number, with F(0) = 0 and F(1) = 1.
     */
    public static long solve(int n) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        assertEquals("n=0", 0L, solve(0), "Fibonacci(0)");
        assertEquals("n=1", 1L, solve(1), "Fibonacci(1)");
        assertEquals("n=10", 55L, solve(10), "Fibonacci(10)");
        assertEquals("n=50", 12586269025L, solve(50), "Fibonacci(50)");
        try {
            solve(-1);
            throw new AssertionError("negative index rejection: expected IllegalArgumentException, got no exception");
        } catch (IllegalArgumentException expected) {
            // Expected.
        }
    }
}
