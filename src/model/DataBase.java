package model;

public class DataBase {

    private BinaryTree<Person> codeTree;
//    private BinaryTree<Person> nameTree;
//    private BinaryTree<Person> surnameTree;
//    private BinaryTree<Person> birthDateTree;
//    private BinaryTree<Double, Person> heightTree;

    public DataBase() {

        codeTree = new BinaryTree<>();
//        nameTree = new BinaryTree<>();
//        surnameTree = new BinaryTree<>();
//        birthDateTree = new BinaryTree<>();
//        heightTree = new BinaryTree<>();
    }

    public BinaryTree<Person> getCodeTree() {
        return codeTree;
    }

    public void setCodeTree(BinaryTree<Person> codeTree) {
        this.codeTree = codeTree;
    }

    public void addToAllTrees(Person person) {

        codeTree.add(person);
//        nameTree.add(person);
//        surnameTree.add(person);
//        birthDateTree.add(person);
//        heightTree.add(person);
    }
}