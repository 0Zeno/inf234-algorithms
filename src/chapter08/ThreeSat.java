package chapter08;

import java.util.List;

import static testutil.TestAssertions.assertEquals;

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
        assertEquals(true, solve(new CnfFormula(List.of(
                List.of(1, -2, 3), List.of(-1, 2, 3), List.of(-1, -2, -3)))),
                "satisfiable formula");
        assertEquals(false, solve(new CnfFormula(List.of(List.of(1, 1, 1), List.of(-1, -1, -1)))),
                "contradictory unit clauses");
        assertEquals(true, solve(new CnfFormula(List.of())),
                "empty formula");
    }
}
