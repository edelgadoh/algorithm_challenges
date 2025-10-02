package algorithm.exercises;

public class RobotGrid {

    public int findPaths(int[][] grid){
        return findRecursivePaths(grid, grid.length-1, grid[0].length-1);
    }

    private int findRecursivePaths(int[][] grid, int row, int column){
        if(row<0 || column < 0 || grid[row][column] == 1){
            return 0;
        }
        if(row == 0 && column == 0){
            return 1;
        }
        return findRecursivePaths(grid, row-1, column) + findRecursivePaths(grid, row, column-1);
    }

}
