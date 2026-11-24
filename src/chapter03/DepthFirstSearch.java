package chapter03;

import java.util.*;
import graph.Graph;

public class DepthFirstSearch {
    /**
     * Inputs: a graph and the vertex at which to start.
     * Result: vertices reachable from the start in depth-first discovery order.
     */
    public static List<Integer> solve(Graph<Integer> graph, int start) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Graph<Integer> graph = undirected(4, new int[][]{{0, 1}, {1, 2}, {2, 3}});
        List<Integer> result = solve(graph, 0);
        if (result.size() != 4 || new HashSet<>(result).size() != 4)
            throw new AssertionError("DFS must visit every vertex once");
        result = solve(graph, 2);
        if (result.size() != 4 || result.get(0) != 2 || new HashSet<>(result).size() != 4)
            throw new AssertionError("DFS should visit every vertex once from the start vertex");
        if (!solve(undirected(4, new int[][]{{0, 1}}), 0)
                .equals(List.of(0, 1)))
            throw new AssertionError("DFS should not visit disconnected vertices");
        if (!solve(undirected(1, new int[][]{}), 0).equals(List.of(0)))
            throw new AssertionError("DFS should visit a singleton graph");
    }

    private static Graph<Integer> undirected(int vertexCount, int[][] edges) {
        Graph<Integer> graph = new Graph<>(false);
        for (int i = 0; i < vertexCount; i++) graph.addVertex(i);
        for (int[] edge : edges) graph.addEdge(edge[0], edge[1]);
        return graph;
    }
}
