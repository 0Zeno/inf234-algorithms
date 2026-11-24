package chapter04;

import java.util.*;
import graph.WeightedGraph;

import static testutil.TestAssertions.assertEquals;

public class Dijkstra {
    public record Edge(int to, int weight) {}
    /**
     * Inputs: a directed graph with non-negative edge weights and a start vertex.
     * Result: the shortest distance from the start to each reachable vertex.
     */
    public static Map<Integer, Integer> solve(WeightedGraph<Integer, Integer> graph, int start) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        WeightedGraph<Integer, Integer> graph = weighted(5, new int[][]{
                {0, 1, 2}, {0, 2, 7}, {1, 2, 1}, {1, 3, 5}, {2, 3, 1}, {3, 4, 3}});
        Map<Integer, Integer> d = solve(graph, 0);
        int[] expected = {0, 2, 3, 4, 7};
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], d.get(i), "Dijkstra distance to vertex " + i);
        WeightedGraph<Integer, Integer> disconnected = weighted(3, new int[][]{{0, 1, 4}});
        Map<Integer, Integer> disconnectedDistances = solve(disconnected, 0);
        assertEquals(4, disconnectedDistances.get(1), "Dijkstra distance on sparse graph");
        assertEquals(false, disconnectedDistances.containsKey(2),
                "unreachable vertex 2 should not have a distance");
        assertEquals(0, solve(weighted(1, new int[][]{}), 0).get(0),
                "distance from a vertex to itself");
        assertEquals(0, solve(weighted(3, new int[][]{{0, 1, 0}, {0, 2, 0}}), 0).get(1),
                "zero-weight edge");
    }

    private static WeightedGraph<Integer, Integer> weighted(int vertexCount, int[][] edges) {
        WeightedGraph<Integer, Integer> graph = new WeightedGraph<>(true);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addWeightedEdge(edge[0], edge[1], edge[2]);
        return graph;
    }
}
