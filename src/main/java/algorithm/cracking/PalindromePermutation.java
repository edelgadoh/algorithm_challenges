package algorithm.cracking;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    /*
    method should not consider space and be case-insensitive
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
