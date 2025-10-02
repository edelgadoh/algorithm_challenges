package algorithm.cracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Chapter02RemoveDuplications {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 2, 2, 2, 1, 7, 6, 3, 2, 1};
        Node lastNode = null;
        for (int i = array.length - 1; i >= 0; i--) {
            Node node = new Node(array[i], lastNode);
            lastNode = node;
        }
        Node head = lastNode;
        printNodes(head);
        Node nodeWithoutDuplicates = removeAllDuplicates(head);
        printNodes(nodeWithoutDuplicates);

    }

    private static void printNodes(Node node) {
        while(node != null){
            System.out.print(node.getData() + " -> ");
            node = node.getNext();
        }
        System.out.println(" null");
    }

    private static Node removeAllDuplicates(Node node) {
        Node currentNode = node;
        while (currentNode != null) {
            currentNode = removeDuplicates(currentNode);
            currentNode = currentNode.getNext();
        }
        return node;
    }

    private static Node removeDuplicates(Node node) {
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

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    static class Node {
        private int data;
        private Node next;
    }
}
