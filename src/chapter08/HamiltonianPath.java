package chapter08;

import java.util.List;

public class HamiltonianPath {
    public record Graph(int vertexCount, List<int[]> edges) {}

    public static boolean solve(Graph graph) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        if (!solve(new Graph(4, List.of(
                new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}))))
            throw new AssertionError("path graph should have a Hamiltonian path");
        if (solve(new Graph(4, List.of(new int[]{0, 1}, new int[]{2, 3}))))
            throw new AssertionError("disconnected graph should not have a Hamiltonian path");
        if (!solve(new Graph(1, List.of())))
            throw new AssertionError("a single vertex has a Hamiltonian path");
        if (!solve(new Graph(4, List.of(
                new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0}))))
            throw new AssertionError("a cycle contains a Hamiltonian path");
    }
}
