package chapter04;

import java.util.*;

public class Dijkstra {
    public record Edge(int to, int weight) {}
    public record Graph(int vertexCount, List<List<Edge>> adjacency) {}

    public static Map<Integer, Integer> solve(Graph graph, int start) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5, List.of(
                List.of(new Edge(1, 2), new Edge(2, 7)),
                List.of(new Edge(2, 1), new Edge(3, 5)),
                List.of(new Edge(3, 1)), List.of(new Edge(4, 3)), List.of()));
        Map<Integer, Integer> d = solve(graph, 0);
        int[] expected = {0, 2, 3, 4, 7};
        for (int i = 0; i < expected.length; i++)
            if (!Objects.equals(d.get(i), expected[i]))
                throw new AssertionError("wrong distance to " + i);
        Graph disconnected = new Graph(3, List.of(
                List.of(new Edge(1, 4)), List.of(), List.of()));
        Map<Integer, Integer> disconnectedDistances = solve(disconnected, 0);
        if (!Objects.equals(disconnectedDistances.get(1), 4))
            throw new AssertionError("wrong distance on a sparse graph");
        if (disconnectedDistances.containsKey(2))
            throw new AssertionError("unreachable vertices should not have a distance");
        if (!Objects.equals(solve(new Graph(1, List.of(List.of())), 0).get(0), 0))
            throw new AssertionError("distance from a vertex to itself should be zero");
        if (!Objects.equals(solve(new Graph(3, List.of(
                List.of(new Edge(1, 0), new Edge(2, 0)), List.of(), List.of())), 0).get(1), 0))
            throw new AssertionError("zero-weight edges should be supported");
    }
}
