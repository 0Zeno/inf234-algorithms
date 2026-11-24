package chapter04;

import java.util.*;

public class MinimumSpanningTree {
    public record Edge(int u, int v, int weight) {}

    public static long solve(int vertexCount, List<Edge> edges) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        long weight = solve(4, List.of(
                new Edge(0, 1, 1), new Edge(0, 2, 4),
                new Edge(1, 2, 2), new Edge(1, 3, 5),
                new Edge(2, 3, 3)));
        if (weight != 6) throw new AssertionError("expected MST weight 6, got " + weight);
        if (solve(1, List.of()) != 0) throw new AssertionError("one vertex has MST weight 0");
        if (solve(3, List.of(new Edge(0, 1, -2), new Edge(1, 2, 1),
                new Edge(0, 2, 4))) != -1)
            throw new AssertionError("MST should handle negative edge weights");
        if (solve(0, List.of()) != 0) throw new AssertionError("empty graph has MST weight 0");
    }
}
