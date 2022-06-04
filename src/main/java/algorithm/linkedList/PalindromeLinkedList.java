package algorithm.linkedList;

import java.util.Stack;

public class PalindromeLinkedList {

    static boolean isPalindrome(Node node) {
        if (node == null) return false;
        if (node.next == null) return true;

        Stack<Node> stack = new Stack<>();
        Node fastNode = node;
        while (fastNode != null && fastNode.next != null) {
            stack.add(node);
            node = node.next;
            fastNode = fastNode.next.next;
        }
        if (fastNode != null) {
            node = node.next;
        }

        while (node != null) {
            Node topNode = stack.pop();
            if (topNode.value != node.value) return false;
            node = node.next;
        }

        return true;

    }
}
