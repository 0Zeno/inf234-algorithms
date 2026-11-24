package chapter05;

import static testutil.TestAssertions.assertEquals;

public class IntegerMultiplication {
    /**
     * Inputs: two integers.
     * Result: their product.
     */
    public static long solve(long first, long second) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        assertEquals(24L, solve(3, 8), "wrong product");
        assertEquals(0L, solve(0, 12345), "zero product is incorrect");
        assertEquals(-42L, solve(-7, 6), "negative product is incorrect");
        assertEquals(36L, solve(-9, -4), "double-negative product is incorrect");
        assertEquals(Long.MIN_VALUE, solve(1, Long.MIN_VALUE), "multiplication by one is incorrect");
    }
}
