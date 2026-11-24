package chapter05;

import static testutil.TestAssertions.assertEquals;

public class CountInversions {
    /**
     * Input: an integer array.
     * Result: the number of pairs i < j whose values satisfy values[i] > values[j].
     */
    public static long solve(int[] values) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        assertEquals(2L, solve(new int[]{3, 1, 2}), "main inversion count");
        assertEquals(0L, solve(new int[]{1, 2, 3, 4}), "sorted input has no inversions");
        assertEquals(6L, solve(new int[]{4, 3, 2, 1}), "reverse-sorted input has six inversions");
        assertEquals(2L, solve(new int[]{2, 2, 1}), "equal values should not form inversions");
        assertEquals(0L, solve(new int[]{}), "empty input has no inversions");
        assertEquals(0L, solve(new int[]{42}), "singleton input has no inversions");
    }
}
