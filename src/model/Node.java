package model;

import jdk.nashorn.internal.ir.IfNode;

public class Node<V extends Comparable<V>> implements Balanced, Comparable<Node<V>> {

    private V v;
    private Node<V> parent;
    private Node<V> left;
    private Node<V> right;
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

    public Node<V> getParent() {
        return parent;
    }

    public void setParent(Node<V> parent) {
        this.parent = parent;
    }

    public Node<V> getLeft() {
        return left;
    }

    public void setLeft(Node<V> left) {
        this.left = left;
    }

    public Node<V> getRight() {
        return right;
    }

    public void setRight(Node<V> right) {
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
    public int balanceFactor() {


        return 0;
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

    private String nodeFormat() {

        String line = "";

        if(parent != null) {

            line += parent.nodeFormat() + " => ";
        }

        line += "[" + left + " <- "+ v.toString() + " -> " + right + "]";

        return line;
    }

    @Override
    public int compareTo(Node<V> o) {

       return v.compareTo(o.getV());
    }
}