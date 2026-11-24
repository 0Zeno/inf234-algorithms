package chapter07;

import graph.WeightedGraph;

public class MinimumCostMatching {
    /**
     * Inputs: a weighted bipartite graph and the number of vertices in its left partition.
     * Result: the minimum total edge cost of a complete matching, or zero if none exists.
     */
    public static int solve(WeightedGraph<Integer, Integer> graph, int leftSize) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        int cost = solve(weightedBipartite(3, 3, new int[][]{
                {0, 0, 1}, {0, 1, 9}, {1, 0, 2},
                {1, 2, 3}, {2, 1, 4}, {2, 2, 1}}), 3);
        if (cost != 6) throw new AssertionError("expected cost 6, got " + cost);
        if (solve(weightedBipartite(1, 1, new int[][]{{0, 0, 8}}), 1) != 8)
            throw new AssertionError("single-edge matching has the edge cost");
        if (solve(weightedBipartite(2, 2, new int[][]{}), 2) != 0)
            throw new AssertionError("no available matching should have zero cost");
    }

    private static WeightedGraph<Integer, Integer> weightedBipartite(
            int leftSize, int rightSize, int[][] edges) {
        WeightedGraph<Integer, Integer> graph = new WeightedGraph<>(false);
        for (int i = 0; i < leftSize + rightSize; i++) graph.addVertex(i);
        for (int[] edge : edges)
            graph.addWeightedEdge(edge[0], leftSize + edge[1], edge[2]);
        return graph;
    }
}
