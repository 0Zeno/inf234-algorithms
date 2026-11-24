package chapter03;

import java.util.*;
import graph.Graph;

import static testutil.TestAssertions.assertEquals;

public class TopologicalSort {
    /**
     * Input: a directed acyclic graph.
     * Result: a vertex order in which every directed edge goes from earlier to later.
     */
    public static List<Integer> solve(Graph<Integer> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Graph<Integer> graph = directed(6, new int[][]{
                {0, 2}, {0, 3}, {1, 3}, {1, 4}, {2, 5}, {3, 5}, {4, 5}});
        List<Integer> order = solve(graph);
        assertEquals(6, order.size(), "topological sort vertex count");
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < order.size(); i++) position.put(order.get(i), i);
        for (int u : graph.vertices())
            for (int v : graph.neighbours(u))
                if (position.get(u) >= position.get(v))
                    throw new AssertionError("invalid topological order: expected " + u +
                            " before " + v + ", got order " + order);
        assertEquals(List.of(), solve(directed(0, new int[][]{})),
                "empty graph topological order");
        assertEquals(List.of(0), solve(directed(1, new int[][]{})),
                "singleton graph topological order");
    }

    private static Graph<Integer> directed(int vertexCount, int[][] edges) {
        Graph<Integer> graph = new Graph<>(true);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addEdge(edge[0], edge[1]);
        return graph;
    }
}
