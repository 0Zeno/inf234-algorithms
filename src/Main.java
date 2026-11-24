public class Main {
    public static void main(String[] args) {
        run("Chapter 1: Stable matching", chapter01.StableMatching.class);
        run("Chapter 3: Breadth-first search", chapter03.BreadthFirstSearch.class);
        run("Chapter 3: Depth-first search", chapter03.DepthFirstSearch.class);
        run("Chapter 3: Bipartite test", chapter03.BipartiteTest.class);
        run("Chapter 3: Topological sort", chapter03.TopologicalSort.class);

        run("Chapter 4: Interval scheduling", chapter04.IntervalScheduling.class);
        run("Chapter 4: Lateness scheduling", chapter04.LatenessScheduling.class);
        run("Chapter 4: Dijkstra", chapter04.Dijkstra.class);
        run("Chapter 4: Minimum spanning tree", chapter04.MinimumSpanningTree.class);

        run("Chapter 5: Merge sort", chapter05.MergeSort.class);
        run("Chapter 5: Count inversions", chapter05.CountInversions.class);
        run("Chapter 5: Integer multiplication", chapter05.IntegerMultiplication.class);
        run("Chapter 5: Closest pair", chapter05.ClosestPair.class);

        run("Chapter 6: Weighted interval scheduling", chapter06.WeightedIntervalScheduling.class);
        run("Chapter 6: Segmented least squares", chapter06.SegmentedLeastSquares.class);
        run("Chapter 6: Subset sum", chapter06.SubsetSum.class);
        run("Chapter 6: 0/1 knapsack", chapter06.Knapsack.class);
        run("Chapter 6: Edit distance", chapter06.EditDistance.class);
        run("Chapter 6: Bellman-Ford", chapter06.BellmanFord.class);

        run("Chapter 7: Maximum flow", chapter07.MaximumFlow.class);
        run("Chapter 7: Bipartite matching", chapter07.BipartiteMatching.class);
        run("Chapter 7: Disjoint paths", chapter07.DisjointPaths.class);
        run("Chapter 7: Minimum-cost matching", chapter07.MinimumCostMatching.class);

        run("Chapter 8: 3-SAT", chapter08.ThreeSat.class);
        run("Chapter 8: Independent set", chapter08.IndependentSet.class);
        run("Chapter 8: Vertex cover", chapter08.VertexCover.class);
        run("Chapter 8: Hamiltonian path", chapter08.HamiltonianPath.class);
        run("Chapter 8: Travelling salesman", chapter08.TravellingSalesman.class);
    }

    private static void run(String name, Class<?> algorithm) {
        System.out.println("\n=== " + name + " ===");
        try {
            algorithm
                    .getMethod("main", String[].class)
                    .invoke(null, (Object) new String[]{});
            System.out.println("PASS");
        } catch (java.lang.reflect.InvocationTargetException exception) {
            Throwable cause = exception.getCause();
            if (cause instanceof UnsupportedOperationException) {
                System.out.println("TODO");
            } else {
                System.out.println("FAIL: " + cause);
            }
        } catch (Exception exception) {
            System.out.println("FAIL: " + exception);
        }
    }
}
