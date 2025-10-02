package algorithm.cracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Stack;

public class Chapter02Palindrome {
    public static void main(String[] args) {
        int[] array01 = {1, 2, 3, 5, 3, 2, 1};
        Node head01 = parseToNode(array01);
        int[] array02 = {1, 2, 3, 3, 2, 1};
        Node head02 = parseToNode(array02);
        int[] array03 = {1, 2, 3, 3, 1};
        Node head03 = parseToNode(array03);
        int[] array04 = {1};
        Node head04 = parseToNode(array04);
        int[] array05 = {};
        Node head05 = parseToNode(array05);

        System.out.println(isPalindrome(head01));
        System.out.println(isPalindrome(head02));
        System.out.println(isPalindrome(head03));
        System.out.println(isPalindrome(head04));
        System.out.println(isPalindrome(head05));

    }

    private static Node parseToNode(int[] array) {
        Node lastNode = null;
        for (int i = array.length - 1; i >= 0; i--) {
            Node node = new Node(array[i], lastNode);
            lastNode = node;
        }
        return lastNode;
    }

    private static boolean isPalindrome(Node node) {
        Node slow = node;
        Node fast = node;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.getNext() != null) {
            stack.push(slow.getData());
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        if (fast != null) {
            slow = slow.getNext();
        }

        while (slow != null) {
            Integer popped = stack.pop();
            if (!popped.equals(slow.getData())) {
                return false;
            }
            slow = slow.getNext();
        }
        return true;

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
