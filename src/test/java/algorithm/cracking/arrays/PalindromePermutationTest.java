package algorithm.cracking.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePermutationTest {

    private final PalindromePermutation palindromePermutation = new PalindromePermutation();

    @Test
    void palindromePermutationTest() {
        var input01 = "Tact Coa";
        assertEquals(true, palindromePermutation.isPossibleToBuildAPalindrome(input01));

        var input02 = " E d win dniew Z";
        assertEquals(true, palindromePermutation.isPossibleToBuildAPalindrome(input02));

        var input03 = "a b c c";
        assertEquals(false, palindromePermutation.isPossibleToBuildAPalindrome(input03));

        var input04 = "aa aa cc aa";
        assertEquals(true, palindromePermutation.isPossibleToBuildAPalindrome(input04));
    }

    @Test
    void palindromePermutationEmptyTest() {
        var input = "";
        assertEquals(true, palindromePermutation.isPossibleToBuildAPalindrome(input));
    }

    @Test
    void palindromePermutationNullTest() {
        assertEquals(false, palindromePermutation.isPossibleToBuildAPalindrome(null));
    }
}