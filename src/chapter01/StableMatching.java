package chapter01;

import java.util.*;

public class StableMatching {
    public record PersonPreferences(List<String> rank) {}

    /**
     * Inputs: preference maps for each proposer and receiver.
     * Result: a stable one-to-one mapping from proposer names to receiver names.
     */
    public static Map<String, String> solve(
            Map<String, PersonPreferences> proposers,
            Map<String, PersonPreferences> receivers) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Map<String, PersonPreferences> men = Map.of(
                "A", new PersonPreferences(List.of("X", "Y")),
                "B", new PersonPreferences(List.of("Y", "X")));
        Map<String, PersonPreferences> women = Map.of(
                "X", new PersonPreferences(List.of("A", "B")),
                "Y", new PersonPreferences(List.of("B", "A")));
        Map<String, String> result = solve(men, women);
        check(result != null && result.size() == 2, "a perfect matching is required");
        check("X".equals(result.get("A")) && "Y".equals(result.get("B")),
                "matching should respect the preferences in this example");
        result = solve(Map.of("A", new PersonPreferences(List.of("X"))),
                Map.of("X", new PersonPreferences(List.of("A"))));
        check(result.size() == 1 && "X".equals(result.get("A")),
                "a one-person instance should match its only pair");
        check(solve(Map.of(), Map.of()).isEmpty(), "empty instance should have an empty matching");
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}
