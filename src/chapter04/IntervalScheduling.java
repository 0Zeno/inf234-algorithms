package chapter04;

import java.util.*;

public class IntervalScheduling {
    public record Interval(String name, int start, int end) {
        public Interval { if (start >= end) throw new IllegalArgumentException(); }
    }

    /**
     * Input: a list of intervals with start and end times.
     * Result: a maximum-size set of mutually non-overlapping intervals.
     */
    public static List<Interval> solve(List<Interval> intervals) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        List<Interval> input = List.of(
                new Interval("A", 1, 4), new Interval("B", 3, 5),
                new Interval("C", 0, 6), new Interval("D", 5, 7),
                new Interval("E", 3, 9), new Interval("F", 8, 11),
                new Interval("G", 12, 16));
        List<Interval> result = solve(input);
        if (result.size() != 4) throw new AssertionError("expected 4 intervals, got " + result.size());
        if (!solve(List.of()).isEmpty()) throw new AssertionError("empty input should produce no intervals");
        result = solve(List.of(new Interval("A", 0, 1), new Interval("B", 1, 2),
                new Interval("C", 2, 3)));
        if (result.size() != 3) throw new AssertionError("touching intervals should be compatible");
        try {
            new Interval("invalid", 2, 2);
            throw new AssertionError("zero-length intervals should be rejected");
        } catch (IllegalArgumentException expected) {
            // expected
        }
    }
}
