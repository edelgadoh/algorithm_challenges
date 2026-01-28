package algorithm.cracking.linkedlist;

import java.util.Stack;

/**
 * Implement a function to check if a linked list is a palindrome.
 */
public class CheckPalindrome {

    public boolean isPalindrome(Node node) {
        var slow = node;
        var fast = node;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next() != null) {
            stack.push(slow.data());
            slow = slow.next();
            fast = fast.next().next();
        }

        // odd number of elements, skip the middle element
        // a -> b -> c -> b -> a
        // s    s    s
        // f         f         f
        if (fast != null) {
            slow = slow.next();
        }

        while (slow != null) {
            var topValue = stack.pop();
            if (!topValue.equals(slow.data())) {
                return false;
            }
            slow = slow.next();
        }
        return true;

    }

    record Node(int data, Node next) {
    }
}
