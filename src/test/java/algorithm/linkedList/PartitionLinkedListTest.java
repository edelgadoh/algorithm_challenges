package algorithm.linkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PartitionLinkedListTest {

    @Test
    void makePartitionCaseA() {
        int partitionNumber = 5;
        int[] values = {3, 5, 8, 5, 10, 2, 1};
        int[] expectedValues = {3, 2, 1, 5, 8, 5, 10};
        Node node = LinkedListUtil.build(values);

        Node resultNode = PartitionLinkedList.makePartition(node, partitionNumber);

        assertResult(expectedValues, resultNode);

    }

    @Test
    void makePartitionCaseB() {
        int partitionNumber = 0;
        int[] values = {9, 8, 7, 1, 2, 3, 4};
        int[] expectedValues = {9, 8, 7, 1, 2, 3, 4};
        Node node = LinkedListUtil.build(values);

        Node resultNode = PartitionLinkedList.makePartition(node, partitionNumber);

        assertResult(expectedValues, resultNode);

    }

    @Test
    void makePartitionCaseC() {
        int partitionNumber = 6;
        int[] values = {9, 8, 7, 1, 2, 3, 4};
        int[] expectedValues = {1, 2, 3, 4, 9, 8, 7};
        Node node = LinkedListUtil.build(values);

        Node resultNode = PartitionLinkedList.makePartition(node, partitionNumber);

        assertResult(expectedValues, resultNode);

    }

    @Test
    void makePartitionCaseD() {
        int partitionNumber = 6;
        int[] values = {9};
        int[] expectedValues = {9};
        Node node = LinkedListUtil.build(values);

        Node resultNode = PartitionLinkedList.makePartition(node, partitionNumber);

        assertResult(expectedValues, resultNode);

    }

    @Test
    void makePartitionCaseE() {
        Node resultNode = PartitionLinkedList.makePartition(null, 1);
        Assertions.assertNull(resultNode);

    }

    private void assertResult(int[] expectedValues, Node resultNode) {
        int i = 0;
        while (resultNode != null) {
            Assertions.assertEquals(expectedValues[i], resultNode.value);
            resultNode = resultNode.next;
            i++;
        }
    }
}