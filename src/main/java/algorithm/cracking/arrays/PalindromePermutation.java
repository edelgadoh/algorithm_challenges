package algorithm.cracking.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Palindrome Permutation:
 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
 * permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * EXAMPLE
 * Input:Tact Coa
 * Output:True (permutations: "taco cat'; "atc o eta·; etc.)
 */
public class PalindromePermutation {

    /*
    The method should disconsider space and be case-insensitive
     */
    public boolean isPossibleToBuildAPalindrome(String input) {
        if (input == null) return false;

        Map<Character, Integer> histogram = new HashMap<>();
        input.toLowerCase().chars().forEach(c -> {
            Character character = (char) c;
            if (character != ' ') {
                histogram.merge(character, 1, Integer::sum);
            }
        });

        var onlyOneOdd = false;
        for (var value : histogram.values()) {
            if (value == 1) {
                if (onlyOneOdd) return false;
                onlyOneOdd = true;
            } else if (value % 2 == 1) return false;
        }
        return true;
    }
}
