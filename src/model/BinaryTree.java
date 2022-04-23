package model;

public class BinaryTree<V extends Comparable<V>> {

    private Node<V> root;
//    private boolean isBalanced;

    public BinaryTree() {
        this.root = null;
//        isBalanced = true;
    }

    public Node<V> getRoot() {
        return root;
    }

    public void setRoot(Node<V> root) {
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

        Node<V> newNode = new Node<>(v);

        if (root == null) {

            root = newNode;

        } else {

            add(root, newNode);
        }

        System.out.println("\n-New Node: " + newNode);
    }

    private void add(Node<V> current, Node<V> newNode) {

        if (current != null) {

//            System.out.println("\n-Current: " + current);
//            System.out.println("-New Node: " + newNode);
//
//            System.out.println("Compare: " + newNode.compareTo(current));
//
            if (newNode.compareTo(current) < 0) {

                if (current.getLeft() == null) {

                    current.setLeft(newNode);
                    newNode.setParent(current);

                } else {

                    add(current.getLeft(), newNode);
                }
            }

            if (newNode.compareTo(current) > 0) {

                if (current.getRight() == null) {

                    current.setRight(newNode);
                    newNode.setParent(current);

                } else {

                    add(current.getRight(), newNode);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';

//        String line = "BinaryTree{";
//
//        return line;
    }

    private void printTree() {


    }
}