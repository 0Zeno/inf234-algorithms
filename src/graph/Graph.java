package graph;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V> implements IGraph<V> {
    private final Map<V, LinkedHashSet<V>> adjacency = new LinkedHashMap<>();
    private final boolean directed;

    public Graph() {
        this(false);
    }

    public Graph(boolean directed) {
        this.directed = directed;
    }

    public Graph(Iterable<? extends V> vertices) {
        this(vertices, false);
    }

    public Graph(Iterable<? extends V> vertices, boolean directed) {
        this(directed);
        for (V vertex : vertices)
            addVertex(vertex);
    }

    public boolean isDirected() {
        return directed;
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
        if (!adjacency.containsKey(vertex))
            return;
        adjacency.remove(vertex);
        for (LinkedHashSet<V> neighbours : adjacency.values())
            neighbours.remove(vertex);
    }

    @Override
    public void addEdge(V u, V v) {
        if (!adjacency.containsKey(u) || !adjacency.containsKey(v))
            throw new IllegalArgumentException("Both vertices must be in the graph");
        adjacency.get(u).add(v);
        if (!directed)
            adjacency.get(v).add(u);
    }

    public void addDirectedEdge(V u, V v) {
        addEdge(u, v);
    }

    @Override
    public void removeEdge(V u, V v) {
        if (!adjacency.containsKey(u) || !adjacency.containsKey(v))
            return;
        adjacency.get(u).remove(v);
        if (!directed)
            adjacency.get(v).remove(u);
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
}
