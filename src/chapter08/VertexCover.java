package chapter08;

import graph.Graph;

public class VertexCover {
    /**
     * Inputs: an undirected graph and a requested cover size.
     * Result: true if at least one set of that size is incident to every edge.
     */
    public static boolean solve(Graph<Integer> graph, int size) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Graph<Integer> path = undirected(4, new int[][]{{0, 1}, {1, 2}, {2, 3}});
        if (!solve(path, 2)) throw new AssertionError("path should have a vertex cover of size 2");
        if (solve(path, 1)) throw new AssertionError("one vertex cannot cover the whole path");
        if (!solve(undirected(3, new int[][]{}), 0))
            throw new AssertionError("empty graph has a zero-sized vertex cover");
        if (!solve(undirected(2, new int[][]{{0, 1}}), 1))
            throw new AssertionError("one endpoint covers a single edge");
        if (solve(path, 5)) throw new AssertionError("a cover cannot be larger than the graph");
    }

    private static Graph<Integer> undirected(int vertexCount, int[][] edges) {
        Graph<Integer> graph = new Graph<>(false);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addEdge(edge[0], edge[1]);
        return graph;
    }
}
