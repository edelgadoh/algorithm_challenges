package algorithm.cracking.arrays;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class RotateMatrix {

    protected static void rotate(byte[][] matrix) {
        if (matrix == null) return;
        var middle = (matrix.length - 1) / 2;
        var i = 0;
        while (i <= middle) {
            moveLayer(matrix, i, matrix.length - 1 - i);
            i++;
        }
    }

    private static void moveLayer(byte[][] matrix, int initial, int end) {
        if (initial > end) return;

        var temporalValues = new byte[end - initial + 1];
        var index = 0;
        var i = initial;
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
            matrix[end - index][initial] = temporalValues[index];//top to left
            i++;
            index++;
        }
    }
}
