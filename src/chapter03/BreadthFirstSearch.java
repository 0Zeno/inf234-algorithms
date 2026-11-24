package chapter03;

import java.util.*;
import graph.Graph;

import static testutil.TestAssertions.assertEquals;

public class BreadthFirstSearch {
    /**
     * Inputs: a graph and the vertex at which to start.
     * Result: vertices reachable from the start in breadth-first discovery order.
     */
    public static List<Integer> solve(Graph<Integer> graph, int start) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Graph<Integer> graph = undirected(4, new int[][]{{0, 1}, {1, 2}, {2, 3}});
        equals(List.of(0, 1, 2, 3), solve(graph, 0));
        equals(List.of(3, 2, 1, 0), solve(graph, 3));
        equals(List.of(0, 1), solve(undirected(4, new int[][]{{0, 1}}), 0));
        equals(List.of(2), solve(undirected(3, new int[][]{}), 2));
    }

    private static Graph<Integer> undirected(int vertexCount, int[][] edges) {
        Graph<Integer> graph = new Graph<>(false);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addEdge(edge[0], edge[1]);
        return graph;
    }

    private static void equals(Object expected, Object actual) {
        assertEquals(expected, actual, "breadth-first search order");
    }
}
