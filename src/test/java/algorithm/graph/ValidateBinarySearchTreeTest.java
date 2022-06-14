package algorithm.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidateBinarySearchTreeTest {

    @Test
    void validateBST_TestA() {
        BinaryTreeNode root = null;
        int[] values = {5, 7, 8, 3, 2, 90, 12, 15, 4, 95};
        for (int value : values) {
            root = TreeOperation.insert(root, value);
        }
        Assertions.assertTrue(ValidateBinarySearchTree.validate(root));
    }

    @Test
    void validateBST_TestB() {
        BinaryTreeNode leftRight = new BinaryTreeNode(11, null, null);
        BinaryTreeNode left = new BinaryTreeNode(5, null, leftRight);
        BinaryTreeNode right = new BinaryTreeNode(15, null, null);
        BinaryTreeNode root = new BinaryTreeNode(10, left, right);
        Assertions.assertFalse(ValidateBinarySearchTree.validate(root));
    }

    @Test
    void validateBST_TestC() {
        Assertions.assertTrue(ValidateBinarySearchTree.validate(null));
    }

    @Test
    void validateBST_TestD() {
        BinaryTreeNode root = new BinaryTreeNode(10, null, null);
        Assertions.assertTrue(ValidateBinarySearchTree.validate(root));
    }


}