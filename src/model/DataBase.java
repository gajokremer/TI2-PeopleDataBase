package model;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class DataBase {

    private static final String NAME_SOURCE = "data/babynames-clean.csv";
    private static final String SURNAME_SOURCE = "data/Names_2010Census.csv";
    private static final String AVL_TREES = "data/trees.bin";

    private BinaryTree<Person> codeTree;
    private BinaryTree<Person> nameTree;
    private BinaryTree<Person> surnameTree;
    private BinaryTree<Person> fullNameTree;

//    private BinaryTree<Person> heightTree;

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

//    public BinaryTree<Person> getHeightTree() {
//        return heightTree;
//    }
//
//    public void setHeightTree(BinaryTree<Person> heightTree) {
//        this.heightTree = heightTree;
//    }

    public void insertToAllTrees(Person person) {

        codeTree.insert(person);
        nameTree.insert(person);
        surnameTree.insert(person);
        fullNameTree.insert(person);

//        try {
//            saveData();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        heightTree.insert(person);

        System.out.println(printAllTrees());
    }

    public void deleteFromAllTrees(Person person) {

        codeTree.delete(person);
        nameTree.delete(person);
        surnameTree.delete(person);
        fullNameTree.delete(person);

        System.out.println(printAllTrees());
    }

    public String printAllTrees() {

//        System.out.println("\n\n------PRINT TREES------");
//
//        System.out.println("\n=Code tree: " + dataBase.getCodeTree());
//        System.out.println("\n=Name tree: " + dataBase.getNameTree());
//        System.out.println("\n=Surname tree: " + dataBase.getSurnameTree());
//        System.out.println("\n=Full Name tree: " + dataBase.getFullNameTree());

        return "\n\n\n------PRINT TREES------" +
                "\n\n=Code tree: " + codeTree +
                "\n\n=Name tree: " + nameTree +
                "\n\n=Surname tree: " + surnameTree +
                "\n\n=Full Name tree: " + fullNameTree;
    }

    public void saveData() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(AVL_TREES)));
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BLOCKCHAIN_DATA_BIN));
        oos.writeObject(codeTree.getRoot());
        oos.writeObject(nameTree.getRoot());
        oos.writeObject(surnameTree.getRoot());
        oos.writeObject(fullNameTree.getRoot());

        System.out.println(printAllTrees());

        oos.close();
    }

    @SuppressWarnings("unchecked")
    public void loadData() throws IOException, ClassNotFoundException {

        File f = new File(AVL_TREES);

//        boolean isLoaded = false;

        if (f.exists()) {

            ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(f.toPath()));
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
//            blockChain = (List<Block>) ois.readObject();
            codeTree.setRoot((BinNode<Person>) ois.readObject());
            nameTree.setRoot((BinNode<Person>) ois.readObject());
            surnameTree.setRoot((BinNode<Person>) ois.readObject());
            fullNameTree.setRoot((BinNode<Person>) ois.readObject());
            ois.close();
//            isLoaded = true;
        }

        System.out.println(printAllTrees());
    }

    public void startSimulation() {


    }
}