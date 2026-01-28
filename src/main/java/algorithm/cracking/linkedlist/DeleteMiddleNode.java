package algorithm.cracking.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node,
 * not necessarily the exact middle) of a singly linked list, given only access to that node.
 */
public class DeleteMiddleNode {

    public void deleteNode(Node node) {
        if (node != null) {
            if (node.next != null) {
                node.setValue(node.getNext().getValue());
                node.setNext(node.getNext().getNext());
            } else {
                node.setValue(Integer.MIN_VALUE);//dummy value
            }

        }
    }

    @Data
    @AllArgsConstructor
    static class Node {
        private int value;
        private Node next;
    }

}
