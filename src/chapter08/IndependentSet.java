package chapter08;

import graph.Graph;

public class IndependentSet {
    /**
     * Inputs: an undirected graph and a requested set size.
     * Result: true if the graph contains at least the requested number of mutually
     * non-adjacent vertices.
     */
    public static boolean solve(Graph<Integer> graph, int size) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Graph<Integer> path = undirected(4, new int[][]{{0, 1}, {1, 2}, {2, 3}});
        if (!solve(path, 2)) throw new AssertionError("path should have an independent set of size 2");
        if (!solve(path, 0)) throw new AssertionError("empty set is always independent");
        if (solve(path, 3)) throw new AssertionError("path does not have an independent set of size 3");
        if (solve(path, 5)) throw new AssertionError("a set cannot be larger than the graph");
        if (!solve(undirected(3, new int[][]{}), 3))
            throw new AssertionError("edgeless graph has an independent set of every size");
    }

    private static Graph<Integer> undirected(int vertexCount, int[][] edges) {
        Graph<Integer> graph = new Graph<>(false);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addEdge(edge[0], edge[1]);
        return graph;
    }
}
