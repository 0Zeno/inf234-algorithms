package chapter03;

import java.util.*;
import graph.Graph;

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
        if (order.size() != 6) throw new AssertionError("missing vertices");
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < order.size(); i++) position.put(order.get(i), i);
        for (int u : graph.vertices())
            for (int v : graph.neighbours(u))
                if (position.get(u) >= position.get(v)) throw new AssertionError("invalid topological order");
        if (!solve(directed(0, new int[][]{})).isEmpty())
            throw new AssertionError("empty graph should have an empty topological order");
        if (!solve(directed(1, new int[][]{})).equals(List.of(0)))
            throw new AssertionError("singleton graph should contain its only vertex");
    }

    private static Graph<Integer> directed(int vertexCount, int[][] edges) {
        Graph<Integer> graph = new Graph<>(true);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addEdge(edge[0], edge[1]);
        return graph;
    }
}
