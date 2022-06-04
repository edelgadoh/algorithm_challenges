package algorithm.exercises;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumBinary {
    private SumBinary() {
    }

    static String sum(String stringA, String stringB) {

        int maxLength = Math.max(stringA.length(), stringB.length());
        int[] result = new int[maxLength + 1];
        int indexA = stringA.length() - 1;
        int indexB = stringB.length() - 1;
        int sumIndex = maxLength + 1;

        int carrier = 0;

        while (indexA >= 0 || indexB >= 0) {
            int value1 = indexA >= 0 ? Character.getNumericValue(stringA.charAt(indexA)) : 0;
            int value2 = indexB >= 0 ? Character.getNumericValue(stringB.charAt(indexB)) : 0;

            int moduleValue = (value1 + value2 + carrier) % 2;
            result[sumIndex - 1] = moduleValue;

            carrier = value1 + value2 + carrier >= 2 ? 1 : 0;
            indexA--;
            indexB--;
            sumIndex--;
        }

        if (carrier == 1) {
            result[0] = 1;
            return Arrays.toString(result);
        } else {
            Integer[] subArray = IntStream.range(1, result.length).mapToObj(x -> result[x]).toArray(Integer[]::new);
            return Arrays.toString(subArray);
        }

    }
}
