package chapter06;

import static testutil.TestAssertions.assertEquals;

public class SubsetSum {
    /**
     * Inputs: a list of integer values and a target sum.
     * Result: true if some subset has exactly the target sum.
     */
    public static boolean solve(int[] values, int target) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        assertEquals(true, solve(new int[]{3, 34, 4, 12, 5, 2}, 9), "target 9");
        assertEquals(false, solve(new int[]{3, 34, 4, 12, 5, 2}, 30), "target 30");
        assertEquals(true, solve(new int[]{1, 2, 3}, 0), "empty subset for target 0");
        assertEquals(true, solve(new int[]{}, 0), "empty input and target 0");
        assertEquals(false, solve(new int[]{}, 1), "empty input and target 1");
        assertEquals(false, solve(new int[]{2}, 4), "target 4 with a single item 2");
    }
}
