package chapter06;

public class SubsetSum {
    /**
     * Inputs: a list of integer values and a target sum.
     * Result: true if some subset has exactly the target sum.
     */
    public static boolean solve(int[] values, int target) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        if (!solve(new int[]{3, 34, 4, 12, 5, 2}, 9))
            throw new AssertionError("9 should be achievable");
        if (solve(new int[]{3, 34, 4, 12, 5, 2}, 30))
            throw new AssertionError("30 should not be achievable");
        if (!solve(new int[]{1, 2, 3}, 0))
            throw new AssertionError("zero should be achievable with the empty subset");
        if (!solve(new int[]{}, 0) || solve(new int[]{}, 1))
            throw new AssertionError("empty input should only achieve target zero");
        if (solve(new int[]{2}, 4))
            throw new AssertionError("an item may only be used once");
    }
}
