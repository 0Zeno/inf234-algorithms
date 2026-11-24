package chapter08;

import java.util.List;

public class VertexCover {
    public record Graph(int vertexCount, List<int[]> edges) {}

    public static boolean solve(Graph graph, int size) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Graph path = new Graph(4, List.of(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}));
        if (!solve(path, 2)) throw new AssertionError("path should have a vertex cover of size 2");
        if (solve(path, 1)) throw new AssertionError("one vertex cannot cover the whole path");
        if (!solve(new Graph(3, List.of()), 0))
            throw new AssertionError("empty graph has a zero-sized vertex cover");
        if (!solve(new Graph(2, List.of(new int[]{0, 1})), 1))
            throw new AssertionError("one endpoint covers a single edge");
        if (solve(path, 5)) throw new AssertionError("a cover cannot be larger than the graph");
    }
}
