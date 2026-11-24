package chapter05;

public class CountInversions {
    public static long solve(int[] values) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        if (solve(new int[]{3, 1, 2}) != 2)
            throw new AssertionError("expected 2 inversions");
        if (solve(new int[]{1, 2, 3, 4}) != 0)
            throw new AssertionError("sorted input has no inversions");
        if (solve(new int[]{4, 3, 2, 1}) != 6)
            throw new AssertionError("reverse-sorted input has six inversions");
        if (solve(new int[]{2, 2, 1}) != 2)
            throw new AssertionError("equal values should not form inversions");
        if (solve(new int[]{}) != 0 || solve(new int[]{42}) != 0)
            throw new AssertionError("empty and singleton inputs have no inversions");
    }
}
