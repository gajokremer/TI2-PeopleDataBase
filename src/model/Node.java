package model;

public class Node<V extends Comparable<V>> implements Balanced, Comparable<Node<V>> {

    private V v;
//    private Node<V> parent;
    private Node<V> left;
    private Node<V> right;
//    private boolean isLeaf;

    public Node(V v) {
        this.v = v;
//        this.parent = null;
        this.left = null;
        this.right = null;
//        this.isLeaf = true;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

//    public Node<V> getParent() {
//        return parent;
//    }
//
//    public void setParent(Node<V> parent) {
//        this.parent = parent;
//    }

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

        return right == null & left == null;
    }

//    public void setLeaf(boolean leaf) {
//        isLeaf = leaf;
//    }

    @Override
    public boolean isBalanced() {

        int factor = findBalanceFactor();

        return factor >= -1 && factor <= 1;
    }

    @Override
    public int findBalanceFactor() {

        System.out.println("\n=Root: " + this);

        int leftFactor = depth(left, 0);
        System.out.println("Done left");
        int rightFactor = depth(right, 0);
        System.out.println("Done right");

        System.out.println("-Left depth: " + leftFactor);
        System.out.println("-Right depth: " + rightFactor);

        return rightFactor - leftFactor;
    }

    private int depth(Node<V> current, int count) {

        System.out.println("\n--Current: " + current);

        if (current != null) {

            if (current.isLeaf()) {

                return count+1;
            }

            int leftCount = 0;
            int rightCount = 0;

            if (current.getLeft() != null) {

                leftCount = depth(current.getLeft(), count) + 1;
            }

                System.out.println("--Left count: " + leftCount);

            if (current.getRight() != null) {

                rightCount = depth(current.getRight(), count) + 1;
            }

                System.out.println("--Right count: " + rightCount);

//        if (leftCount > rightCount){
//
//            return leftCount;
//
//        } else {
//
//            return rightCount;
//        }

            return Math.max(leftCount, rightCount);
        }

        return 0;
    }

    @Override
    public void balance(){

    }

//    private int rightDepth(Node<V> current, int count) {
//
//
//        return count;
//    }

    @Override
    public String toString() {
        return "Node{" +
                "v=" + v +
//                ", parent=" + parent +
                ", left=" + left +
                ", right=" + right +
                ", isLeaf=" + isLeaf() +
                '}';
    }

//    private String nodeFormat() {
//
//        String line = "";
//
//        if(parent != null) {
//
//            line += parent.nodeFormat() + " => ";
//        }
//
//        line += "[" + left + " <- "+ v.toString() + " -> " + right + "]";
//
//        return line;
//    }

    @Override
    public int compareTo(Node<V> o) {

       return v.compareTo(o.getV());
    }
}