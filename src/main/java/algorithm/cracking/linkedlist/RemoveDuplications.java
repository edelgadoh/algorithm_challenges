package algorithm.cracking.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Write code to remove duplicates from an unsorted linked list.
 */
public class RemoveDuplications {

    public Node removeDuplicates(Node node) {
        Node currentNode = node;
        while (currentNode != null) {
            currentNode = removeDuplicateSingleNode(currentNode);
            currentNode = currentNode.getNext();
        }
        return node;
    }

    private static Node removeDuplicateSingleNode(Node node) {
        Node currentNode = node;
        int currentData = currentNode.getData();
        while (currentNode != null && currentNode.getNext() != null) {
            Node next = currentNode.getNext();
            if (currentData == next.getData()) {
                currentNode.setNext(next.getNext());
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return node;
    }

    @Data
    @AllArgsConstructor
    static class Node {
        private int data;
        private Node next;
    }

}


