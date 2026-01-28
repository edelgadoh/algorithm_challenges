package algorithm.cracking.linkedlist;

import algorithm.cracking.linkedlist.CheckPalindrome.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckPalindromeTest {

    private final CheckPalindrome checkPalindrome = new CheckPalindrome();

    @Test
    void testIsPalindrome() {
        int[] array01 = {1, 2, 3, 5, 3, 2, 1};
        var head01 = parseToNode(array01);
        int[] array02 = {1, 2, 3, 3, 2, 1};
        var head02 = parseToNode(array02);
        int[] array03 = {1, 2, 3, 3, 1};
        var head03 = parseToNode(array03);
        int[] array04 = {1};
        var head04 = parseToNode(array04);
        int[] array05 = {};
        var head05 = parseToNode(array05);

        assertTrue(checkPalindrome.isPalindrome(head01));
        assertTrue(checkPalindrome.isPalindrome(head02));
        assertFalse(checkPalindrome.isPalindrome(head03));
        assertTrue(checkPalindrome.isPalindrome(head04));
        assertTrue(checkPalindrome.isPalindrome(head05));

    }

    private Node parseToNode(int[] array) {
        Node lastNode = null;
        for (int i = array.length - 1; i >= 0; i--) {
            var node = new Node(array[i], lastNode);
            lastNode = node;
        }
        return lastNode;
    }

}