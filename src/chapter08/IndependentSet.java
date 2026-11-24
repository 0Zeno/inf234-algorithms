package chapter08;

import graph.Graph;

import static testutil.TestAssertions.assertEquals;

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
        assertEquals(true, solve(path, 2), "path independent set size 2");
        assertEquals(true, solve(path, 0), "empty set");
        assertEquals(false, solve(path, 3), "path independent set size 3");
        assertEquals(false, solve(path, 5), "set larger than graph");
        assertEquals(true, solve(undirected(3, new int[][]{}), 3),
                "edgeless graph independent set");
    }

    private static Graph<Integer> undirected(int vertexCount, int[][] edges) {
        Graph<Integer> graph = new Graph<>(false);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addEdge(edge[0], edge[1]);
        return graph;
    }
}
