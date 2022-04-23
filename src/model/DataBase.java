package model;

public class DataBase {

    private BinaryTree<Integer, Person> codeTree;
    private BinaryTree<String, Person> nameTree;
    private BinaryTree<String, Person> surnameTree;
    private BinaryTree<String, Person> birthDateTree;
    private BinaryTree<Double, Person> heightTree;

    public DataBase() {

        codeTree = new BinaryTree<>();
        nameTree = new BinaryTree<>();
        surnameTree = new BinaryTree<>();
        birthDateTree = new BinaryTree<>();
        heightTree = new BinaryTree<>();
    }

    public BinaryTree<Integer, Person> getCodeTree() {
        return codeTree;
    }

    public void setCodeTree(BinaryTree<Integer, Person> codeTree) {
        this.codeTree = codeTree;
    }

    public BinaryTree<String, Person> getNameTree() {
        return nameTree;
    }

    public void setNameTree(BinaryTree<String, Person> nameTree) {
        this.nameTree = nameTree;
    }

    public BinaryTree<String, Person> getSurnameTree() {
        return surnameTree;
    }

    public void setSurnameTree(BinaryTree<String, Person> surnameTree) {
        this.surnameTree = surnameTree;
    }

    public BinaryTree<String, Person> getBirthDateTree() {
        return birthDateTree;
    }

    public void setBirthDateTree(BinaryTree<String, Person> birthDateTree) {
        this.birthDateTree = birthDateTree;
    }

    public BinaryTree<Double, Person> getHeightTree() {
        return heightTree;
    }

    public void setHeightTree(BinaryTree<Double, Person> heightTree) {
        this.heightTree = heightTree;
    }

    public void addToAllTrees(Person person) {

        codeTree.add(person);
//        nameTree.add(person);
//        surnameTree.add(person);
//        birthDateTree.add(person);
//        heightTree.add(person);
    }
}