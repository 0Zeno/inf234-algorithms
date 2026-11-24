package chapter06;

import java.util.List;

import static testutil.TestAssertions.assertDoubleEquals;

public class SegmentedLeastSquares {
    public record Point(double x, double y) {}

    /**
     * Inputs: points and the fixed cost of adding a segment.
     * Result: the minimum least-squares error plus segment cost.
     */
    public static double solve(List<Point> points, double segmentCost) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        double cost = solve(List.of(
                new Point(1, 1), new Point(2, 1.1),
                new Point(3, 1.9), new Point(4, 2.1)), 1.0);
        if (cost < 0) throw new AssertionError("cost must be non-negative: expected >= 0, got " + cost);
        double exactLineCost = solve(List.of(new Point(0, 2), new Point(1, 4),
                new Point(2, 6)), 0.0);
        assertDoubleEquals(0.0, exactLineCost, "exact line fitting cost");
        assertDoubleEquals(0.0, solve(List.of(), 1.0), "empty input cost");
    }
}
