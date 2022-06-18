package algorithm.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckSubTreeTest {

    @Test
    void checkSubTree_TestA() {

        BinaryTreeNode node1 = null;
        int[] values2 = {10, 11, 50, 70, 6, 5, 80, 30, 20, 90, 12, 15, 40, 95};
        for (int value : values2) {
            node1 = TreeOperation.insert(node1, value);
        }
        BinaryTreeNode node2 = null;
        int[] values = {50, 70, 80, 30, 20, 90, 12, 15, 40, 95};
        for (int value : values) {
            node2 = TreeOperation.insert(node2, value);
        }
        boolean result = CheckSubTree.check(node1, node2);
        Assertions.assertTrue(result);

    }

    @Test
    void checkSubTree_TestB() {

        BinaryTreeNode node1 = null;
        int[] values2 = {10, 11, 50, 70, 6, 5, 81};
        for (int value : values2) {
            node1 = TreeOperation.insert(node1, value);
        }
        BinaryTreeNode node2 = null;
        int[] values = {50, 70, 80};
        for (int value : values) {
            node2 = TreeOperation.insert(node2, value);
        }
        boolean result = CheckSubTree.check(node1, node2);
        Assertions.assertFalse(result);

    }

    @Test
    void checkSubTree_TestC() {

        BinaryTreeNode node1 = null;
        int[] values2 = {10, 11, 50, 70, 6, 5, 81};
        for (int value : values2) {
            node1 = TreeOperation.insert(node1, value);
        }
        Assertions.assertTrue(CheckSubTree.check(node1, null));

    }
}