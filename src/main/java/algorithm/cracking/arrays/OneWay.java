package algorithm.cracking.arrays;

/**
 * One Away:
 * There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bae -> false
 */
public class OneWay {

    public boolean checkOneWay(String stringOne, String stringTwo) {

        if (stringOne == null || stringTwo == null) return false;
        if (stringOne.equals(stringTwo)) return true;

        var i = 0;
        var j = 0;
        while (i < stringOne.length() && j < stringTwo.length()) {
            var lengthOne = stringOne.substring(i).length();
            var lengthTwo = stringTwo.substring(j).length();
            if (stringOne.charAt(i) == stringTwo.charAt(j)) {
                i++;
                j++;
            } else {
                if (lengthOne < lengthTwo) {
                    j++;
                    return stringOne.substring(i).equals(stringTwo.substring(j));
                } else if (lengthOne > lengthTwo) {
                    i++;
                    return stringOne.substring(i).equals(stringTwo.substring(j));
                } else {
                    i++;
                    j++;
                    return stringOne.substring(i).equals(stringTwo.substring(j));
                }
            }

        }

        return (stringOne.substring(i).length() == 1 ^ stringTwo.substring(j).length() == 1);
    }
}
