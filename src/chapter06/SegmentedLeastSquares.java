package chapter06;

import java.util.List;

public class SegmentedLeastSquares {
    public record Point(double x, double y) {}

    public static double solve(List<Point> points, double segmentCost) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        double cost = solve(List.of(
                new Point(1, 1), new Point(2, 1.1),
                new Point(3, 1.9), new Point(4, 2.1)), 1.0);
        if (cost < 0) throw new AssertionError("cost must be non-negative");
        double exactLineCost = solve(List.of(new Point(0, 2), new Point(1, 4),
                new Point(2, 6)), 0.0);
        if (Math.abs(exactLineCost) > 1e-9)
            throw new AssertionError("an exact line should have zero fitting error");
        if (solve(List.of(), 1.0) != 0.0)
            throw new AssertionError("empty input should have zero cost");
    }
}
