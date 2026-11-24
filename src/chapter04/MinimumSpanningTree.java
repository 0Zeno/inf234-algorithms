package chapter04;

import java.util.*;
import graph.WeightedGraph;

import static testutil.TestAssertions.assertEquals;

public class MinimumSpanningTree {
    public record Edge(int u, int v, int weight) {}

    /**
     * Input: an undirected weighted graph.
     * Result: the minimum total weight needed to connect all vertices.
     */
    public static long solve(WeightedGraph<Integer, Integer> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        long weight = solve(weighted(4, new int[][]{
                {0, 1, 1}, {0, 2, 4}, {1, 2, 2}, {1, 3, 5}, {2, 3, 3}}));
        assertEquals(6L, weight, "main MST weight");
        assertEquals(0L, solve(weighted(1, new int[][]{})), "one vertex has MST weight 0");
        assertEquals(-1L, solve(weighted(3, new int[][]{{0, 1, -2}, {1, 2, 1}, {0, 2, 4}})),
                "MST should handle negative edge weights");
        assertEquals(0L, solve(weighted(0, new int[][]{})), "empty graph has MST weight 0");
    }

    private static WeightedGraph<Integer, Integer> weighted(int vertexCount, int[][] edges) {
        WeightedGraph<Integer, Integer> graph = new WeightedGraph<>(false);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addWeightedEdge(edge[0], edge[1], edge[2]);
        return graph;
    }
}
