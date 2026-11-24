package chapter08;

import java.util.List;

public class ThreeSat {
    public record CnfFormula(List<List<Integer>> clauses) {}

    /**
     * Input: a CNF formula whose clauses contain signed variable numbers.
     * Result: true if there is a truth assignment that satisfies every clause.
     */
    public static boolean solve(CnfFormula formula) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        if (!solve(new CnfFormula(List.of(
                List.of(1, -2, 3), List.of(-1, 2, 3), List.of(-1, -2, -3)))))
            throw new AssertionError("formula should be satisfiable");
        if (solve(new CnfFormula(List.of(List.of(1, 1, 1), List.of(-1, -1, -1)))))
            throw new AssertionError("contradictory unit clauses are unsatisfiable");
        if (!solve(new CnfFormula(List.of())))
            throw new AssertionError("an empty formula is satisfiable");
    }
}
