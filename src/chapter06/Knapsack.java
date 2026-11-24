package chapter06;

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
        if (value != 220) throw new AssertionError("expected knapsack value 220, got " + value);
        if (solve(0, new Item[]{new Item(1, 10)}) != 0)
            throw new AssertionError("zero capacity should have zero value");
        if (solve(5, new Item[]{new Item(6, 100), new Item(5, 7)}) != 7)
            throw new AssertionError("items exceeding capacity should be excluded");
        if (solve(10, new Item[]{}) != 0)
            throw new AssertionError("an empty item list has zero value");
        if (solve(10, new Item[]{new Item(10, 25), new Item(11, 100)}) != 25)
            throw new AssertionError("an item using exact capacity should be selectable");
    }
}
