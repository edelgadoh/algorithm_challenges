package algorithm.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RotateMatrixTest {

    @Test
    void rotateTestA() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        boolean rotate = RotateMatrix.rotate(matrix);
        Assertions.assertTrue(rotate);
        System.out.println(Arrays.deepToString(matrix));
    }

    @Test
    void rotateTestB() {
        int[][] matrix = {{1, 4}, {5, 8}, {15, 16}};
        boolean rotate = RotateMatrix.rotate(matrix);
        Assertions.assertFalse(rotate);
    }
}