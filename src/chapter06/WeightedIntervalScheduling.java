package chapter06;

import java.util.List;

import static testutil.TestAssertions.assertEquals;

public class WeightedIntervalScheduling {
    public record Interval(int start, int end, int weight) {}

    /**
     * Input: intervals with start and end times and a weight.
     * Result: the maximum total weight of mutually non-overlapping intervals.
     */
    public static int solve(List<Interval> intervals) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        int result = solve(List.of(
                new Interval(1, 3, 5), new Interval(2, 5, 6),
                new Interval(4, 6, 5), new Interval(6, 7, 4)));
        assertEquals(10, result, "main weighted interval schedule");
        assertEquals(0, solve(List.of()), "empty input");
        assertEquals(7, solve(List.of(new Interval(0, 1, 3), new Interval(1, 2, 4))),
                "touching weighted intervals");
        assertEquals(0, solve(List.of(new Interval(0, 1, -5))),
                "negative-weight interval");
    }
}
