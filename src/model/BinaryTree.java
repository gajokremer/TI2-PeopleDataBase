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

//        System.out.println("\n-New Node: " + newNode);
    }

    private void add(Node<V> current, Node<V> newNode) {

        if (current != null) {

//            System.out.println("\n-Current: " + current);
//            System.out.println("-New Node: " + newNode);

//            System.out.println("Compare: " + newNode.compareTo(current));
//
            if (newNode.compareTo(current) < 0) {
//            if (newNode.getV().getCode() < current.getV().getCode()) {

                if (current.getLeft() == null) {

                    current.setLeft(newNode);
//                    current.setLeaf(false);
//                    newNode.setParent(current);

                } else {

                    add(current.getLeft(), newNode);
                }
            }

            if (newNode.compareTo(current) > 0) {
//            if (newNode.getV().getCode() > current.getV().getCode()) {

                if (current.getRight() == null) {

                    current.setRight(newNode);
//                    current.setLeaf(false);
//                    newNode.setParent(current);

                } else {

                    add(current.getRight(), newNode);
                }
            }
        }
    }

    public boolean isBalanced() {

        return root.isBalanced();
    }

    public void balance(Node<V> current){

        boolean wasRoot = current == root;

        int balanceFactor = current.findBalanceFactor();

       current = leftRotate(current);

       if (wasRoot) {

           root = current;
       }
    }

    private Node<V> leftRotate(Node<V> current) {

        Node<V> atLeft = current.getLeft();
        Node<V> aux = current;

        current = atLeft;
        current.setLeft(aux);
        current.getLeft().setLeft(null);

//        root = atLeft;
//        root.setLeft(current);
//        root.getLeft().setLeft(null);

        return atLeft;
    }

    private Node<V> rightRotate(Node<V> current) {


        return current;
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
}