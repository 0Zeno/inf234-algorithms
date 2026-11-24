package chapter06;

import static testutil.TestAssertions.assertEquals;

public class EditDistance {
    /**
     * Inputs: two strings.
     * Result: the minimum insertions, deletions, and substitutions needed to transform one into the other.
     */
    public static int solve(String first, String second) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        assertEquals(3, solve("saturday", "sunday"), "saturday-to-sunday edit distance");
        assertEquals(0, solve("same", "same"), "equal strings have distance 0");
        assertEquals(3, solve("", "abc"), "empty-to-abc edit distance");
        assertEquals(3, solve("abc", ""), "abc-to-empty edit distance");
        assertEquals(3, solve("kitten", "sitting"), "kitten-to-sitting edit distance");
    }
}
