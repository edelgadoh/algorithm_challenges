package algorithm.linkedList;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(exclude = "next")
public class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
