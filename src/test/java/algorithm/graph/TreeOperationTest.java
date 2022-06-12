package algorithm.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeOperationTest {

    BinaryTreeNode root;

    @BeforeEach
    void init() {
        int[] values = {5, 7, 8, 3, 2, 90, 12, 15, 4, 95};
        for (int value : values) {
            root = TreeOperation.insert(root, value);
        }
        //                 5
        //     3                   7
        // 2       4                     8
        //                                     90
        //                                12         95
        //                                   15
    }

    @Test
    void preOrder() {
        Assertions.assertEquals("5 3 2 4 7 8 90 12 15 95", TreeOperation.preOrder(root));
    }

    @Test
    void postOrder() {
        Assertions.assertEquals("2 4 3 15 12 95 90 8 7 5", TreeOperation.postOrder(root));
    }

    @Test
    void inOrder() {
        Assertions.assertEquals("2 3 4 5 7 8 12 15 90 95", TreeOperation.inOrder(root));
    }

    @Test
    void level() {
        Assertions.assertEquals(6, TreeOperation.level(root));
    }

    @Test
    void height() {
        Assertions.assertEquals(5, TreeOperation.height(root));
    }

    @Test
    void lowestCommonAncestor() {
        BinaryTreeNode node1 = TreeOperation.lowestCommonAncestor(root, 15, 95);
        Assertions.assertEquals(90, node1.data);

        BinaryTreeNode node2 = TreeOperation.lowestCommonAncestor(root, 4, 12);
        Assertions.assertEquals(5, node2.data);
    }

}