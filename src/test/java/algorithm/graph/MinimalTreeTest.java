package algorithm.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimalTreeTest {

    @Test
    void buildMinimalSearchTreeTestA() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //          5
        //    2             8
        // 1    3       6       9
        //        4      7        10
        BinaryTreeNode node = MinimalTree.buildMinimalSearchTree(array);
        Assertions.assertEquals("5 2 1 3 4 8 6 7 9 10", TreeOperation.preOrder(node));
    }

    @Test
    void buildMinimalSearchTreeTestB() {
        int[] array = {11, 100, 1000};
        BinaryTreeNode node = MinimalTree.buildMinimalSearchTree(array);
        Assertions.assertEquals("100 11 1000", TreeOperation.preOrder(node));
    }

    @Test
    void buildMinimalSearchTreeTestC() {
        int[] array = {500};
        BinaryTreeNode node = MinimalTree.buildMinimalSearchTree(array);
        Assertions.assertEquals("500", TreeOperation.preOrder(node));
    }

    @Test
    void buildMinimalSearchTreeTestD() {
        int[] array = {};
        BinaryTreeNode node = MinimalTree.buildMinimalSearchTree(array);
        Assertions.assertNull(node);
    }

    @Test
    void buildMinimalSearchTreeTestE() {
        Assertions.assertNull(MinimalTree.buildMinimalSearchTree(null));
    }

}