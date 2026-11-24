package chapter05;

import java.util.Arrays;

import static testutil.TestAssertions.assertEquals;

public class MergeSort {
    /**
     * Input: an integer array.
     * Result: the same array, sorted in ascending order in place.
     */
    public static void solve(int[] values) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        int[] values = {5, 1, 4, 2, 8, 0};
        solve(values);
        assertEquals(new int[]{0, 1, 2, 4, 5, 8}, values, "main merge-sort result");
        int[] duplicates = {3, 1, 3, 2, 1};
        solve(duplicates);
        assertEquals(new int[]{1, 1, 2, 3, 3}, duplicates, "merge sort should preserve duplicate values");
        int[] empty = {};
        solve(empty);
        assertEquals(new int[]{}, empty, "empty input should remain empty");
        int[] singleton = {7};
        solve(singleton);
        assertEquals(new int[]{7}, singleton, "singleton input should remain unchanged");
    }
}
