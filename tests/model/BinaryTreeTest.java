package model;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private Comparator<Person> makeCodeComparator() {

        return new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getCode(), o2.getCode());
            }
        };
    }

    private BinaryTree<Person> setUpScenario1() {

        BinaryTree<Person> personBinaryTree = new BinaryTree<>(makeCodeComparator());

        Person p1 = new Person("Gabriel", "Kremer", Gender.MALE,
                "2002-08-02", 181, "Colombian");

        personBinaryTree.insert(p1);

        return personBinaryTree;
    }

    private BinaryTree<Person> setUpScenario2() {

        BinaryTree<Person> binaryTree = new BinaryTree<>(makeCodeComparator());

        Person p1 = new Person("Gabriel", "Kremer", Gender.MALE,
                "2002-08-02", 181, "Colombian");
        binaryTree.insert(p1);

        Person p2 = new Person("Sebastian", "Zapata", Gender.MALE,
                "2001-08-20", 183, "Colombian");
        binaryTree.insert(p2);

        Person p3 = new Person("Sebastian", "Medina", Gender.MALE,
                "2002-09-25", 185, "Colombian");
        binaryTree.insert(p3);

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


    public BinaryTree<Person> setUpScenario3() {

        BinaryTree<Person> binaryTree = new BinaryTree<>(makeCodeComparator());

        Person p1 = new Person();
        p1.setCode(4);
        binaryTree.insert(p1);

        Person p2 = new Person();
        p2.setCode(2);
        binaryTree.insert(p2);

        Person p3 = new Person();
        p3.setCode(10);
        binaryTree.insert(p3);

        Person p4 = new Person();
        p4.setCode(12);
        binaryTree.insert(p4);

        Person p5 = new Person();
        p5.setCode(7);
        binaryTree.insert(p5);

        Person p6 = new Person();
        p6.setCode(6);
        binaryTree.insert(p6);

        Person p7 = new Person();
        p7.setCode(8);
        binaryTree.insert(p7);

//        System.out.println("==TREE BEFORE: " + binaryTree);

//        binaryTree.balance(binaryTree.getRoot());

//        System.out.println("\n\n==TREE AFTER: " + binaryTree);

//        assertTrue(binaryTree.isTreeBalanced());

        return binaryTree;
    }

    @Test
    public void insert() {

        BinaryTree<Person> binaryTree = setUpScenario1();

        assertTrue(binaryTree.getRoot().isLeaf());

        Person p2 = new Person("Sebastian", "Zapata", Gender.MALE,
                "2001-08-20", 183, "Colombian");
        binaryTree.insert(p2);

        assertFalse(binaryTree.getRoot().isLeaf());

//        System.out.println("\n" + personBinaryTree);
    }

    @Test
    public void delete() {

        BinaryTree<Person> binaryTree = setUpScenario1();

        assertFalse(binaryTree.isEmpty());

        binaryTree.delete(new Person("Gabriel", "Kremer", Gender.MALE,
                "2002-08-02", 181, "Colombian"));

        assertTrue(binaryTree.isEmpty());
    }

    @Test
    public void balance() {

        BinaryTree<Person> binaryTree = setUpScenario1();
        System.out.println("\nASSERT 1");
        assertTrue(binaryTree.isTreeBalanced());

        Person p2 = new Person("Sebastian", "Zapata", Gender.MALE,
                "2001-08-20", 183, "Colombian");
        binaryTree.insert(p2);

        System.out.println("\nASSERT 2");
        assertTrue(binaryTree.isTreeBalanced());


        binaryTree = setUpScenario2();
        System.out.println("\nASSERT 3");
        assertTrue(binaryTree.isTreeBalanced());


        binaryTree = setUpScenario3();
        System.out.println("\nASSERT 4");
        assertTrue(binaryTree.isTreeBalanced());

//        assertFalse(binaryTree.isBalanced());

//        binaryTree.balance(binaryTree.getRoot());

//        System.out.println("\n\n-After balance: " + binaryTree);

//        assertTrue(binaryTree.isBalanced());
    }
}