package algorithm.cracking.linkedlist;

import algorithm.cracking.linkedlist.RemoveDuplications.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RemoveDuplicationsTest {

    private RemoveDuplications removeDuplications = new RemoveDuplications();

    @Test
    void testRemoveDuplicates() {
        int[] array = {1, 2, 3, 4, 5, 2, 2, 2, 1, 7, 6, 3, 2, 1};
        int[] expectedArray = {1, 2, 3, 4, 5, 7, 6};

        Node head = buildNodes(array);
        printNodes(head);
        Node nodeWithoutDuplicates = removeDuplications.removeDuplicates(head);
        printNodes(nodeWithoutDuplicates);
        int[] responseArray = buildArray(nodeWithoutDuplicates);

        assertArrayEquals(expectedArray, responseArray);
    }

    @Test
    void testRemoveDuplicatesWithSingleDigit() {
        int[] array = {2, 2, 2, 2};
        int[] expectedArray = {2};

        Node head = buildNodes(array);
        Node nodeWithoutDuplicates = removeDuplications.removeDuplicates(head);
        int[] responseArray = buildArray(nodeWithoutDuplicates);

        assertArrayEquals(expectedArray, responseArray);
    }

    @Test
    void testRemoveDuplicatesWithDistincts() {
        int[] array = {5, 6, 7};
        int[] expectedArray = {5, 6, 7};

        Node head = buildNodes(array);
        Node nodeWithoutDuplicates = removeDuplications.removeDuplicates(head);
        int[] responseArray = buildArray(nodeWithoutDuplicates);

        assertArrayEquals(expectedArray, responseArray);
    }

    @Test
    void testRemoveDuplicatesWithNull() {

        int[] expectedArray = {};

        Node nodeWithoutDuplicates = removeDuplications.removeDuplicates(null);
        int[] responseArray = buildArray(nodeWithoutDuplicates);

        assertArrayEquals(expectedArray, responseArray);
    }

    private Node buildNodes(int[] array) {
        if(array == null || array.length == 0){
            return null;
        }
        Node lastNode = null;
        for (int i = array.length - 1; i >= 0; i--) {
            Node node = new Node(array[i], lastNode);
            lastNode = node;
        }
        return lastNode;
    }

    private int[] buildArray(Node head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.getData());
            head = head.getNext();
        }
        int[] response = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            response[i] = list.get(i);
        }
        return response;
    }

    private void printNodes(Node node) {
        while (node != null) {
            System.out.print(node.getData() + " -> ");
            node = node.getNext();
        }
        System.out.println(" null");
    }


}