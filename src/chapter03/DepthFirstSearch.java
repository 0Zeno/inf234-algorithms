package chapter03;

import java.util.*;

public class DepthFirstSearch {
    public record Graph(int vertexCount, List<List<Integer>> adjacency) {}

    public static List<Integer> solve(Graph graph, int start) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4, List.of(List.of(1), List.of(0, 2), List.of(1, 3), List.of(2)));
        List<Integer> result = solve(graph, 0);
        if (result.size() != 4 || new HashSet<>(result).size() != 4)
            throw new AssertionError("DFS must visit every vertex once");
        result = solve(graph, 2);
        if (result.size() != 4 || result.get(0) != 2 || new HashSet<>(result).size() != 4)
            throw new AssertionError("DFS should visit every vertex once from the start vertex");
        if (!solve(new Graph(4, List.of(List.of(1), List.of(0), List.of(), List.of())), 0)
                .equals(List.of(0, 1)))
            throw new AssertionError("DFS should not visit disconnected vertices");
        if (!solve(new Graph(1, List.of(List.of())), 0).equals(List.of(0)))
            throw new AssertionError("DFS should visit a singleton graph");
    }
}
