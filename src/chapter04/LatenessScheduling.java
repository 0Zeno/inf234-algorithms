package chapter04;

import java.util.*;

import static testutil.TestAssertions.assertEquals;

public class LatenessScheduling {
    public record Job(String name, int processingTime, int deadline) {}
    public record ScheduleEntry(String name, int start, int finish) {}

    /**
     * Input: jobs with processing times and deadlines.
     * Result: an ordered schedule assigning each job a start and finish time.
     */
    public static List<ScheduleEntry> solve(List<Job> jobs) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        List<ScheduleEntry> result = solve(List.of(
                new Job("A", 2, 2), new Job("B", 1, 1), new Job("C", 2, 4)));
        assertEquals(3, result.size(), "all jobs must be scheduled");
        assertEquals(new ScheduleEntry("B", 0, 1), result.get(0),
                "first job should have the earliest deadline");
        assertEquals(List.of(), solve(List.of()), "empty input schedule");
        result = solve(List.of(new Job("zero", 0, 0)));
        assertEquals(List.of(new ScheduleEntry("zero", 0, 0)), result,
                "zero-duration job schedule");
    }
}
