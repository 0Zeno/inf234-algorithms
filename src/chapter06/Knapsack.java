package chapter06;

import static testutil.TestAssertions.assertEquals;

public class Knapsack {
    public record Item(int weight, int value) {}

    /**
     * Inputs: a maximum weight capacity and a list of items.
     * Result: the maximum value achievable without exceeding the capacity.
     */
    public static int solve(int capacity, Item[] items) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        int value = solve(50, new Item[]{
                new Item(10, 60), new Item(20, 100), new Item(30, 120)});
        assertEquals(220, value, "main knapsack value");
        assertEquals(0, solve(0, new Item[]{new Item(1, 10)}), "zero capacity");
        assertEquals(7, solve(5, new Item[]{new Item(6, 100), new Item(5, 7)}),
                "items exceeding capacity");
        assertEquals(0, solve(10, new Item[]{}), "empty item list");
        assertEquals(25, solve(10, new Item[]{new Item(10, 25), new Item(11, 100)}),
                "item using exact capacity");
    }
}
