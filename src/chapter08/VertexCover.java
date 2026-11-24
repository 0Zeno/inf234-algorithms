package chapter08;

import graph.Graph;

import static testutil.TestAssertions.assertEquals;

public class VertexCover {
    /**
     * Inputs: an undirected graph and a requested cover size.
     * Result: true if at least one set of that size is incident to every edge.
     */
    public static boolean solve(Graph<Integer> graph, int size) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Graph<Integer> path = undirected(4, new int[][]{{0, 1}, {1, 2}, {2, 3}});
        assertEquals(true, solve(path, 2), "path vertex cover size 2");
        assertEquals(false, solve(path, 1), "path vertex cover size 1");
        assertEquals(true, solve(undirected(3, new int[][]{}), 0), "edgeless vertex cover");
        assertEquals(true, solve(undirected(2, new int[][]{{0, 1}}), 1), "single-edge vertex cover");
        assertEquals(false, solve(path, 5), "cover larger than graph");
    }

    private static Graph<Integer> undirected(int vertexCount, int[][] edges) {
        Graph<Integer> graph = new Graph<>(false);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addEdge(edge[0], edge[1]);
        return graph;
    }
}
