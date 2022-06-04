package algorithm.linkedList;

public class LinkedListUtil {

    public static Node build(int[] values) {
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
