package algorithm.dynamicProgramming;

public class KnapsackBinary {

    int maxValueInKnapSack(int[] weightArray, int[] valueArray, int maxWeight) {

        int[][] maxValueMatrix = new int[weightArray.length + 1][maxWeight + 1];
        for (int i = 1; i <= weightArray.length; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                int indexWeight = i - 1;
                if (j - weightArray[indexWeight] < 0) {
                    maxValueMatrix[i][j] = maxValueMatrix[i - 1][j];
                } else {
                    int maxValue = Math.max(maxValueMatrix[i - 1][j], maxValueMatrix[i - 1][j - weightArray[indexWeight]] + valueArray[indexWeight]);
                    maxValueMatrix[i][j] = maxValue;
                }

            }

        }

        return maxValueMatrix[weightArray.length][maxWeight];
    }

}
