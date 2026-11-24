package chapter01;

import java.util.*;

import static testutil.TestAssertions.assertEquals;

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
        assertEquals(2, result == null ? -1 : result.size(), "perfect matching size");
        assertEquals(Map.of("A", "X", "B", "Y"), result,
                "matching should respect the preferences");
        result = solve(Map.of("A", new PersonPreferences(List.of("X"))),
                Map.of("X", new PersonPreferences(List.of("A"))));
        assertEquals(Map.of("A", "X"), result,
                "one-person instance should match its only pair");
        assertEquals(Map.of(), solve(Map.of(), Map.of()),
                "empty instance should have an empty matching");
    }
}
