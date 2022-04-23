package model;

public class Node<P extends Comparable<P>, V> implements Comparable<Node<P, V>>,Balanced {

    private V v;
    private Node<P, V> parent;
    private Node<P, V> left;
    private Node<P, V> right;
    private boolean isLeaf;

    public Node(V v) {
        this.v = v;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.isLeaf = true;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public Node<P, V> getParent() {
        return parent;
    }

    public void setParent(Node<P, V> parent) {
        this.parent = parent;
    }

    public Node<P, V> getLeft() {
        return left;
    }

    public void setLeft(Node<P, V> left) {
        this.left = left;
    }

    public Node<P, V> getRight() {
        return right;
    }

    public void setRight(Node<P, V> right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    @Override
    public boolean isBalanced() {
        return false;
    }

    @Override
    public String toString() {
        return "Node{" +
                "v=" + v +
                ", parent=" + parent +
                ", left=" + left +
                ", right=" + right +
                ", isLeaf=" + isLeaf +
                '}';
    }
    
    @Override
    public int compareTo(Node<P, V> o) {
        return 0;
    }

    public String nodeFormat() {

        String line = "";

        if(parent != null) {

            line += parent.nodeFormat() + " => ";
        }

        line += "[" + left + " <- "+ v + " -> " + right + "]";

        return line;
    }

}