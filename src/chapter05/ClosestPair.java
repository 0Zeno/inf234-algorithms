package chapter05;

import java.util.List;

public class ClosestPair {
    public record Point(long x, long y) {}

    public static double solve(List<Point> points) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        double d = solve(List.of(new Point(0, 0), new Point(2, 3),
                new Point(6, 7), new Point(2, 1)));
        if (Math.abs(d - Math.sqrt(5)) > 1e-9)
            throw new AssertionError("wrong closest-pair distance");
        if (solve(List.of(new Point(4, 4), new Point(4, 4))) != 0.0)
            throw new AssertionError("duplicate points have distance zero");
        if (Math.abs(solve(List.of(new Point(0, 0), new Point(3, 4))) - 5.0) > 1e-9)
            throw new AssertionError("wrong distance for a two-point input");
        if (Math.abs(solve(List.of(new Point(-3, -4), new Point(0, 0))) - 5.0) > 1e-9)
            throw new AssertionError("negative coordinates should be supported");
    }
}
