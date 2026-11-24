package testutil;

import java.util.Objects;
import java.util.Arrays;

public final class TestAssertions {
    private TestAssertions() {}

    public static void assertEquals(Object expected, Object actual, String message) {
        if (!Objects.equals(expected, actual))
            throw new AssertionError(message + ": expected " + expected + ", got " + actual);
    }

    public static void assertEquals(int[] expected, int[] actual, String message) {
        if (!Arrays.equals(expected, actual))
            throw new AssertionError(message + ": expected " + Arrays.toString(expected) +
                    ", got " + Arrays.toString(actual));
    }

    public static void assertDoubleEquals(double expected, double actual, String message) {
        if (Math.abs(expected - actual) > 1e-9)
            throw new AssertionError(message + ": expected " + expected + ", got " + actual);
    }

    public static void assertTrue(boolean actual, String message) {
        if (!actual)
            throw new AssertionError(message + ": expected true, got " + actual);
    }

    public static void assertFalse(boolean actual, String message) {
        if (actual)
            throw new AssertionError(message + ": expected false, got " + actual);
    }
}
