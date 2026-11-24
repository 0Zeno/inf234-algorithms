package chapter03;

import java.util.List;

public class BipartiteTest {
    public record Graph(int vertexCount, List<List<Integer>> adjacency) {}

    public static boolean solve(Graph graph) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        check(solve(new Graph(4, List.of(List.of(1), List.of(0, 2), List.of(1, 3), List.of(2)))));
        check(!solve(new Graph(3, List.of(List.of(1, 2), List.of(0, 2), List.of(0, 1)))));
        check(solve(new Graph(1, List.of(List.of()))));
        check(solve(new Graph(0, List.of())));
        check(!solve(new Graph(1, List.of(List.of(0)))));
    }

    private static void check(boolean condition) {
        if (!condition) throw new AssertionError("bipartite test failed");
    }
}
