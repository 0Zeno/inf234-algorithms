package chapter04;

import java.util.*;
import graph.WeightedGraph;

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
        if (weight != 6) throw new AssertionError("expected MST weight 6, got " + weight);
        if (solve(weighted(1, new int[][]{})) != 0) throw new AssertionError("one vertex has MST weight 0");
        if (solve(weighted(3, new int[][]{{0, 1, -2}, {1, 2, 1}, {0, 2, 4}})) != -1)
            throw new AssertionError("MST should handle negative edge weights");
        if (solve(weighted(0, new int[][]{})) != 0) throw new AssertionError("empty graph has MST weight 0");
    }

    private static WeightedGraph<Integer, Integer> weighted(int vertexCount, int[][] edges) {
        WeightedGraph<Integer, Integer> graph = new WeightedGraph<>(false);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addWeightedEdge(edge[0], edge[1], edge[2]);
        return graph;
    }
}
