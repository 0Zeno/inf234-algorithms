package chapter03;

import java.util.*;

public class BreadthFirstSearch {
    public record Graph(int vertexCount, List<List<Integer>> adjacency) {}

    public static List<Integer> solve(Graph graph, int start) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4, List.of(List.of(1), List.of(0, 2), List.of(1, 3), List.of(2)));
        equals(List.of(0, 1, 2, 3), solve(graph, 0));
        equals(List.of(3, 2, 1, 0), solve(graph, 3));
        equals(List.of(0, 1), solve(new Graph(4, List.of(List.of(1), List.of(0), List.of(), List.of())), 0));
        equals(List.of(2), solve(new Graph(3, List.of(List.of(), List.of(), List.of())), 2));
    }

    private static void equals(Object expected, Object actual) {
        if (!Objects.equals(expected, actual)) throw new AssertionError("expected " + expected + ", got " + actual);
    }
}
