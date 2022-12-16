package algorithm.exercises;

public class PalindromeNextNumber {

    public String find(String input) {

        Integer minimumValue = Integer.parseInt(input);
        char[] charArray = input.toCharArray();
        if (isAllNineDigits(charArray)) {
            StringBuilder sb = new StringBuilder();
            sb.append("1");
            for (char c : charArray) {
                sb.append("0");
            }
            sb.append("1");
            return sb.toString();
        }
        int size = charArray.length;
        Integer[] numberArray = new Integer[size];
        for (int i = 0; i < charArray.length / 2; i++) {
            int digit = charArray[i] - '0'; //Character.getNumericValue(charArray[i]);
            numberArray[i] = digit;
            numberArray[size - 1 - i] = digit;
        }
        boolean odd = size % 2 != 0;
        if (odd) {
            numberArray[size / 2] = charArray[size / 2] - '0';
        }

        int middle = numberArray.length / 2;
        int index = odd ? middle : middle - 1;
        while (index >= 0 && parseToNumber(numberArray) <= minimumValue) {

            index = incrementNumber(numberArray, index);

        }
        return parseToNumber(numberArray).toString();

    }

    private boolean isAllNineDigits(char[] charArray) {
        for (char c : charArray) {
            if (c != '9') {
                return false;
            }
        }
        return true;
    }

    public Integer incrementNumber(Integer[] numberArray, Integer index) {

        while (index >= 0) {
            if (numberArray[index] < 9) {
                numberArray[index]++;
                if (index == numberArray.length / 2) {
                    return index;
                }
                numberArray[numberArray.length - 1 - index]++;
                return index;
            }
            index--;
        }
        return -1;
    }

    public Integer parseToNumber(Integer[] numberArray) {
        StringBuilder sb = new StringBuilder();
        for (Integer digit : numberArray) {
            sb.append(digit);
        }
        return Integer.parseInt(sb.toString());
    }


}
