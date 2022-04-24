package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BinaryTreeTest {

    private BinaryTree<Person> setUpScenario1() {

        BinaryTree<Person> personBinaryTree = new BinaryTree<>();

        Person p1 = new Person("Gabriel", "Kremer", Gender.MALE,
                "2002-08-02", 181, "Colombian");

        personBinaryTree.add(p1);

        return personBinaryTree;
    }

    private BinaryTree<Person> setUpScenario2() {

        BinaryTree<Person> binaryTree = new BinaryTree<>();

        Person p1 = new Person("Gabriel", "Kremer", Gender.MALE,
                "2002-08-02", 181, "Colombian");
        binaryTree.add(p1);

        Person p2 = new Person("Sebastian", "Zapata", Gender.MALE,
                "2001-08-20", 183, "Colombian");
        binaryTree.add(p2);

        Person p3 = new Person("Sebastian", "Medina", Gender.MALE,
                "2002-09-25", 188, "Colombian");
        binaryTree.add(p3);

        return binaryTree;
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

        assertTrue(binaryTree.getRoot().isLeaf());

        Person p2 = new Person("Sebastian", "Zapata", Gender.MALE,
                "2001-08-20", 183, "Colombian");
        binaryTree.add(p2);

        assertFalse(binaryTree.getRoot().isLeaf());

//        System.out.println("\n" + personBinaryTree);
    }

    @Test
    public void balance() {

        BinaryTree<Person> binaryTree = setUpScenario1();
        System.out.println("\nASSERT 1");
        assertTrue(binaryTree.isTreeBalanced());

        Person p2 = new Person("Sebastian", "Zapata", Gender.MALE,
                "2001-08-20", 183, "Colombian");
        binaryTree.add(p2);

        System.out.println("\nASSERT 2");
        assertTrue(binaryTree.isTreeBalanced());


        binaryTree = setUpScenario2();
        System.out.println("\nASSERT 3");
        assertTrue(binaryTree.isTreeBalanced());

//        assertFalse(binaryTree.isBalanced());

//        binaryTree.balance(binaryTree.getRoot());

//        System.out.println("\n\n-After balance: " + binaryTree);

//        assertTrue(binaryTree.isBalanced());
    }
}