package chapter04;

import java.util.*;
import graph.WeightedGraph;

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
            if (!Objects.equals(d.get(i), expected[i]))
                throw new AssertionError("wrong distance to " + i);
        WeightedGraph<Integer, Integer> disconnected = weighted(3, new int[][]{{0, 1, 4}});
        Map<Integer, Integer> disconnectedDistances = solve(disconnected, 0);
        if (!Objects.equals(disconnectedDistances.get(1), 4))
            throw new AssertionError("wrong distance on a sparse graph");
        if (disconnectedDistances.containsKey(2))
            throw new AssertionError("unreachable vertices should not have a distance");
        if (!Objects.equals(solve(weighted(1, new int[][]{}), 0).get(0), 0))
            throw new AssertionError("distance from a vertex to itself should be zero");
        if (!Objects.equals(solve(weighted(3, new int[][]{{0, 1, 0}, {0, 2, 0}}), 0).get(1), 0))
            throw new AssertionError("zero-weight edges should be supported");
    }

    private static WeightedGraph<Integer, Integer> weighted(int vertexCount, int[][] edges) {
        WeightedGraph<Integer, Integer> graph = new WeightedGraph<>(true);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addWeightedEdge(edge[0], edge[1], edge[2]);
        return graph;
    }
}
