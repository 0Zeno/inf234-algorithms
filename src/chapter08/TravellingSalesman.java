package chapter08;
import graph.WeightedGraph;

import static testutil.TestAssertions.assertEquals;

public class TravellingSalesman {
    /**
     * Input: a complete undirected weighted graph.
     * Result: the minimum cost of a tour that starts and ends at one vertex and
     * visits every vertex exactly once.
     */
    public static int solve(WeightedGraph<Integer, Integer> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        assertEquals(80, solve(completeWeighted(4, new int[][]{
                {0, 10, 15, 20}, {10, 0, 35, 25},
                {15, 35, 0, 30}, {20, 25, 30, 0}})),
                "travelling-salesman cost");
        assertEquals(14, solve(completeWeighted(2, new int[][]{{0, 7}, {7, 0}})),
                "two-city tour should use both directions");
        assertEquals(0, solve(completeWeighted(1, new int[][]{{0}})),
                "one-city tour has zero cost");
    }

    private static WeightedGraph<Integer, Integer> completeWeighted(int vertexCount, int[][] weights) {
        WeightedGraph<Integer, Integer> graph = new WeightedGraph<>(false);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int u = 0; u < vertexCount; u++)
            for (int v = u + 1; v < vertexCount; v++)
                graph.addWeightedEdge(u, v, weights[u][v]);
        return graph;
    }
}
