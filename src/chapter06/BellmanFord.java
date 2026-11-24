package chapter06;

import java.util.*;
import graph.WeightedGraph;

import static testutil.TestAssertions.assertEquals;

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
        assertEquals(0, d.get(0), "Bellman-Ford distance to vertex 0");
        assertEquals(2, d.get(2), "Bellman-Ford distance to vertex 2");
        Map<Integer, Integer> negativeEdge = solve(weighted(3,
                new int[][]{{0, 1, 4}, {0, 2, 5}, {1, 2, -3}}), 0);
        assertEquals(1, negativeEdge.get(2), "negative edge relaxation");
        assertEquals(false, solve(weighted(2, new int[][]{}), 0).containsKey(1),
                "unreachable vertex 1 should not have a distance");
        assertEquals(0, solve(weighted(1, new int[][]{}), 0).get(0),
                "distance from a vertex to itself");
    }

    private static WeightedGraph<Integer, Integer> weighted(int vertexCount, int[][] edges) {
        WeightedGraph<Integer, Integer> graph = new WeightedGraph<>(true);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addWeightedEdge(edge[0], edge[1], edge[2]);
        return graph;
    }
}
