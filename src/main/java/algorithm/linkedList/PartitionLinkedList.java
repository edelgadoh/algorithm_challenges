package algorithm.linkedList;

public class PartitionLinkedList {

    private PartitionLinkedList() {
    }

    static Node makePartition(Node node, int partitionValue) {
        Node leftPartHead = null;
        Node leftPartTail = null;
        Node rightPartHead = null;
        Node rightPartTail = null;

        while (node != null) {
            Node next = node.next;
            node.next = null;

            if (node.value < partitionValue) {
                if (leftPartHead == null) {
                    leftPartHead = node;
                    leftPartTail = node;
                } else {
                    leftPartTail.next = node;
                    leftPartTail = node;
                }
            } else {
                if (rightPartHead == null) {
                    rightPartHead = node;
                    rightPartTail = node;
                } else {
                    rightPartTail.next = node;
                    rightPartTail = node;
                }
            }
            node = next;
        }

        if (leftPartHead == null) return rightPartHead;

        leftPartTail.next = rightPartHead;
        return leftPartHead;

    }

}
