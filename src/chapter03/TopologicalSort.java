package chapter03;

import java.util.*;

public class TopologicalSort {
    public record DirectedGraph(int vertexCount, List<List<Integer>> adjacency) {}

    public static List<Integer> solve(DirectedGraph graph) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(6,
                List.of(List.of(2, 3), List.of(3, 4), List.of(5),
                        List.of(5), List.of(5), List.of()));
        List<Integer> order = solve(graph);
        if (order.size() != 6) throw new AssertionError("missing vertices");
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < order.size(); i++) position.put(order.get(i), i);
        for (int u = 0; u < graph.adjacency().size(); u++)
            for (int v : graph.adjacency().get(u))
                if (position.get(u) >= position.get(v)) throw new AssertionError("invalid topological order");
        if (!solve(new DirectedGraph(0, List.of())).isEmpty())
            throw new AssertionError("empty graph should have an empty topological order");
        if (!solve(new DirectedGraph(1, List.of(List.of()))).equals(List.of(0)))
            throw new AssertionError("singleton graph should contain its only vertex");
    }
}
