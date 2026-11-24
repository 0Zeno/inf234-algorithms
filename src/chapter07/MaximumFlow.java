package chapter07;

import java.util.List;
import graph.WeightedGraph;

import static testutil.TestAssertions.assertEquals;

public class MaximumFlow {
    /**
     * Inputs: a directed weighted network, a source vertex, and a sink vertex.
     * Result: the maximum amount of flow that can travel from source to sink.
     */
    public static long solve(WeightedGraph<Integer, Long> network, int source, int sink) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        WeightedGraph<Integer, Long> n = network(6, new long[][]{
                {0, 1, 16}, {0, 2, 13}, {1, 2, 10}, {1, 3, 12},
                {2, 1, 4}, {2, 4, 14}, {3, 2, 9}, {3, 5, 20},
                {4, 3, 7}, {4, 5, 4}});
        assertEquals(23L, solve(n, 0, 5), "maximum flow");
        assertEquals(0L, solve(network(3, new long[][]{}), 0, 2), "network without edges");
        assertEquals(7L, solve(network(2, new long[][]{{0, 1, 7}}), 0, 1), "single-edge flow");
        assertEquals(0L, solve(network(2, new long[][]{{0, 1, 0}}), 0, 1), "zero-capacity edge");
    }

    private static WeightedGraph<Integer, Long> network(int vertexCount, long[][] edges) {
        WeightedGraph<Integer, Long> graph = new WeightedGraph<>(true);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (long[] edge : edges)
            graph.addWeightedEdge((int) edge[0], (int) edge[1], edge[2]);
        return graph;
    }
}
