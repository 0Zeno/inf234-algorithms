import graph.Graph;
import graph.WeightedGraph;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.RecordComponent;
import java.lang.reflect.Type;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class InteractiveCli {
    private record Algorithm(String name, Class<?> type) {}

    private static final List<Algorithm> ALGORITHMS = List.of(
            algorithm("Chapter 1: Stable matching", chapter01.StableMatching.class),
            algorithm("Chapter 3: Breadth-first search", chapter03.BreadthFirstSearch.class),
            algorithm("Chapter 3: Depth-first search", chapter03.DepthFirstSearch.class),
            algorithm("Chapter 3: Bipartite test", chapter03.BipartiteTest.class),
            algorithm("Chapter 3: Topological sort", chapter03.TopologicalSort.class),
            algorithm("Chapter 4: Interval scheduling", chapter04.IntervalScheduling.class),
            algorithm("Chapter 4: Lateness scheduling", chapter04.LatenessScheduling.class),
            algorithm("Chapter 4: Dijkstra", chapter04.Dijkstra.class),
            algorithm("Chapter 4: Minimum spanning tree", chapter04.MinimumSpanningTree.class),
            algorithm("Chapter 5: Merge sort", chapter05.MergeSort.class),
            algorithm("Chapter 5: Count inversions", chapter05.CountInversions.class),
            algorithm("Chapter 5: Integer multiplication", chapter05.IntegerMultiplication.class),
            algorithm("Chapter 5: Closest pair", chapter05.ClosestPair.class),
            algorithm("Chapter 6: Weighted interval scheduling", chapter06.WeightedIntervalScheduling.class),
            algorithm("Chapter 6: Segmented least squares", chapter06.SegmentedLeastSquares.class),
            algorithm("Chapter 6: Subset sum", chapter06.SubsetSum.class),
            algorithm("Chapter 6: 0/1 knapsack", chapter06.Knapsack.class),
            algorithm("Chapter 6: Edit distance", chapter06.EditDistance.class),
            algorithm("Chapter 6: Bellman-Ford", chapter06.BellmanFord.class),
            algorithm("Chapter 6: Fibonacci", chapter06.Fibonacci.class),
            algorithm("Chapter 7: Maximum flow", chapter07.MaximumFlow.class),
            algorithm("Chapter 7: Bipartite matching", chapter07.BipartiteMatching.class),
            algorithm("Chapter 7: Disjoint paths", chapter07.DisjointPaths.class),
            algorithm("Chapter 7: Minimum-cost matching", chapter07.MinimumCostMatching.class),
            algorithm("Chapter 8: 3-SAT", chapter08.ThreeSat.class),
            algorithm("Chapter 8: Independent set", chapter08.IndependentSet.class),
            algorithm("Chapter 8: Vertex cover", chapter08.VertexCover.class),
            algorithm("Chapter 8: Hamiltonian path", chapter08.HamiltonianPath.class),
            algorithm("Chapter 8: Travelling salesman", chapter08.TravellingSalesman.class)
    );

    private static Algorithm algorithm(String name, Class<?> type) {
        return new Algorithm(name, type);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int lastTest = ALGORITHMS.size() - 1;
            while (true) {
                System.out.println("\nINF234 Algorithm CLI");
                System.out.println("1. Run all tests");
                System.out.println("2. Run one test");
                System.out.println("3. Run last test (default)");
                System.out.println("4. Run solve with custom input");
                System.out.println("5. Exit");
                System.out.print("Choose [3]: ");
                String choice = scanner.nextLine().trim();
                if (choice.isEmpty()) choice = "3";

                switch (choice) {
                    case "1" -> {
                        runFreshBuild("Main");
                        lastTest = ALGORITHMS.size() - 1;
                    }
                    case "2" -> {
                        int selected = chooseAlgorithm(scanner);
                        if (selected >= 0) {
                            lastTest = selected;
                            runTest(ALGORITHMS.get(selected));
                        }
                    }
                    case "3" -> runTest(ALGORITHMS.get(lastTest));
                    case "4" -> runCustomSolve(scanner);
                    case "5" -> {
                        return;
                    }
                    default -> System.out.println("Please choose 1, 2, 3, 4, or 5.");
                }
            }
        }
    }

    private static int chooseAlgorithm(Scanner scanner) {
        printAlgorithms();
        System.out.print("Choose an algorithm number (or 0 to cancel): ");
        try {
            int selection = Integer.parseInt(scanner.nextLine().trim());
            if (selection == 0) return -1;
            if (selection < 1 || selection > ALGORITHMS.size()) {
                System.out.println("That number is not in the list.");
                return -1;
            }
            return selection - 1;
        } catch (NumberFormatException exception) {
            System.out.println("Please enter a number from the list.");
            return -1;
        }
    }

    private static void printAlgorithms() {
        for (int i = 0; i < ALGORITHMS.size(); i++)
            System.out.printf("%2d. %s%n", i + 1, ALGORITHMS.get(i).name());
    }

    private static void runTest(Algorithm algorithm) {
        runFreshBuild("Main", "--test", algorithm.name(), algorithm.type().getName());
    }

    private static void runFreshBuild(String... applicationArgs) {
        Path root = Path.of(System.getProperty("user.dir"));
        Path sourceRoot = root.resolve("src");
        Path outputDirectory = root.resolve("out/cli");
        String java = Path.of(System.getProperty("java.home"), "bin", "java").toString();
        String javac = Path.of(System.getProperty("java.home"), "bin", "javac").toString();

        try {
            Files.createDirectories(outputDirectory);
            List<String> compileCommand = new ArrayList<>(List.of(javac, "-d", outputDirectory.toString()));
            try (Stream<Path> sources = Files.walk(sourceRoot)) {
                sources.filter(path -> path.toString().endsWith(".java"))
                        .sorted()
                        .forEach(path -> compileCommand.add(path.toString()));
            }

            Process compilation = new ProcessBuilder(compileCommand).directory(root.toFile())
                    .inheritIO().start();
            if (compilation.waitFor() != 0) {
                System.out.println("Compilation failed; tests were not run.");
                return;
            }

            List<String> testCommand = new ArrayList<>(List.of(
                    java, "-ea", "-cp", outputDirectory.toString()));
            testCommand.addAll(List.of(applicationArgs));
            new ProcessBuilder(testCommand).directory(root.toFile()).inheritIO().start().waitFor();
        } catch (IOException exception) {
            System.out.println("Could not compile or run tests: " + exception.getMessage());
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted while compiling or running tests.");
        }
    }

    private static void runCustomSolve(Scanner scanner) {
        int selected = chooseAlgorithm(scanner);
        if (selected < 0) return;

        Algorithm algorithm = ALGORITHMS.get(selected);
        try {
            Method solve = algorithm.type().getMethod("solve", parameterClasses(algorithm.type()));
            Type[] parameterTypes = solve.getGenericParameterTypes();
            System.out.println("\n" + algorithm.name() + " solve input:");
            System.out.println("Enter one JSON array with one value per argument, in this order:");
            for (int i = 0; i < parameterTypes.length; i++)
                System.out.printf("  %d. %s%n", i + 1, describe(parameterTypes[i]));
            System.out.println("Records use JSON objects with their field names. Graphs use "
                    + "{\"vertices\":[...],\"edges\":[[from,to],...],\"directed\":true|false}; "
                    + "weighted graph edges are [from,to,weight].");
            System.out.println("Example input: " + jsonExample(parameterTypes, algorithm.type()));
            System.out.print("Input JSON: ");

            Object parsed = new JsonParser(scanner.nextLine()).parse();
            if (!(parsed instanceof List<?> arguments))
                throw new IllegalArgumentException("The input must be a JSON array.");
            if (arguments.size() != parameterTypes.length)
                throw new IllegalArgumentException("Expected " + parameterTypes.length
                        + " argument(s), but got " + arguments.size() + ".");

            Object[] converted = new Object[parameterTypes.length];
            for (int i = 0; i < converted.length; i++)
                converted[i] = convert(arguments.get(i), parameterTypes[i]);
            Object result = solve.invoke(null, converted);
            System.out.println("Result: " + (solve.getReturnType() == void.class
                    ? formatResult(converted.length == 1 ? converted[0] : converted)
                    : result));
        } catch (InvocationTargetException exception) {
            System.out.println("Solve failed: " + exception.getCause());
        } catch (ReflectiveOperationException | IllegalArgumentException exception) {
            System.out.println("Could not run solve: " + exception.getMessage());
        }
    }

    private static Class<?>[] parameterClasses(Class<?> algorithm) throws NoSuchMethodException {
        for (Method method : algorithm.getMethods())
            if (method.getName().equals("solve")) return method.getParameterTypes();
        throw new NoSuchMethodException("No public solve method found.");
    }

    private static String describe(Type type) {
        if (type instanceof Class<?> clazz && clazz.isArray())
            return describe(clazz.getComponentType()) + "[]";
        if (type instanceof ParameterizedType parameterized) {
            StringBuilder description = new StringBuilder(
                    ((Class<?>) parameterized.getRawType()).getSimpleName()).append('<');
            Type[] arguments = parameterized.getActualTypeArguments();
            for (int i = 0; i < arguments.length; i++) {
                if (i > 0) description.append(", ");
                description.append(describe(arguments[i]));
            }
            return description.append('>').toString();
        }
        if (type instanceof Class<?> clazz && clazz.isRecord()) return clazz.getSimpleName();
        if (type instanceof Class<?> clazz) return clazz.getSimpleName();
        return type.getTypeName();
    }

    private static String jsonExample(Type[] parameterTypes, Class<?> algorithm) {
        List<String> examples = new ArrayList<>();
        for (Type type : parameterTypes)
            examples.add(exampleValue(type, algorithm));
        return examples.toString();
    }

    private static String exampleValue(Type type, Class<?> algorithm) {
        if (type instanceof ParameterizedType parameterized) {
            Class<?> raw = (Class<?>) parameterized.getRawType();
            Type[] arguments = parameterized.getActualTypeArguments();
            if (raw == Graph.class || raw == WeightedGraph.class) {
                boolean directed = algorithm == chapter03.TopologicalSort.class
                        || algorithm == chapter04.Dijkstra.class
                        || algorithm == chapter06.BellmanFord.class
                        || algorithm == chapter07.MaximumFlow.class
                        || algorithm == chapter07.DisjointPaths.class;
                String edge = raw == Graph.class ? "[0,1]" : "[0,1,1]";
                return "{\"vertices\":[0,1],\"edges\":[" + edge + "],\"directed\":" + directed + "}";
            }
            if (raw == List.class)
                return "[" + exampleValue(arguments[0], algorithm) + "]";
            if (raw == Map.class)
                return "{\"A\":" + exampleValue(arguments[1], algorithm) + "}";
        }
        if (type instanceof Class<?> clazz && clazz.isArray())
            return "[" + exampleValue(clazz.getComponentType(), algorithm) + "]";
        if (type instanceof Class<?> clazz && clazz.isRecord()) {
            List<String> fields = new ArrayList<>();
            for (RecordComponent component : clazz.getRecordComponents()) {
                String value = exampleValue(component.getGenericType(), algorithm);
                if (component.getName().equals("end")) value = "1";
                if (component.getName().equals("rank")) value = "[\"X\"]";
                if (component.getName().equals("name")) value = "\"A\"";
                fields.add("\"" + component.getName() + "\":" + value);
            }
            return "{" + String.join(",", fields) + "}";
        }
        if (type == String.class) return "\"text\"";
        if (type == boolean.class || type == Boolean.class) return "false";
        if (type == double.class || type == Double.class) return "1.0";
        if (type == float.class || type == Float.class) return "1.0";
        if (type == long.class || type == Long.class) return "1";
        if (type == int.class || type == Integer.class) return "0";
        return "null";
    }

    private static Object convert(Object value, Type target) {
        if (target instanceof ParameterizedType parameterized) {
            Class<?> raw = (Class<?>) parameterized.getRawType();
            Type[] arguments = parameterized.getActualTypeArguments();
            if (raw == Graph.class || raw == WeightedGraph.class)
                return convertGraph(value, raw, arguments);
            if (raw == List.class) {
                List<?> source = requireList(value);
                List<Object> converted = new ArrayList<>();
                for (Object item : source) converted.add(convert(item, arguments[0]));
                return converted;
            }
            if (raw == Map.class) {
                if (!(value instanceof Map<?, ?> source))
                    throw new IllegalArgumentException("Expected a JSON object for " + describe(target) + ".");
                Map<Object, Object> converted = new LinkedHashMap<>();
                for (Map.Entry<?, ?> entry : source.entrySet())
                    converted.put(convert(entry.getKey(), arguments[0]),
                            convert(entry.getValue(), arguments[1]));
                return converted;
            }
            throw new IllegalArgumentException("Unsupported input type: " + describe(target));
        }
        if (!(target instanceof Class<?> clazz))
            throw new IllegalArgumentException("Unsupported input type: " + target.getTypeName());
        if (clazz.isArray()) {
            List<?> source = requireList(value);
            Object array = Array.newInstance(clazz.getComponentType(), source.size());
            for (int i = 0; i < source.size(); i++)
                Array.set(array, i, convert(source.get(i), clazz.getComponentType()));
            return array;
        }
        if (clazz.isRecord()) return convertRecord(value, clazz);
        if (clazz == String.class) {
            if (!(value instanceof String)) throw typeError("string");
            return value;
        }
        if (clazz == boolean.class || clazz == Boolean.class) {
            if (!(value instanceof Boolean)) throw typeError("boolean");
            return value;
        }
        if (value instanceof Number number) {
            if (clazz == int.class || clazz == Integer.class) return number.intValue();
            if (clazz == long.class || clazz == Long.class) return number.longValue();
            if (clazz == double.class || clazz == Double.class) return number.doubleValue();
            if (clazz == float.class || clazz == Float.class) return number.floatValue();
        }
        throw typeError(clazz.getSimpleName());
    }

    private static Object convertGraph(Object value, Class<?> graphType, Type[] arguments) {
        if (!(value instanceof Map<?, ?> graphData))
            throw new IllegalArgumentException("A graph must be a JSON object.");
        List<?> vertices = requireList(graphData.get("vertices"));
        List<?> edges = requireList(graphData.get("edges"));
        Object directedValue = graphData.containsKey("directed")
                ? graphData.get("directed") : Boolean.FALSE;
        if (!(directedValue instanceof Boolean directed))
            throw new IllegalArgumentException("Graph field 'directed' must be true or false.");

        List<Object> convertedVertices = new ArrayList<>();
        for (Object vertex : vertices) convertedVertices.add(convert(vertex, arguments[0]));
        if (graphType == Graph.class) {
            Graph<Object> graph = new Graph<>(convertedVertices, directed);
            for (Object edgeValue : edges) {
                List<?> edge = requireList(edgeValue);
                if (edge.size() != 2)
                    throw new IllegalArgumentException("Each graph edge must have 2 values.");
                graph.addEdge(convert(edge.get(0), arguments[0]), convert(edge.get(1), arguments[0]));
            }
            return graph;
        }

        WeightedGraph<Object, Object> graph = new WeightedGraph<>(convertedVertices, directed);
        for (Object edgeValue : edges) {
            List<?> edge = requireList(edgeValue);
            if (edge.size() != 3)
                throw new IllegalArgumentException("Each weighted graph edge must have 3 values.");
            graph.addWeightedEdge(convert(edge.get(0), arguments[0]), convert(edge.get(1), arguments[0]),
                    convert(edge.get(2), arguments[1]));
        }
        return graph;
    }

    private static Object convertRecord(Object value, Class<?> recordType) {
        if (!(value instanceof Map<?, ?> fields))
            throw new IllegalArgumentException("Expected a JSON object for " + recordType.getSimpleName() + ".");
        RecordComponent[] components = recordType.getRecordComponents();
        Object[] values = new Object[components.length];
        Class<?>[] componentTypes = new Class<?>[components.length];
        for (int i = 0; i < components.length; i++) {
            RecordComponent component = components[i];
            if (!fields.containsKey(component.getName()))
                throw new IllegalArgumentException("Missing field '" + component.getName()
                        + "' for " + recordType.getSimpleName() + ".");
            values[i] = convert(fields.get(component.getName()), component.getGenericType());
            componentTypes[i] = component.getType();
        }
        try {
            return recordType.getConstructor(componentTypes).newInstance(values);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalArgumentException("Could not create " + recordType.getSimpleName() + ".", exception);
        }
    }

    private static List<?> requireList(Object value) {
        if (value instanceof List<?> list) return list;
        throw new IllegalArgumentException("Expected a JSON array.");
    }

    private static IllegalArgumentException typeError(String expected) {
        return new IllegalArgumentException("Expected a JSON " + expected + ".");
    }

    private static String formatResult(Object value) {
        if (value == null) return "null";
        if (!value.getClass().isArray()) return String.valueOf(value);
        List<String> elements = new ArrayList<>();
        for (int i = 0; i < Array.getLength(value); i++)
            elements.add(formatResult(Array.get(value, i)));
        return "[" + String.join(", ", elements) + "]";
    }

    private static final class JsonParser {
        private final String input;
        private int position;

        private JsonParser(String input) {
            this.input = input;
        }

        private Object parse() {
            Object result = parseValue();
            skipWhitespace();
            if (position != input.length()) fail("Unexpected content after the JSON value.");
            return result;
        }

        private Object parseValue() {
            skipWhitespace();
            if (position >= input.length()) return fail("Expected a JSON value.");
            return switch (input.charAt(position)) {
                case '{' -> parseObject();
                case '[' -> parseArray();
                case '"' -> parseString();
                case 't' -> parseLiteral("true", Boolean.TRUE);
                case 'f' -> parseLiteral("false", Boolean.FALSE);
                case 'n' -> parseLiteral("null", null);
                default -> parseNumber();
            };
        }

        private Map<String, Object> parseObject() {
            position++;
            Map<String, Object> object = new LinkedHashMap<>();
            skipWhitespace();
            if (take('}')) return object;
            do {
                skipWhitespace();
                if (position >= input.length() || input.charAt(position) != '"')
                    return fail("Expected a quoted object key.");
                String key = parseString();
                skipWhitespace();
                expect(':');
                object.put(key, parseValue());
                skipWhitespace();
                if (take('}')) return object;
                expect(',');
            } while (true);
        }

        private List<Object> parseArray() {
            position++;
            List<Object> array = new ArrayList<>();
            skipWhitespace();
            if (take(']')) return array;
            do {
                array.add(parseValue());
                skipWhitespace();
                if (take(']')) return array;
                expect(',');
            } while (true);
        }

        private String parseString() {
            expect('"');
            StringBuilder result = new StringBuilder();
            while (position < input.length()) {
                char character = input.charAt(position++);
                if (character == '"') return result.toString();
                if (character != '\\') {
                    result.append(character);
                    continue;
                }
                if (position == input.length()) return fail("Unterminated escape sequence.");
                char escaped = input.charAt(position++);
                switch (escaped) {
                    case '"', '\\', '/' -> result.append(escaped);
                    case 'b' -> result.append('\b');
                    case 'f' -> result.append('\f');
                    case 'n' -> result.append('\n');
                    case 'r' -> result.append('\r');
                    case 't' -> result.append('\t');
                    case 'u' -> {
                        if (position + 4 > input.length()) return fail("Incomplete Unicode escape.");
                        try {
                            result.append((char) Integer.parseInt(input.substring(position, position + 4), 16));
                        } catch (NumberFormatException exception) {
                            return fail("Invalid Unicode escape.");
                        }
                        position += 4;
                    }
                    default -> { return fail("Invalid string escape."); }
                }
            }
            return fail("Unterminated JSON string.");
        }

        private Object parseNumber() {
            int start = position;
            if (take('-')) {}
            while (position < input.length() && Character.isDigit(input.charAt(position))) position++;
            boolean decimal = false;
            if (take('.')) {
                decimal = true;
                while (position < input.length() && Character.isDigit(input.charAt(position))) position++;
            }
            if (position < input.length() && (input.charAt(position) == 'e' || input.charAt(position) == 'E')) {
                decimal = true;
                position++;
                if (position < input.length() && (input.charAt(position) == '+' || input.charAt(position) == '-'))
                    position++;
                while (position < input.length() && Character.isDigit(input.charAt(position))) position++;
            }
            if (start == position) return fail("Expected a JSON value.");
            String number = input.substring(start, position);
            try {
                return decimal ? Double.parseDouble(number) : Long.parseLong(number);
            } catch (NumberFormatException exception) {
                return fail("Invalid JSON number.");
            }
        }

        private Object parseLiteral(String literal, Object result) {
            if (!input.startsWith(literal, position)) return fail("Invalid JSON value.");
            position += literal.length();
            return result;
        }

        private void skipWhitespace() {
            while (position < input.length() && Character.isWhitespace(input.charAt(position))) position++;
        }

        private boolean take(char expected) {
            if (position < input.length() && input.charAt(position) == expected) {
                position++;
                return true;
            }
            return false;
        }

        private void expect(char expected) {
            if (!take(expected)) fail("Expected '" + expected + "'.");
        }

        private <T> T fail(String message) {
            throw new IllegalArgumentException(message + " At character " + (position + 1) + ".");
        }
    }
}
