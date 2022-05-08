package model;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    private Comparator<Person> makeCodeComparator() {

        return new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getCode(), o2.getCode());
            }
        };
    }

    private AVL<Person> setUpScenario1() {

        AVL<Person> personBinaryTree = new AVL<>(makeCodeComparator());

        Person p1 = new Person("Gabriel", "Kremer", Gender.MALE,
                "2002-08-02", 181, "Colombian");
        personBinaryTree.insert(p1);

        Person p2 = new Person("Sebastian", "Zapata", Gender.MALE,
                "2001-08-20", 183, "Colombian");
        personBinaryTree.insert(p2);

        return personBinaryTree;
    }

    @Test
    void isBalanced() {

        AVL<Person> binaryTree = setUpScenario1();
        assertTrue(binaryTree.isTreeBalanced());

        Person p3 = new Person("Sebastian", "Medina", Gender.MALE,
                "2002-09-25", 185, "Colombian");

        binaryTree.insert(p3);
        assertTrue(binaryTree.isTreeBalanced());

        System.out.println("\n-Balance factor: " + binaryTree.getRoot().findBalanceFactor());

//        System.out.println("\n" + binaryTree);
//        System.out.println("\nBalanced?: " + binaryTree.getRoot().isBalanced());
    }

    @Test
    void findBalanceFactor() {

        AVL<Person> binaryTree = setUpScenario1();
        assertEquals(1, Math.abs(binaryTree.getRoot().findBalanceFactor()));

//        System.out.println("\nDepth: " + binaryTree.getRoot().balanceFactor());
    }

    @Test
    void compareTo() {
    }
}