package graph;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<V, W> implements IGraph<V> {
    private final Map<V, LinkedHashSet<V>> adjacency = new LinkedHashMap<>();
    private final Map<WeightedEdge<V, W>, W> weights = new LinkedHashMap<>();
    private final boolean directed;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public WeightedGraph(Iterable<? extends V> vertices, boolean directed) {
        this(directed);
        for (V vertex : vertices)
            addVertex(vertex);
    }

    @Override
    public int size() {
        return adjacency.size();
    }

    @Override
    public Iterable<V> vertices() {
        return Collections.unmodifiableSet(adjacency.keySet());
    }

    @Override
    public void addVertex(V vertex) {
        adjacency.computeIfAbsent(vertex, ignored -> new LinkedHashSet<>());
    }

    @Override
    public void removeVertex(V vertex) {
        adjacency.remove(vertex);
        for (LinkedHashSet<V> neighbours : adjacency.values())
            neighbours.remove(vertex);
        weights.keySet().removeIf(edge -> edge.from().equals(vertex) || edge.to().equals(vertex));
    }

    @Override
    public void addEdge(V u, V v) {
        addWeightedEdge(u, v, null);
    }

    public void addWeightedEdge(V u, V v, W weight) {
        if (!adjacency.containsKey(u) || !adjacency.containsKey(v))
            throw new IllegalArgumentException("Both vertices must be in the graph");
        adjacency.get(u).add(v);
        weights.put(new WeightedEdge<>(u, v, weight), weight);
        if (!directed) {
            adjacency.get(v).add(u);
            weights.put(new WeightedEdge<>(v, u, weight), weight);
        }
    }

    @Override
    public void removeEdge(V u, V v) {
        adjacency.getOrDefault(u, new LinkedHashSet<>()).remove(v);
        weights.keySet().removeIf(edge ->
                edge.from().equals(u) && edge.to().equals(v));
        if (!directed) {
            adjacency.getOrDefault(v, new LinkedHashSet<>()).remove(u);
            weights.keySet().removeIf(edge ->
                    edge.from().equals(v) && edge.to().equals(u));
        }
    }

    @Override
    public boolean hasVertex(V vertex) {
        return adjacency.containsKey(vertex);
    }

    @Override
    public boolean adjacent(V u, V v) {
        LinkedHashSet<V> neighbours = adjacency.get(u);
        return neighbours != null && neighbours.contains(v);
    }

    @Override
    public Set<V> neighbours(V vertex) {
        LinkedHashSet<V> neighbours = adjacency.get(vertex);
        if (neighbours == null)
            throw new IllegalArgumentException("Vertex is not in the graph");
        return Collections.unmodifiableSet(neighbours);
    }

    public W weight(V u, V v) {
        for (WeightedEdge<V, W> edge : weights.keySet())
            if (edge.from().equals(u) && edge.to().equals(v))
                return edge.weight();
        return null;
    }

    public Iterable<WeightedEdge<V, W>> edges() {
        if (directed)
            return Collections.unmodifiableSet(weights.keySet());
        LinkedHashSet<WeightedEdge<V, W>> unique = new LinkedHashSet<>();
        for (WeightedEdge<V, W> edge : weights.keySet()) {
            boolean reverseAlreadySeen = false;
            for (WeightedEdge<V, W> seen : unique)
                if (seen.from().equals(edge.to()) && seen.to().equals(edge.from()))
                    reverseAlreadySeen = true;
            if (!reverseAlreadySeen)
                unique.add(edge);
        }
        return unique;
    }
}
