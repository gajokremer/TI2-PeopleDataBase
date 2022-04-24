package model;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {

//    @org.junit.jupiter.api.Test
//    void isBalanced() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void testToString() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void nodeFormat() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void method() {
//    }

    private BinaryTree<Person> setUpScenario1() {
        BinaryTree<Person> personBinaryTree = new BinaryTree<>();

        Person p1 = new Person("Gabriel", "Kremer", Gender.MALE,
                "02-08-2002", 181, "Colombian");

        personBinaryTree.add(p1);

        return personBinaryTree;
    }

//    @Test
//    public void test1() {
//
//        Person p1 = new Person();
//        p1.setCode(1);
//
//        Person p2 = new Person();
//        p2.setCode(2);
//
//        Person p3 = new Person();
//        p2.setCode(2);
//
////        System.out.println("p1 to p2: " + p1.compareTo(p2));
////        System.out.println("p2 to p1: " + p2.compareTo(p1));
//    }


    @Test
    public void add() {

        BinaryTree<Person> binaryTree = setUpScenario1();

//        System.out.println("\n" + binaryTree);

        Person p2 = new Person("Sebastian", "Zapata", Gender.MALE,
                "20-08-2001", 183, "Colombian");
        binaryTree.add(p2);

//        System.out.println("\n" + personBinaryTree);
    }
}