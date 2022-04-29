package model;

import java.util.Comparator;

public class BinaryTree<V> implements aTree<V> {

    private BinNode<V> root;
    private final Comparator<V> comparator;

    public BinaryTree(Comparator<V> comparator) {

        this.comparator = comparator;
    }

    public BinNode<V> getRoot() {
        return root;
    }

    public void setRoot(BinNode<V> root) {
        this.root = root;
    }

    @Override
    public void insert(V value) {

        System.out.println("\n\n\nNEW ADDITION");

//        BinNode<V> newNode = new BinNode<>(value);
//
//        if (root == null) {
//
//            root = newNode;
//
//        } else {
//
//            insert(root, newNode);
//        }
//
//        System.out.println("\nADDED ✓");
//
//
//        boolean balanced = isTreeBalanced();
//        System.out.println("\nBalanced?: " + balanced);
//
//        if (!balanced) {
//
//            System.out.println("\nSTART BALANCING ->");
//            root = balance(root);
//
//            System.out.println("\nBALANCED ✓\n\n");

        root = insert(value, root);

        System.out.println("\nADDED ✓");
        System.out.println(this);

//        if (!isTreeBalanced()) {
//
//            System.out.println("\nSTART BALANCING ->");
//            root = balance(root);
//
//            System.out.println("\nBALANCED ✓\n\n");
//        }
    }

    private BinNode<V> insert(V value, BinNode<V> current) {

//        if (current != null) {
//
//            //            System.out.println("\n-Current: " + current);
//            //            System.out.println("-New Node: " + newNode);
//
//            //            System.out.println("Compare: " + newNode.compareTo(current));
//            //
//            if (newNode.compareTo(current) < 0) {
//                //            if (newNode.getV().getCode() < current.getV().getCode()) {
//
//                if (current.getLeft() == null) {
//
//                    current.setLeft(newNode);
//                    //                    current.setLeaf(false);
//                    //                    newNode.setParent(current);
//
//                } else {
//
//                    return insert(current.getLeft(), newNode);
//                }
//            }
//
//            if (newNode.compareTo(current) > 0) {
//                //            if (newNode.getV().getCode() > current.getV().getCode()) {
//
//                if (current.getRight() == null) {
//
//                    current.setRight(newNode);
//                    //                    current.setLeaf(false);
//                    //                    newNode.setParent(current);
//
//                } else {
//
//                    return insert(current.getRight(), newNode);
//                }
//            }
//        }


        if (current == null) {

            return new BinNode<>(value);
        }

//        if (value.compareTo(current.getValue()) < 0) {
        if (comparator.compare(value, current.getValue()) < 0) {

            current.setLeft(insert(value, current.getLeft()));

//            System.out.println("\nADDED ✓");
//            System.out.println(this);

//        } else if (value.compareTo(current.getValue()) > 0) {
        } else if (comparator.compare(value, current.getValue()) > 0) {

            current.setRight(insert(value, current.getRight()));

//            System.out.println("\nADDED ✓");
//            System.out.println(this);
        }

//        else {
//
//            return current;
//        }

//        return balance(current);


//        if (!isTreeBalanced()) {
//
//            System.out.println("\nSTART BALANCING ->");
//            current = applyRotations(current);
//
//            System.out.println("\nBALANCED ✓\n\n");
//        }
//
//        return current;

        return applyRotations(current);
    }

    @Override
    public void delete(V value) {

        root = delete(value, root);
    }

    private BinNode<V> delete(V value, BinNode<V> current) {

//        if (value.compareTo(current.getValue()) < 0) {
        if (comparator.compare(value, current.getValue()) < 0) {

            current.setLeft(delete(value, current.getLeft()));

//        } else if (value.compareTo(current.getValue()) > 0) {
        } else if (comparator.compare(value, current.getValue()) > 0) {

            current.setRight(delete(value, current.getRight()));

        } else {

            if (current.getLeft() == null) {

                return current.getRight();

            } else if (current.getRight() == null) {

                return current.getLeft();
            }

            current.setValue(getMax(current.getLeft()));
            current.setLeft(delete(current.getValue(), current.getLeft()));
        }

//        if (!isTreeBalanced()) {
//
//            System.out.println("\nSTART BALANCING ->");
//            current = applyRotations(current);
////
//            System.out.println("\nBALANCED ✓\n\n");
//        }
//
//        return current;

        return applyRotations(current);
    }

