package chapter06;

public class EditDistance {
    public static int solve(String first, String second) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        if (solve("saturday", "sunday") != 3)
            throw new AssertionError("expected edit distance 3");
        if (solve("same", "same") != 0)
            throw new AssertionError("equal strings have distance 0");
        if (solve("", "abc") != 3 || solve("abc", "") != 3)
            throw new AssertionError("empty-string distance is incorrect");
        if (solve("kitten", "sitting") != 3)
            throw new AssertionError("substitution distance is incorrect");
    }
}
