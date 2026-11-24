package chapter07;

import graph.WeightedGraph;

import static testutil.TestAssertions.assertEquals;

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
        assertEquals(6, cost, "minimum-cost matching");
        assertEquals(8, solve(weightedBipartite(1, 1, new int[][]{{0, 0, 8}}), 1),
                "single-edge matching");
        assertEquals(0, solve(weightedBipartite(2, 2, new int[][]{}), 2),
                "matching without edges");
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
