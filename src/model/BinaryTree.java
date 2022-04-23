package model;

public class BinaryTree<P extends Comparable<P>, V> {

    private Node<P, V> root;
//    private boolean isBalanced;

    public BinaryTree() {
        this.root = null;
//        isBalanced = true;
    }

    public Node<P, V> getRoot() {
        return root;
    }

    public void setRoot(Node<P, V> root) {
        this.root = root;
    }

//    public boolean isBalanced() {
//        return isBalanced;
//    }
//
//    public void setBalanced(boolean balanced) {
//        isBalanced = balanced;
//    }

    public void add(V v) {

        Node<P, V> newNode = new Node<>(v);

        if (root == null) {

            root = newNode;

        } else {

            add(root, newNode);
        }

        System.out.println("New Node: " + newNode);
    }

    private void add(Node<P, V> current, Node<P, V> newNode) {

        if (current != null) {

        }
    }
}