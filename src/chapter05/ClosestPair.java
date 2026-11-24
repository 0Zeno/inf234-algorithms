package chapter05;

import java.util.List;

import static testutil.TestAssertions.assertDoubleEquals;

import static testutil.TestAssertions.assertDoubleEquals;

public class ClosestPair {
    public record Point(long x, long y) {}

    /**
     * Input: a list of points.
     * Result: the Euclidean distance between the closest pair of points.
     */
    public static double solve(List<Point> points) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        double d = solve(List.of(new Point(0, 0), new Point(2, 3),
                new Point(6, 7), new Point(2, 1)));
        assertDoubleEquals(Math.sqrt(5), d, "closest-pair distance");
        assertDoubleEquals(0.0, solve(List.of(new Point(4, 4), new Point(4, 4))), "duplicate points");
        assertDoubleEquals(5.0, solve(List.of(new Point(0, 0), new Point(3, 4))), "two-point distance");
        assertDoubleEquals(5.0, solve(List.of(new Point(-3, -4), new Point(0, 0))), "negative-coordinate distance");
    }
}
