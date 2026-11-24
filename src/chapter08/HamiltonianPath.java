package chapter08;

import graph.Graph;

import static testutil.TestAssertions.assertEquals;

public class HamiltonianPath {
    /**
     * Input: an undirected graph.
     * Result: true if it contains a path that visits every vertex exactly once.
     */
    public static boolean solve(Graph<Integer> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        assertEquals(true, solve(undirected(4, new int[][]{{0, 1}, {1, 2}, {2, 3}})),
                "path graph");
        assertEquals(false, solve(undirected(4, new int[][]{{0, 1}, {2, 3}})),
                "disconnected graph");
        assertEquals(true, solve(undirected(1, new int[][]{})), "single vertex");
        assertEquals(true, solve(undirected(4, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}})),
                "cycle graph");
    }

    private static Graph<Integer> undirected(int vertexCount, int[][] edges) {
        Graph<Integer> graph = new Graph<>(false);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addEdge(edge[0], edge[1]);
        return graph;
    }
}
