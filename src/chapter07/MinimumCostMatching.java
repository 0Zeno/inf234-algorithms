package chapter07;

import java.util.List;

public class MinimumCostMatching {
    public record WeightedEdge(int left, int right, int cost) {}
    public record Graph(int leftSize, int rightSize, List<WeightedEdge> edges) {}

    public static int solve(Graph graph) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        int cost = solve(new Graph(3, 3, List.of(
                new WeightedEdge(0, 0, 1), new WeightedEdge(0, 1, 9),
                new WeightedEdge(1, 0, 2), new WeightedEdge(1, 2, 3),
                new WeightedEdge(2, 1, 4), new WeightedEdge(2, 2, 1))));
        if (cost != 6) throw new AssertionError("expected cost 6, got " + cost);
        if (solve(new Graph(1, 1, List.of(new WeightedEdge(0, 0, 8)))) != 8)
            throw new AssertionError("single-edge matching has the edge cost");
        if (solve(new Graph(2, 2, List.of())) != 0)
            throw new AssertionError("no available matching should have zero cost");
    }
}
