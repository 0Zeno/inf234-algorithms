package chapter08;

import java.util.List;

public class IndependentSet {
    public record Graph(int vertexCount, List<int[]> edges) {}

    public static boolean solve(Graph graph, int size) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Graph path = new Graph(4, List.of(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}));
        if (!solve(path, 2)) throw new AssertionError("path should have an independent set of size 2");
        if (!solve(path, 0)) throw new AssertionError("empty set is always independent");
        if (solve(path, 3)) throw new AssertionError("path does not have an independent set of size 3");
        if (solve(path, 5)) throw new AssertionError("a set cannot be larger than the graph");
        if (!solve(new Graph(3, List.of()), 3))
            throw new AssertionError("edgeless graph has an independent set of every size");
    }
}
