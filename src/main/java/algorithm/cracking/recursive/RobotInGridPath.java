package algorithm.cracking.recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits" such that
 * the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
 * the bottom right.
 */
public class RobotInGridPath {
    record Point(int row, int column) {
    }

    public List<Point> findPaths(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new ArrayList<>();
        }
        List<Point> singlePath = new ArrayList<>();
        Set<Point> failedPoints = new HashSet<>();
        findPaths(grid.length - 1, grid[0].length - 1, grid, singlePath, failedPoints);
        return singlePath;
    }

    private boolean findPaths(int row, int column, int[][] grid, List<Point> path, Set<Point> failedPoints) {
        if (row < 0 || column < 0 || grid[row][column] == 1) {
            return false;
        }
        var point = new Point(row, column);
        if (failedPoints.contains(point)) {
            return false;
        }
        boolean isOrigin = row == 0 && column == 0;
        if (isOrigin || findPaths(row - 1, column, grid, path, failedPoints) || findPaths(row, column - 1, grid, path, failedPoints)) {
            path.add(point);
            return true;
        }
        failedPoints.add(point);
        return false;
    }
}