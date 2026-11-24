package chapter07;

import java.util.*;

public class BipartiteMatching {
    public record Graph(int leftSize, int rightSize, List<int[]> edges) {}

    public static Map<Integer, Integer> solve(Graph graph) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Map<Integer, Integer> m = solve(new Graph(4, 4, List.of(
                new int[]{0, 0}, new int[]{0, 1}, new int[]{1, 1},
                new int[]{1, 2}, new int[]{2, 2}, new int[]{3, 3})));
        if (new HashSet<>(m.values()).size() != 4)
            throw new AssertionError("expected matching size 4");
        if (!solve(new Graph(2, 3, List.of())).isEmpty())
            throw new AssertionError("a graph without edges has no matching");
        Map<Integer, Integer> partial = solve(new Graph(3, 2, List.of(
                new int[]{0, 0}, new int[]{1, 0}, new int[]{1, 1})));
        if (new HashSet<>(partial.values()).size() != partial.size() || partial.size() != 2)
            throw new AssertionError("matching should use each right vertex at most once");
        if (solve(new Graph(0, 0, List.of())).size() != 0)
            throw new AssertionError("empty bipartite graph has no matches");
    }
}
