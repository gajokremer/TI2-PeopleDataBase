package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Random;

public class DataBase {

    private static final String NAME_SOURCE = "data/babynames-clean.csv";
    private static final String SURNAME_SOURCE = "data/Names_2010Census.csv";
    private static final String AVL_TREES = "data/trees.bin";

    private AVL<Person> codeTree;
    private AVL<Person> nameTree;
    private AVL<Person> surnameTree;
    private AVL<Person> fullNameTree;

//    private BinaryTree<Person> heightTree;

    public DataBase() {

        codeTree = new AVL<>(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getCode(),o2.getCode());
            }
        });

        nameTree = new AVL<>(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });


        surnameTree = new AVL<>(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });

        fullNameTree = new AVL<>(new Comparator<Person>() {

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

    public AVL<Person> getCodeTree() {
        return codeTree;
    }

    public void setCodeTree(AVL<Person> codeTree) {
        this.codeTree = codeTree;
    }

    public AVL<Person> getNameTree() {
        return nameTree;
    }

    public void setNameTree(AVL<Person> nameTree) {
        this.nameTree = nameTree;
    }

    public AVL<Person> getSurnameTree() {
        return surnameTree;
    }

    public void setSurnameTree(AVL<Person> surnameTree) {
        this.surnameTree = surnameTree;
    }

    public AVL<Person> getFullNameTree() {
        return fullNameTree;
    }

    public void setFullNameTree(AVL<Person> fullNameTree) {
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

    public void resetAllTrees() {

        codeTree.setRoot(null);
        nameTree.setRoot(null);
        surnameTree.setRoot(null);
        fullNameTree.setRoot(null);
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
            codeTree.setRoot((Node<Person>) ois.readObject());
            nameTree.setRoot((Node<Person>) ois.readObject());
            surnameTree.setRoot((Node<Person>) ois.readObject());
            fullNameTree.setRoot((Node<Person>) ois.readObject());
            ois.close();
//            isLoaded = true;
        }

        System.out.println(printAllTrees());
    }

    public void startSimulation(double number) throws IOException {

        for (double i = 0; i < number; i++) {

            String name, surname, birthDate, nationality;
            Gender gender = null;
            double height = 0;

            BufferedReader br = new BufferedReader(new FileReader(NAME_SOURCE));
//            String line = br.readLine();

            int lineToRead = 1 + (int) (Math.random() * ((6781 - 1) + 1));
            String line = Files.readAllLines(Paths.get(NAME_SOURCE)).get(lineToRead);

            String[] parts = line.split(",");

            System.out.println("Name: " + parts[0]);
            System.out.println("Gender: " + parts[1]);

            name = parts[0].toUpperCase();

            if (parts[1].equals("boy")) {

                gender = Gender.MALE;
                height = 170 + (Math.random() * ((195 - 170) + 1));

            } else if (parts[1].equals("girl")) {

                gender = Gender.FEMALE;
                height = 155 + (Math.random() * ((170 - 155) + 1));
            }

            line = br.readLine();
//            }

            br.close();


            br = new BufferedReader(new FileReader(SURNAME_SOURCE));
//        line = br.readLine();

            lineToRead = 2 + (int) (Math.random() * ((162254 - 2) + 1));
            line = Files.readAllLines(Paths.get(SURNAME_SOURCE)).get(lineToRead);

            parts = line.split(",");
            surname = parts[0];

            br.close();

            birthDate = generateRandomBirthDate();

            nationality = "American";

            Person person = new Person(name, surname, gender, birthDate, height, nationality);
            insertToAllTrees(person);
        }
    }

    private String generateRandomBirthDate() {

//        int age = (int) (Math.random() * (65 + 1));
//        int age = 0 + (int) (Math.random() * ((65 - 0) + 1));

        int age = 0;
        int day = 1 + (int) (Math.random() * ((29 - 1) + 1));
        int month = 1 + (int) (Math.random() * ((12 - 1) + 1));

        Random random = new Random();
        double probability = random.nextDouble();

//        if (probability <= 0.17) {
//
//            age = (int) (Math.random() * ((14) + 1));
//        }

        age = (int) (Math.random() * ((75) + 1));

        int year = 2022 - age;

        String result = String.valueOf(year) + "-";

        if (String.valueOf(month).length() == 1) {

            result += "0";
        }

        result += String.valueOf(month) + "-";

        if (String.valueOf(day).length() == 1) {

            result += "0";
        }

        result += String.valueOf(day);

        return result;
    }
}