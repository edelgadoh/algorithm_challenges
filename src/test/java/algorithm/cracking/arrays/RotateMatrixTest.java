package algorithm.cracking.arrays;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RotateMatrixTest {

    @Test
    void testRotateMatrix() {
        byte[][] matrix = {
                {1, 0, 2, 0, 1, 1},
                {0, 1, 1, 0, 2, 1},
                {0, 0, 1, 0, 1, 3},
                {0, 0, 1, 0, 1, 1},
                {0, 4, 8, 0, 3, 1},
                {6, 0, 1, 5, 1, 7}
        };

        byte[][] expectedMatrix = {
                {1, 1, 3, 1, 1, 7},
                {1, 2, 1, 1, 3, 1},
                {0, 0, 0, 0, 0, 5},
                {2, 1, 1, 1, 8, 1},
                {0, 1, 0, 0, 4, 0},
                {1, 0, 0, 0, 0, 6}
        };

        //      (i,j)
        for (byte[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        RotateMatrix.rotate(matrix);
        for (byte[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        assertArrayEquals(expectedMatrix, matrix);
    }

    @Test
    void testRotateSmallMatrix() {
        byte[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        byte[][] expectedMatrix = {
                {3, 6, 9},
                {2, 5, 8},
                {1, 4, 7}
        };
        //      (i,j)
        for (byte[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        RotateMatrix.rotate(matrix);
        for (byte[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        assertArrayEquals(expectedMatrix, matrix);
    }

    @Test
    void testEmptyMatrix() {
        byte[][] matrix = {};
        byte[][] expectedMatrix = {};
        RotateMatrix.rotate(matrix);
        assertArrayEquals(expectedMatrix, matrix);
    }

    @Test
    void testNullMatrix() {
        byte[][] matrix = null;
        RotateMatrix.rotate(matrix);
        assertArrayEquals(null, matrix);
    }

}