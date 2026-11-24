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
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            result.add(curr);

            for (Integer v : graph.neighbours(curr)) {
                if (visited.add(v)) {
                    queue.add(v);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Graph<Integer> graph = undirected(4, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 } });
        equals("graph=0-1-2-3, start=0", List.of(0, 1, 2, 3), solve(graph, 0));
        equals("graph=0-1-2-3, start=3", List.of(3, 2, 1, 0), solve(graph, 3));
        equals("graph=0-1, start=0", List.of(0, 1), solve(undirected(4, new int[][] { { 0, 1 } }), 0));
        equals("graph=single vertex 2", List.of(2), solve(undirected(3, new int[][] {}), 2));
    }

    private static Graph<Integer> undirected(int vertexCount, int[][] edges) {
        Graph<Integer> graph = new Graph<>(false);
        for (int i = 0; i < vertexCount; i++)
            graph.addVertex(i);
        for (int[] edge : edges)
            graph.addEdge(edge[0], edge[1]);
        return graph;
    }

    private static void equals(String input, Object expected, Object actual) {
        assertEquals(input, expected, actual, "breadth-first search order");
    }
}
