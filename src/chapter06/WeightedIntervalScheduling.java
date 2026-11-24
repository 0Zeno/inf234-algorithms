package chapter06;

import java.util.List;

public class WeightedIntervalScheduling {
    public record Interval(int start, int end, int weight) {}

    public static int solve(List<Interval> intervals) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        int result = solve(List.of(
                new Interval(1, 3, 5), new Interval(2, 5, 6),
                new Interval(4, 6, 5), new Interval(6, 7, 4)));
        if (result != 10) throw new AssertionError("expected 10, got " + result);
        if (solve(List.of()) != 0) throw new AssertionError("empty input should have weight zero");
        if (solve(List.of(new Interval(0, 1, 3), new Interval(1, 2, 4))) != 7)
            throw new AssertionError("touching weighted intervals should both be selectable");
        if (solve(List.of(new Interval(0, 1, -5))) != 0)
            throw new AssertionError("a negative-weight interval should be skipped");
    }
}
