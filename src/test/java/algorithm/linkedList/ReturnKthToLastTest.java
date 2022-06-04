package algorithm.linkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReturnKthToLastTest {

    @Test
    public void testA() {

        int[] values = {1, 5, 6, 8, 4, 5, 7, 0, 12, 5, 7};
        Node head = buildLinkedList(values);
        int k = 3;

        int result = ReturnKthToLast.getKthToLast(head, k);
        Assertions.assertEquals(12, result);
    }

    @Test
    public void testB() {

        int[] values = {12, 5, 7};
        Node head = buildLinkedList(values);
        int k = 1;

        int result = ReturnKthToLast.getKthToLast(head, k);
        Assertions.assertEquals(7, result);
    }

    @Test
    public void testC() {

        int[] values = {12, 5, 7};
        Node head = buildLinkedList(values);
        int k = 99;

        int result = ReturnKthToLast.getKthToLast(head, k);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void testD() {

        int[] values = {};
        Node head = buildLinkedList(values);
        int k = 1;

        int result = ReturnKthToLast.getKthToLast(head, k);
        Assertions.assertEquals(-1, result);
    }

    private Node buildLinkedList(int[] values) {
        Node head = null;
        Node tail = null;
        for (int value : values) {
            if (head == null) {
                head = new Node(value);
                tail = head;
            } else {
                Node n2 = new Node(value);
                tail.next = n2;
                tail = n2;
            }
        }
        return head;
    }
}