package chapter06;

import java.util.*;

public class BellmanFord {
    public record Edge(int from, int to, int weight) {}
    public record Graph(int vertexCount, List<Edge> edges) {}

    public static Map<Integer, Integer> solve(Graph graph, int start) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Map<Integer, Integer> d = solve(new Graph(5, List.of(
                new Edge(0, 1, 6), new Edge(0, 2, 7),
                new Edge(1, 2, 8), new Edge(1, 3, 5),
                new Edge(1, 4, -4), new Edge(2, 3, -3),
                new Edge(3, 1, -2), new Edge(4, 3, 7),
                new Edge(4, 0, 2))), 0);
        if (!d.get(0).equals(0) || !d.get(2).equals(2))
            throw new AssertionError("Bellman-Ford distance mismatch");
        Map<Integer, Integer> negativeEdge = solve(new Graph(3, List.of(
                new Edge(0, 1, 4), new Edge(0, 2, 5), new Edge(1, 2, -3))), 0);
        if (!negativeEdge.get(2).equals(1))
            throw new AssertionError("negative edges should be relaxed correctly");
        if (solve(new Graph(2, List.of()), 0).containsKey(1))
            throw new AssertionError("unreachable vertices should not have a distance");
        if (!solve(new Graph(1, List.of()), 0).get(0).equals(0))
            throw new AssertionError("distance from a vertex to itself should be zero");
    }
}
