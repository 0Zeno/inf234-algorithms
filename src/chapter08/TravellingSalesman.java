package chapter08;

public class TravellingSalesman {
    public record CompleteWeightedGraph(int[][] weight) {}

    public static int solve(CompleteWeightedGraph graph) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        int[][] weights = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};
        if (solve(new CompleteWeightedGraph(weights)) != 80)
            throw new AssertionError("wrong travelling-salesman cost");
        if (solve(new CompleteWeightedGraph(new int[][]{{0, 7}, {7, 0}})) != 14)
            throw new AssertionError("two-city tour should use both directions");
        if (solve(new CompleteWeightedGraph(new int[][]{{0}})) != 0)
            throw new AssertionError("one-city tour has zero cost");
    }
}
