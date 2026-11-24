package chapter03;

import java.util.List;
import graph.Graph;

import static testutil.TestAssertions.assertEquals;

public class BipartiteTest {
    /**
     * Input: an undirected graph.
     * Result: true if the vertices can be split into two sets with no edge within a set.
     */
    public static boolean solve(Graph<Integer> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        assertEquals(true, solve(undirected(4, new int[][]{{0, 1}, {1, 2}, {2, 3}})), "path should be bipartite");
        assertEquals(false, solve(undirected(3, new int[][]{{0, 1}, {0, 2}, {1, 2}})), "triangle should not be bipartite");
        assertEquals(true, solve(undirected(1, new int[][]{})), "singleton should be bipartite");
        assertEquals(true, solve(undirected(0, new int[][]{})), "empty graph should be bipartite");
        assertEquals(false, solve(undirected(1, new int[][]{{0, 0}})), "self-loop should not be bipartite");
    }

    private static Graph<Integer> undirected(int vertexCount, int[][] edges) {
        Graph<Integer> graph = new Graph<>(false);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addEdge(edge[0], edge[1]);
        return graph;
    }

}
