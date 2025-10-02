package algorithm.linkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReturnKthToLastTest {

    @Test
    void testA() {

        int[] values = {1, 5, 6, 8, 4, 5, 7, 0, 12, 5, 7};
        Node head = LinkedListUtil.build(values);
        int k = 3;

        int result = ReturnKthToLast.getKthToLast(head, k);
        Assertions.assertEquals(12, result);
    }

    @Test
    void testB() {

        int[] values = {12, 5, 7};
        Node head = LinkedListUtil.build(values);
        int k = 1;

        int result = ReturnKthToLast.getKthToLast(head, k);
        Assertions.assertEquals(7, result);
    }

    @Test
    void testC() {

        int[] values = {12, 5, 7};
        Node head = LinkedListUtil.build(values);
        int k = 99;

        int result = ReturnKthToLast.getKthToLast(head, k);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testD() {

        int[] values = {};
        Node head = LinkedListUtil.build(values);
        int k = 1;

        int result = ReturnKthToLast.getKthToLast(head, k);
        Assertions.assertEquals(-1, result);
    }

}