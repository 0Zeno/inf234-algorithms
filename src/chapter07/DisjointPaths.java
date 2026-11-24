package chapter07;

import java.util.List;

public class DisjointPaths {
    public record Edge(int from, int to) {}
    public record Network(int vertexCount, int source, int sink, List<Edge> edges) {}

    public static int solve(Network network) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Network n = new Network(6, 0, 5, List.of(
                new Edge(0, 1), new Edge(0, 2), new Edge(1, 3),
                new Edge(2, 3), new Edge(3, 4), new Edge(3, 5),
                new Edge(4, 5)));
        if (solve(n) != 2) throw new AssertionError("expected 2 disjoint paths");
        if (solve(new Network(3, 0, 2, List.of(new Edge(0, 1)))) != 0)
            throw new AssertionError("unreachable sink should have zero paths");
        if (solve(new Network(3, 0, 2, List.of(new Edge(0, 1), new Edge(1, 2)))) != 1)
            throw new AssertionError("a single path should be counted once");
    }
}
