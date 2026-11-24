package chapter04;

import java.util.*;

public class LatenessScheduling {
    public record Job(String name, int processingTime, int deadline) {}
    public record ScheduleEntry(String name, int start, int finish) {}

    public static List<ScheduleEntry> solve(List<Job> jobs) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        List<ScheduleEntry> result = solve(List.of(
                new Job("A", 2, 2), new Job("B", 1, 1), new Job("C", 2, 4)));
        if (result.size() != 3) throw new AssertionError("all jobs must be scheduled");
        if (!result.get(0).name().equals("B") || result.get(0).start() != 0
                || result.get(0).finish() != 1)
            throw new AssertionError("jobs should be ordered by earliest deadline");
        if (solve(List.of()).size() != 0) throw new AssertionError("empty input should produce no entries");
        result = solve(List.of(new Job("zero", 0, 0)));
        if (result.size() != 1 || result.get(0).start() != 0 || result.get(0).finish() != 0)
            throw new AssertionError("zero-duration jobs should be scheduled");
    }
}
