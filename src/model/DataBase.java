package model;

import java.util.Comparator;

public class DataBase {

    private BinaryTree<Person> codeTree;
    private BinaryTree<Person> nameTree;
    private BinaryTree<Person> surnameTree;
    private BinaryTree<Person> fullNameTree;

    private BinaryTree<Person> heightTree;

    public DataBase() {

        codeTree = new BinaryTree<>(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getCode(),o2.getCode());
            }
        });

        nameTree = new BinaryTree<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });


        surnameTree = new BinaryTree<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });

        fullNameTree = new BinaryTree<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFullName().compareTo(o2.getFullName());

//                String name1 = o1.getName() + " " + o1.getSurname();
//                String name2 = o2.getName() + " " + o2.getSurname();

//                return name1.compareTo(name2);
            }
        });

//        heightTree = new BinaryTree<>(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return Double.compare(o1.getHeight(), o2.getHeight());
//            }
//        });
    }

    public BinaryTree<Person> getCodeTree() {
        return codeTree;
    }

    public void setCodeTree(BinaryTree<Person> codeTree) {
        this.codeTree = codeTree;
    }

    public BinaryTree<Person> getNameTree() {
        return nameTree;
    }

    public void setNameTree(BinaryTree<Person> nameTree) {
        this.nameTree = nameTree;
    }

    public BinaryTree<Person> getSurnameTree() {
        return surnameTree;
    }

    public void setSurnameTree(BinaryTree<Person> surnameTree) {
        this.surnameTree = surnameTree;
    }

    public BinaryTree<Person> getFullNameTree() {
        return fullNameTree;
    }

    public void setFullNameTree(BinaryTree<Person> fullNameTree) {
        this.fullNameTree = fullNameTree;
    }

    public BinaryTree<Person> getHeightTree() {
        return heightTree;
    }

    public void setHeightTree(BinaryTree<Person> heightTree) {
        this.heightTree = heightTree;
    }

    public void addToAllTrees(Person person) {

//        codeTree.insert(person);

//        nameTree.insert(person);
//        surnameTree.insert(person);
        fullNameTree.insert(person);

//        heightTree.insert(person);
    }
}