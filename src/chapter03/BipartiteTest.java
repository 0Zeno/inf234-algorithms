package chapter03;

import java.util.List;
import graph.Graph;

public class BipartiteTest {
    /**
     * Input: an undirected graph.
     * Result: true if the vertices can be split into two sets with no edge within a set.
     */
    public static boolean solve(Graph<Integer> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        check(solve(undirected(4, new int[][]{{0, 1}, {1, 2}, {2, 3}})));
        check(!solve(undirected(3, new int[][]{{0, 1}, {0, 2}, {1, 2}})));
        check(solve(undirected(1, new int[][]{})));
        check(solve(undirected(0, new int[][]{})));
        check(!solve(undirected(1, new int[][]{{0, 0}})));
    }

    private static Graph<Integer> undirected(int vertexCount, int[][] edges) {
        Graph<Integer> graph = new Graph<>(false);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addEdge(edge[0], edge[1]);
        return graph;
    }

    private static void check(boolean condition) {
        if (!condition) throw new AssertionError("bipartite test failed");
    }
}
