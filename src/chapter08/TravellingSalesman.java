package chapter08;
import graph.WeightedGraph;

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
        if (solve(completeWeighted(4, new int[][]{
                {0, 10, 15, 20}, {10, 0, 35, 25},
                {15, 35, 0, 30}, {20, 25, 30, 0}})) != 80)
            throw new AssertionError("wrong travelling-salesman cost");
        if (solve(completeWeighted(2, new int[][]{{0, 7}, {7, 0}})) != 14)
            throw new AssertionError("two-city tour should use both directions");
        if (solve(completeWeighted(1, new int[][]{{0}})) != 0)
            throw new AssertionError("one-city tour has zero cost");
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
