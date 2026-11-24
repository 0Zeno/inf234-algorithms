package graph;

import java.util.Set;

public interface IGraph<V> {
    int size();

    Iterable<V> vertices();

    void addVertex(V vertex);

    void removeVertex(V vertex);

    void addEdge(V u, V v);

    void removeEdge(V u, V v);

    boolean hasVertex(V vertex);

    boolean adjacent(V u, V v);

    Set<V> neighbours(V vertex);
}
