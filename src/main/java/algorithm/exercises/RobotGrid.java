package algorithm.exercises;

import java.util.Arrays;

public class RobotGrid {

    public int findPaths(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] memoization = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            Arrays.fill(memoization[row], -1);
        }
        return findRecursivePaths(grid, grid.length - 1, grid[0].length - 1, memoization);
    }

    private int findRecursivePaths(int[][] grid, int row, int column, int[][] memoization) {
        if (row < 0 || column < 0) {
            return 0;
        }
        if (grid[row][column] == 1) {
            memoization[row][column] = 0;
            return 0;
        }
        if (memoization[row][column] != -1) {
            return memoization[row][column];
        }
        if (row == 0 && column == 0) {
            memoization[row][column] = 1;
            return 1;
        }
        int currentPaths = findRecursivePaths(grid, row - 1, column, memoization) + findRecursivePaths(grid, row, column - 1, memoization);
        memoization[row][column] = currentPaths;
        return currentPaths;
    }

}
