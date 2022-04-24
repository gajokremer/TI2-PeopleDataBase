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

        System.out.println("\n\n\nNEW ADDITION");

        Node<V> newNode = new Node<>(v);

        if (root == null) {

            root = newNode;

        } else {

            add(root, newNode);
        }

        System.out.println("\nADDED ✓");


        boolean balanced = isTreeBalanced();
        System.out.println("\nBalanced?: " + balanced);

        if (!balanced) {

            System.out.println("\nSTART BALANCING ->");
            balance(root);

            System.out.println("\nBALANCED ✓\n\n");
        }
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

    public boolean isTreeBalanced() {

        return root.isBalanced();
    }

    public void balance(Node<V> current){

        System.out.println("\n------------BALANCE METHOD------------");

        if (current != null) {

            boolean wasRoot = current == root;

            int balanceFactor = current.findBalanceFactor();


            if (balanceFactor == 2) {

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

                    Node<V> newRight = rightRotate(current.getRight());
                    current.setRight(newRight);
                    current = leftRotate(current);
                }
            }

            if (balanceFactor == -2) {

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

                    Node<V> newLeft = leftRotate((current.getLeft()));
                    current.setLeft(newLeft);
                    current = rightRotate(current);
                }
            }


            if (wasRoot) {

                root = current;
            }
        }
    }

    private Node<V> leftRotate(Node<V> current) {

        if (current != null) {

            Node<V> atRight = current.getRight();
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

    private Node<V> rightRotate(Node<V> current) {

        if (current != null) {

            Node<V> atLeft = current.getLeft();
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
    public String toString() {
        return "BinaryTree{  " +
                "root=" + root +
                "  }";

//        String line = "BinaryTree{";
//
//        return line;
    }
}