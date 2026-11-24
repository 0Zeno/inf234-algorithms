package chapter07;

import java.util.*;
import graph.Graph;

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
        if (new HashSet<>(m.values()).size() != 4)
            throw new AssertionError("expected matching size 4");
        if (!solve(bipartite(2, 3, new int[][]{}), 2).isEmpty())
            throw new AssertionError("a graph without edges has no matching");
        Map<Integer, Integer> partial = solve(bipartite(3, 2,
                new int[][]{{0, 0}, {1, 0}, {1, 1}}), 3);
        if (new HashSet<>(partial.values()).size() != partial.size() || partial.size() != 2)
            throw new AssertionError("matching should use each right vertex at most once");
        if (solve(bipartite(0, 0, new int[][]{}), 0).size() != 0)
            throw new AssertionError("empty bipartite graph has no matches");
    }

    private static Graph<Integer> bipartite(int leftSize, int rightSize, int[][] edges) {
        Graph<Integer> graph = new Graph<>(false);
        for (int i = 0; i < leftSize + rightSize; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addEdge(edge[0], leftSize + edge[1]);
        return graph;
    }
}
