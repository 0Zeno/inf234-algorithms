package chapter07;

import graph.Graph;

public class DisjointPaths {
    /**
     * Inputs: a directed network, a source vertex, and a sink vertex.
     * Result: the maximum number of vertex-disjoint paths from source to sink.
     */
    public static int solve(Graph<Integer> network, int source, int sink) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Graph<Integer> n = network(6, new int[][]{
                {0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 5}, {4, 5}});
        if (solve(n, 0, 5) != 2) throw new AssertionError("expected 2 disjoint paths");
        if (solve(network(3, new int[][]{{0, 1}}), 0, 2) != 0)
            throw new AssertionError("unreachable sink should have zero paths");
        if (solve(network(3, new int[][]{{0, 1}, {1, 2}}), 0, 2) != 1)
            throw new AssertionError("a single path should be counted once");
    }

    private static Graph<Integer> network(int vertexCount, int[][] edges) {
        Graph<Integer> graph = new Graph<>(true);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addEdge(edge[0], edge[1]);
        return graph;
    }
}
