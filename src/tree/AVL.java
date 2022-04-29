package tree;

public class AVL<T extends Comparable<T>> implements Tree<T> {

    Node<T> root;

    @Override
    public Tree<T> insert(T data) {

        root = insert(data, root);

        System.out.println(this);

        return this;
    }

    private Node<T> insert(T data, Node<T> current) {

        if (current == null) {

            return new Node<>(data);
        }

        if (data.compareTo(current.getData()) < 0) {

            current.setLeftChild(insert(data, current.getLeftChild()));

        } else if (data.compareTo(current.getData()) > 0) {

            current.setRightChild(insert(data, current.getRightChild()));

        } else {

            return current;
        }

        updateHeight(current);
        return applyRotation(current);
    }

    @Override
    public void delete(T data) {

        root =  delete(data, root);
    }

    public Node<T> delete(T data, Node<T> current) {

        if (data.compareTo(current.getData()) < 0) {

            current.setLeftChild(delete(data, root.getLeftChild()));

        } else if (data.compareTo(current.getData()) > 0) {

            current.setRightChild(delete(data, root.getRightChild()));

        } else {

            if (current.getLeftChild() == null) {

                return current.getRightChild();

            } else if (current.getRightChild() == null) {

                return current.getLeftChild();
            }

            current.setData(getMax(current.getLeftChild()));
            current.setLeftChild(delete(current.getData(), current.getLeftChild()));
        }

        updateHeight(current);
        return applyRotation(current);
    }

    private Node<T> applyRotation(Node<T> current) {

        int balance = balance(current);

        if (balance > 1) { //left heavy

            if (balance(current.getLeftChild()) > 0) {

                current.setLeftChild(rotateLeft(current.getLeftChild()));
            }

            return rotateRight(current);
        }


        if (balance < -1) { //right heavy

            if (balance(current.getRightChild()) < 0) {

                current.setRightChild(rotateRight(current.getLeftChild()));
            }

            return rotateLeft(current);
        }

        return current;
    }

    private Node<T> rotateLeft(Node<T> node) {

        Node<T> rightNode = node.getRightChild();
        Node<T> centerNode = rightNode.getLeftChild();

        rightNode.setLeftChild(node);
        node.setRightChild(centerNode);

        updateHeight(node);
        updateHeight(rightNode);

        return rightNode;
    }

    private Node<T> rotateRight(Node<T> node) {

        Node<T> leftNode = node.getLeftChild();
        Node<T> centerNode = leftNode.getRightChild();

        leftNode.setRightChild(node);
        node.setLeftChild(centerNode);

        updateHeight(node);
        updateHeight(leftNode);

        return leftNode;
    }


    private int balance(Node<T> current) {

        if (current != null) {

            return height(current.getLeftChild()) - height(current.getRightChild());
        }

        return 0;
    }

    private void updateHeight(Node<T> current) {

        int maxHeight = Math.max(
                height(current.getLeftChild()), height(current.getRightChild())
        );

        current.setHeight(maxHeight + 1);
    }


    public int height(Node<T> current) {

        if (current != null) {

           return current.getHeight();
        }

        return 0;
    }

    @Override
    public String traverse() {

        return traverseInOrder(root);
    }

    private String traverseInOrder(Node<T> current) {

        String result = "";

        if (current != null) {

//            String result = "";

            result += traverseInOrder(current.getLeftChild());
//            System.out.println(current);
            result += current;
            result += traverseInOrder(current.getRightChild());

//            return result;
        }

        return result;
    }

    @Override
    public T getMax() {

        if (isEmpty()) {

            return null;
        }

        return getMax(root);
    }

    private T getMax(Node<T> current) {

        if (current.getRightChild()!= null) {

            return getMax(current.getRightChild());
        }

        return current.getData();
    }

    @Override
    public T getMin() {

        if (isEmpty()) {

            return null;
        }

        return getMin(root);
    }

    private T getMin(Node<T> current) {

        if (current.getLeftChild()!= null) {

            return getMin(current.getLeftChild());
        }

        return current.getData();
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public String toString() {
        return "\nAVL{ " +
                "root=" + root +
                " }";
    }
}