    public boolean isTreeBalanced() {

        return root.isBalanced();
    }

    public BinNode<V> applyRotations(BinNode<V> current){

//        System.out.println("\n------------BALANCE METHOD------------");

        if (current != null) {

            if (current.isBalanced()) {

                System.out.println("\n------------BALANCE METHOD------------");
                //            boolean wasRoot = current == root;

                int balanceFactor = current.findBalanceFactor();


                if (balanceFactor == 2) {

                    current = rightHeavy(current);
                }

                if (balanceFactor == -2) {

                    current = leftHeavy(current);
                }

                //            if (wasRoot) {
                //
                //                root = current;
                //            }

                return current;

            }
        }

        return null;
    }

    private BinNode<V> leftHeavy(BinNode<V> current) {

        int balanceFactorLeft = current.getLeft().findBalanceFactor();

        if (balanceFactorLeft == -1) {

            System.out.println("\nCASE D");

            current = rightRotate(current);
        }

        if (balanceFactorLeft == 0) {

            System.out.println("\nCASE E");

            current = rightRotate(current);
        }

        if (balanceFactorLeft == 1) {

            System.out.println("\nCASE F");

            BinNode<V> newLeft = leftRotate((current.getLeft()));
            current.setLeft(newLeft);
            current = rightRotate(current);
        }

        return current;
    }

    private BinNode<V> rightHeavy(BinNode<V> current) {

        int balanceFactorRight = current.getRight().findBalanceFactor();

        if (balanceFactorRight == 1) {

            System.out.println("\nCASE A");

            current = leftRotate(current);
        }

        if (balanceFactorRight == 0) {

            System.out.println("\nCASE B");

            current = leftRotate(current);
        }

        if (balanceFactorRight == -1) {

            System.out.println("\nCASE C");

            BinNode<V> newRight = rightRotate(current.getRight());
            current.setRight(newRight);
            current = leftRotate(current);
        }

        return current;
    }

    private BinNode<V> leftRotate(BinNode<V> current) {

        if (current != null) {

            BinNode<V> atRight = current.getRight();
            //            Node<V> aux = current;

            //            current = atRight;
            current.setRight(null);

            if (atRight.getLeft() != null) {

                current.setRight(atRight.getLeft());
            }

            atRight.setLeft(current);

            return atRight;
        }

        return null;
    }

    private BinNode<V> rightRotate(BinNode<V> current) {

        if (current != null) {

            BinNode<V> atLeft = current.getLeft();
            //            Node<V> aux = current;

            //            current = atLeft;
            current.setLeft(null);

            if (atLeft.getRight() != null) {

                current.setLeft(atLeft.getRight());
            }

            atLeft.setRight(current);

            return atLeft;
        }

        return null;
    }

    @Override
    public boolean isEmpty() {

        return root == null;
    }

    @Override
    public V getMax() {

        if (isEmpty()) {

            return null;
        }

        return getMax(root);
    }

    private V getMax(BinNode<V> current) {

        if (current.getRight()!= null) {

            return getMax(current.getRight());
        }

        return current.getValue();
    }

    @Override
    public V getMin() {

        if (isEmpty()) {

            return null;
        }

        return getMin(root);
    }

    private V getMin(BinNode<V> current) {

        if (current.getLeft()!= null) {

            return getMin(current.getLeft());
        }

        return current.getValue();
    }

    @Override
    public String toString() {
        return "BinaryTree{  " +
                "root=" + root +
                "  }";

        //        String line = "BinaryVree{";
        //
        //        return line;
    }
}