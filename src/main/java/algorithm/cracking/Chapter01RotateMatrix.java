package algorithm.cracking;

import java.util.Arrays;

public class Chapter01RotateMatrix {
    public static void main(String[] args) {
        byte[][] matrix = {
                {1, 0, 2, 0, 1, 1},
                {0, 1, 1, 0, 2, 1},
                {0, 0, 1, 0, 1, 3},
                {0, 0, 1, 0, 1, 1},
                {0, 4, 8, 0, 3, 1},
                {6, 0, 1, 5, 1, 7}
        };
        //      (i,j)
        for (byte[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        rotate(matrix);
        for (byte[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

    }

    private static void rotate(byte[][] matrix) {
        int middle = (matrix.length - 1) / 2;
        int i = 0;
        while (i <= middle) {
            //System.out.println(String.format("Iterating over %d and %d", i, matrix.length - 1 - i));
            moveLayer(matrix, i, matrix.length - 1 - i);
            i++;
            for (byte[] row : matrix) {
                //System.out.println(Arrays.toString(row));
            }
            //System.out.println();
        }
    }

    private static void moveLayer(byte[][] matrix, int initial, int end) {
        if (initial > end) return;

        byte[] temporalValues = new byte[end - initial + 1];
        int index = 0;
        int i = initial;
        while (i <= end) {
            temporalValues[index] = matrix[initial][i];//top (row, column)
            i++;
            index++;
        }

        i = initial;
        while (i <= end) {
            matrix[initial][i] = matrix[i][end];//right to top
            i++;
        }
        i = initial;
        index = 0;
        while (i <= end) {
            matrix[i][end] = matrix[end][end - index];//button to right
            i++;
            index++;
        }
        i = initial;
        index = 0;
        while (i <= end) {
            matrix[end][end - index] = matrix[end - index][initial];//left to button
            i++;
            index++;
        }
        i = initial;
        index = 0;
        while (i <= end) {
            matrix[end-index][initial] = temporalValues[index];//top to left
            i++;
            index++;
        }
    }
}
