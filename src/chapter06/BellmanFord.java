package chapter06;

import java.util.*;
import graph.WeightedGraph;

public class BellmanFord {
    public record Edge(int from, int to, int weight) {}

    /**
     * Inputs: a directed graph, which may contain negative edges, and a start vertex.
     * Result: the shortest distance from the start to each reachable vertex.
     */
    public static Map<Integer, Integer> solve(WeightedGraph<Integer, Integer> graph, int start) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Map<Integer, Integer> d = solve(weighted(5, new int[][]{
                {0, 1, 6}, {0, 2, 7}, {1, 2, 8}, {1, 3, 5}, {1, 4, -4},
                {2, 3, -3}, {3, 1, -2}, {4, 3, 7}, {4, 0, 2}}), 0);
        if (!d.get(0).equals(0) || !d.get(2).equals(2))
            throw new AssertionError("Bellman-Ford distance mismatch");
        Map<Integer, Integer> negativeEdge = solve(weighted(3,
                new int[][]{{0, 1, 4}, {0, 2, 5}, {1, 2, -3}}), 0);
        if (!negativeEdge.get(2).equals(1))
            throw new AssertionError("negative edges should be relaxed correctly");
        if (solve(weighted(2, new int[][]{}), 0).containsKey(1))
            throw new AssertionError("unreachable vertices should not have a distance");
        if (!solve(weighted(1, new int[][]{}), 0).get(0).equals(0))
            throw new AssertionError("distance from a vertex to itself should be zero");
    }

    private static WeightedGraph<Integer, Integer> weighted(int vertexCount, int[][] edges) {
        WeightedGraph<Integer, Integer> graph = new WeightedGraph<>(true);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addWeightedEdge(edge[0], edge[1], edge[2]);
        return graph;
    }
}
