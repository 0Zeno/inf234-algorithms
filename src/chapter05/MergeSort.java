package chapter05;

import java.util.Arrays;

public class MergeSort {
    public static void solve(int[] values) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        int[] values = {5, 1, 4, 2, 8, 0};
        solve(values);
        if (!Arrays.equals(values, new int[]{0, 1, 2, 4, 5, 8}))
            throw new AssertionError("wrong merge-sort result");
        int[] duplicates = {3, 1, 3, 2, 1};
        solve(duplicates);
        if (!Arrays.equals(duplicates, new int[]{1, 1, 2, 3, 3}))
            throw new AssertionError("merge sort should preserve duplicate values");
        int[] empty = {};
        solve(empty);
        if (empty.length != 0) throw new AssertionError("empty input should remain empty");
        int[] singleton = {7};
        solve(singleton);
        if (!Arrays.equals(singleton, new int[]{7}))
            throw new AssertionError("singleton input should remain unchanged");
    }
}
