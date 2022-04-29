package model;

public interface aTree<V> {

    void insert(V value);

    void delete(V value);

    V getMax();

    V getMin();

    boolean isEmpty();
}