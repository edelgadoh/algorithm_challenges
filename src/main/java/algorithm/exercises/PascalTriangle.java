package algorithm.exercises;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> results = new ArrayList<>();
        generate(1, results, numRows);
        return results;

    }

    private static void generate(int i, List<List<Integer>> results, int numRows) {
        if (i > numRows) return;

        if (i == 1) {
            List<Integer> result = new ArrayList<>();
            result.add(1);
            results.add(result);
        } else {
            List<Integer> previousValues = results.get(i - 2);
            List<Integer> newValues = new ArrayList<>();
            for (int j = 0; j <= previousValues.size(); j++) {

                int leftValue = j - 1 < 0 ? 0 : previousValues.get(j - 1);
                int rightValue = j == previousValues.size() ? 0 : previousValues.get(j);
                newValues.add(leftValue + rightValue);
            }
            results.add(newValues);
        }

        generate(i + 1, results, numRows);
    }
}
