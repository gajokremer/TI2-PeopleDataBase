package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    private BinaryTree<Person> setUpScenario1() {

        BinaryTree<Person> personBinaryTree = new BinaryTree<>();

        Person p1 = new Person("Gabriel", "Kremer", Gender.MALE,
                "02-08-2002", 181, "Colombian");
        personBinaryTree.add(p1);

        Person p2 = new Person("Sebastian", "Zapata", Gender.MALE,
                "20-08-2001", 183, "Colombian");
        personBinaryTree.add(p2);

        return personBinaryTree;
    }

    @Test
    void isBalanced() {

        BinaryTree<Person> binaryTree = setUpScenario1();
//        assertTrue(binaryTree.getRoot().isBalanced());

        Person p3 = new Person("Sebastian", "Medina", Gender.MALE,
                "25-09-2002", 188, "Colombian");

        binaryTree.add(p3);

        System.out.println("\n" + binaryTree);
        System.out.println("\nBalanced?: " + binaryTree.getRoot().isBalanced());
    }

    @Test
    void balanceFactor() {

        BinaryTree<Person> binaryTree = setUpScenario1();
        assertEquals(1, Math.abs(binaryTree.getRoot().findBalanceFactor()));

//        System.out.println("\nDepth: " + binaryTree.getRoot().balanceFactor());
    }

    @Test
    void compareTo() {
    }
}