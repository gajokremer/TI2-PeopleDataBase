package model;

public class BinaryTree<K> {

    private BinaryNode<K> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryNode<K> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<K> root) {
        this.root = root;
    }

    public void add(K k) {

        BinaryNode<K> newNode = new BinaryNode<>(k);

        if (root == null) {

            root = newNode;

        } else {

            add(root, newNode);
        }
    }

    private void add(BinaryNode<K> root, BinaryNode<K> newNode) {


    }

    private void balanceTree() {


    }

    private static class BinaryNode<K> {

        private K k;
        private BinaryNode<K> parent;
        private BinaryNode<K> left;
        private BinaryNode<K> right;
        private boolean isLeaf;

        public BinaryNode(K k) {
            this.k = k;
            this.parent = null;
            this.left = null;
            this.right = null;
            this.isLeaf = true;
        }

        public K getK() {
            return k;
        }

        public void setK(K k) {
            this.k = k;
        }

        public BinaryNode<K> getParent() {
            return parent;
        }

        public void setParent(BinaryNode<K> parent) {
            this.parent = parent;
        }

        public BinaryNode<K> getLeft() {
            return left;
        }

        public void setLeft(BinaryNode<K> left) {
            this.left = left;
        }

        public BinaryNode<K> getRight() {
            return right;
        }

        public void setRight(BinaryNode<K> right) {
            this.right = right;
        }

        public boolean isLeaf() {
            return isLeaf;
        }

        public void setLeaf(boolean leaf) {
            isLeaf = leaf;
        }
    }
}