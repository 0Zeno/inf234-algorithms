package chapter07;

import java.util.List;

public class MaximumFlow {
    public record Edge(int from, int to, long capacity) {}
    public record Network(int vertexCount, int source, int sink, List<Edge> edges) {}

    public static long solve(Network network) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Network n = new Network(6, 0, 5, List.of(
                new Edge(0, 1, 16), new Edge(0, 2, 13),
                new Edge(1, 2, 10), new Edge(1, 3, 12),
                new Edge(2, 1, 4), new Edge(2, 4, 14),
                new Edge(3, 2, 9), new Edge(3, 5, 20),
                new Edge(4, 3, 7), new Edge(4, 5, 4)));
        if (solve(n) != 23) throw new AssertionError("expected maximum flow 23");
        if (solve(new Network(3, 0, 2, List.of())) != 0)
            throw new AssertionError("network without edges has zero flow");
        if (solve(new Network(2, 0, 1, List.of(new Edge(0, 1, 7)))) != 7)
            throw new AssertionError("single-edge flow is incorrect");
        if (solve(new Network(2, 0, 1, List.of(new Edge(0, 1, 0)))) != 0)
            throw new AssertionError("zero-capacity edges have zero flow");
    }
}
