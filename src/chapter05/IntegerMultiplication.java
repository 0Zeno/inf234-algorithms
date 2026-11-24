package chapter05;

public class IntegerMultiplication {
    public static long solve(long first, long second) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        if (solve(3, 8) != 24) throw new AssertionError("wrong product");
        if (solve(0, 12345) != 0) throw new AssertionError("zero product is incorrect");
        if (solve(-7, 6) != -42) throw new AssertionError("negative product is incorrect");
        if (solve(-9, -4) != 36) throw new AssertionError("double-negative product is incorrect");
        if (solve(1, Long.MIN_VALUE) != Long.MIN_VALUE)
            throw new AssertionError("multiplication by one is incorrect");
    }
}
