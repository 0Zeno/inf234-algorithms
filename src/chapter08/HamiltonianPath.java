package chapter08;

import graph.Graph;

public class HamiltonianPath {
    /**
     * Input: an undirected graph.
     * Result: true if it contains a path that visits every vertex exactly once.
     */
    public static boolean solve(Graph<Integer> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        if (!solve(undirected(4, new int[][]{{0, 1}, {1, 2}, {2, 3}})))
            throw new AssertionError("path graph should have a Hamiltonian path");
        if (solve(undirected(4, new int[][]{{0, 1}, {2, 3}})))
            throw new AssertionError("disconnected graph should not have a Hamiltonian path");
        if (!solve(undirected(1, new int[][]{})))
            throw new AssertionError("a single vertex has a Hamiltonian path");
        if (!solve(undirected(4, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}})))
            throw new AssertionError("a cycle contains a Hamiltonian path");
    }

    private static Graph<Integer> undirected(int vertexCount, int[][] edges) {
        Graph<Integer> graph = new Graph<>(false);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addEdge(edge[0], edge[1]);
        return graph;
    }
}
