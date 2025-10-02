package algorithm.dynamicProgramming;

public class LevenshteinDistance {

    int getDistance(String textA, String textB) {

        int[][] matrix = new int[textA.length() + 1][textB.length() + 1];
        //column 0
        for (int i = 0; i <= textA.length(); i++) {
            matrix[i][0] = i;
        }
        //row 0
        for (int i = 0; i <= textB.length(); i++) {
            matrix[0][i] = i;
        }
        for (int i = 1; i <= textA.length(); i++) {
            for (int j = 1; j <= textB.length(); j++) {
                if (textA.charAt(i - 1) == textB.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    //delete / insert vs replace
                    int minValue = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
                    matrix[i][j] = minValue + 1;
                }
            }
        }

        System.out.print("     ");
        for (int j = 0; j < textB.length(); j++) {
            System.out.print(textB.charAt(j) + ", ");
        }
        System.out.println();
        for (int i = 0; i <= textA.length(); i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(textA.charAt(i-1) + " ");
            }
            for (int j = 0; j <= textB.length(); j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }

        return matrix[textA.length()][textB.length()];
    }

}
