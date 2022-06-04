package algorithm.linkedList;

import java.util.HashSet;
import java.util.Set;

public class LoopDetectionLinkedList {
    private LoopDetectionLinkedList() {
    }

    static Node loopStartNode(Node node) {
        Set<Node> visited = new HashSet<>();
        int i = 0;
        while (node != null &&
                !(visited.contains(node) && visited.contains(node.next)) && i < Integer.MAX_VALUE) {
            visited.add(node);
            node = node.next;
            i++;
        }
        return node;
    }
}
