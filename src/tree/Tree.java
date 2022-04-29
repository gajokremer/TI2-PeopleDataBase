package tree;

public interface Tree<T extends Comparable<T>> {

        Tree<T> insert(T data);

        void delete(T data);

        String traverse();

        T getMax();

        T getMin();

        boolean isEmpty();
}