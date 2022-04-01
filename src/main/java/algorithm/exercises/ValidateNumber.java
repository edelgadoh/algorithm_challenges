package algorithm.exercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/valid-number/
 * <p>
 * A valid number can be split up into these components (in order):
 * <p>
 * 1. A decimal number or an integer.
 * 2. (Optional) An 'e' or 'E', followed by an integer.
 * <p>
 * A decimal number can be split up into these components (in order):
 * <p>
 * 1. (Optional) A sign character (either '+' or '-').
 * 2. One of the following formats:
 * 2.1 One or more digits, followed by a dot '.'.
 * 2.2 One or more digits, followed by a dot '.', followed by one or more digits.
 * 2.3 A dot '.', followed by one or more digits.
 * <p>
 * An integer can be split up into these components (in order):
 * <p>
 * 1. (Optional) A sign character (either '+' or '-').
 * 2. One or more digits.
 */

public class ValidateNumber {

    public boolean isNumber(String s) {

        String patternDecimal = "[\\+|\\-]?((\\.\\d+)|(\\d+\\.)|(\\d+\\.\\d+))";
        String patternInteger = "[\\+|\\-]?\\d+";

        Pattern pattern =
                Pattern.compile(String.format("^(%s|%s)([e|E]%s)?$", patternInteger, patternDecimal, patternInteger));
        Matcher matcher = pattern.matcher(s);

        return matcher.find();

    }
}
