package algorithm.linkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoopDetectionLinkedListTest {

    @Test
    void loopDetectionTestA() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        Node startLoopNode = LoopDetectionLinkedList.loopStartNode(node1);

        Assertions.assertEquals(node3, startLoopNode);

    }

    @Test
    void loopDetectionTestB() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        Node startLoopNode = LoopDetectionLinkedList.loopStartNode(node1);

        Assertions.assertEquals(node1, startLoopNode);

    }

    @Test
    void loopDetectionTestC() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        Node startLoopNode = LoopDetectionLinkedList.loopStartNode(node1);

        Assertions.assertNull(startLoopNode);

    }
}