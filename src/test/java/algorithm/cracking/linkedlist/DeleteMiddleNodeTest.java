package algorithm.cracking.linkedlist;

import algorithm.cracking.linkedlist.DeleteMiddleNode.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DeleteMiddleNodeTest {

    private DeleteMiddleNode deleteMiddleNode = new DeleteMiddleNode();

    @Test
    void testDeleteMiddleNode() {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        // Deleting middle node (node3)
        deleteMiddleNode.deleteNode(node3);

        // Expected list: 1 -> 2 -> 4 -> 5
        assertEquals(1, node1.getValue());
        assertEquals(2, node1.getNext().getValue());
        assertEquals(4, node1.getNext().getNext().getValue());
        assertEquals(5, node1.getNext().getNext().getNext().getValue());
        assertNull(node1.getNext().getNext().getNext().getNext());
    }

    @Test
    void testDeleteMiddleNodeAtEnd() {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);

        node1.setNext(node2);
        node2.setNext(node3);

        deleteMiddleNode.deleteNode(node3);

        // Expected list remains: 1 -> 2 -> MIN_VALUE
        assertEquals(1, node1.getValue());
        assertEquals(2, node1.getNext().getValue());
        assertEquals(Integer.MIN_VALUE, node1.getNext().getNext().getValue());
        assertNull(node1.getNext().getNext().getNext());
    }

    @Test
    void testDeleteMiddleNodeAtStart() {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);

        node1.setNext(node2);
        node2.setNext(node3);

        deleteMiddleNode.deleteNode(node1);

        // Expected list remains: 2 -> 3
        assertEquals(2, node1.getValue());
        assertEquals(3, node1.getNext().getValue());
        assertNull(node1.getNext().getNext());
    }

}