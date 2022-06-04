package algorithm.linkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeLinkedListTest {

    @Test
    void isPalindromeTestA() {

        int[] values = {9, 8, 7, 1, 7, 8, 9};
        Node node = LinkedListUtil.build(values);

        boolean response = PalindromeLinkedList.isPalindrome(node);

        Assertions.assertTrue(response);
    }

    @Test
    void isPalindromeTestB() {

        int[] values = {9, 8, 7, 7, 8, 9};
        Node node = LinkedListUtil.build(values);

        boolean response = PalindromeLinkedList.isPalindrome(node);

        Assertions.assertTrue(response);
    }

    @Test
    void isPalindromeTestC() {

        int[] values = {1};
        Node node = LinkedListUtil.build(values);

        boolean response = PalindromeLinkedList.isPalindrome(node);

        Assertions.assertTrue(response);
    }

    @Test
    void isPalindromeTestD() {

        int[] values = {};
        Node node = LinkedListUtil.build(values);

        boolean response = PalindromeLinkedList.isPalindrome(node);

        Assertions.assertFalse(response);
    }

    @Test
    void isPalindromeTestE() {

        int[] values = {4, 6, 7, 8, 1, 7, 6, 4};
        Node node = LinkedListUtil.build(values);

        boolean response = PalindromeLinkedList.isPalindrome(node);

        Assertions.assertFalse(response);
    }

}