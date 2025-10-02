package algorithm.cracking;

public class Chapter01OneWay {
    public static void main(String[] args) {
        System.out.println(Chapter01OneWay.checkOneWay("pale", "ple"));
        System.out.println(Chapter01OneWay.checkOneWay("pales", "pale"));
        System.out.println(Chapter01OneWay.checkOneWay("pale", "bale"));
        System.out.println(Chapter01OneWay.checkOneWay("pale", "bake"));
    }

    private static boolean checkOneWay(String stringOne, String stringTwo) {

        int i = 0, j = 0;
        while (i < stringOne.length() && j < stringTwo.length()) {
            int lengthOne = stringOne.substring(i).length();
            int lengthTwo = stringTwo.substring(j).length();
            if (stringOne.charAt(i) == stringTwo.charAt(j)) {
                i++;
                j++;
            } else {
                if (lengthOne < lengthTwo) {
                    j++;
                    if (stringOne.substring(i).equals(stringTwo.substring(j))) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (lengthOne > lengthTwo) {
                    i++;
                    if (stringOne.substring(i).equals(stringTwo.substring(j))) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    i++;
                    j++;
                    if (stringOne.substring(i).equals(stringTwo.substring(j))) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

        }

        return (stringOne.substring(i).length() == 1 ^ stringTwo.substring(j).length() == 1);
    }
}
