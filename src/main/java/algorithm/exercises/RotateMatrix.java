package algorithm.exercises;

public class RotateMatrix {

    public static boolean rotate(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int size = matrix.length;

        for (int level = 0; level < size/2; level++) {
            int first = level;
            int last = size - 1 - level;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }

        }
        return true;

    }

}
