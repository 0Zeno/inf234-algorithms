package chapter07;

import java.util.*;
import graph.Graph;

import static testutil.TestAssertions.assertEquals;

public class BipartiteMatching {
    /**
     * Inputs: a bipartite graph and the number of vertices in its left partition.
     * Result: a mapping from matched left vertices to right vertices.
     */
    public static Map<Integer, Integer> solve(Graph<Integer> graph, int leftSize) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Map<Integer, Integer> m = solve(bipartite(4, 4, new int[][]{
                {0, 0}, {0, 1}, {1, 1}, {1, 2}, {2, 2}, {3, 3}}), 4);
        assertEquals(4, new HashSet<>(m.values()).size(), "main matching size");
        assertEquals(Map.of(), solve(bipartite(2, 3, new int[][]{}), 2),
                "graph without edges");
        Map<Integer, Integer> partial = solve(bipartite(3, 2,
                new int[][]{{0, 0}, {1, 0}, {1, 1}}), 3);
        assertEquals(2, partial.size(), "partial matching size");
        assertEquals(partial.size(), new HashSet<>(partial.values()).size(),
                "each right vertex should be matched at most once");
        assertEquals(0, solve(bipartite(0, 0, new int[][]{}), 0).size(),
                "empty bipartite graph");
    }

    private static Graph<Integer> bipartite(int leftSize, int rightSize, int[][] edges) {
        Graph<Integer> graph = new Graph<>(false);
        for (int i = 0; i < leftSize + rightSize; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addEdge(edge[0], leftSize + edge[1]);
        return graph;
    }
}
