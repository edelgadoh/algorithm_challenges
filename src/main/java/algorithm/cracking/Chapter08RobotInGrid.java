package algorithm.cracking;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Chapter08RobotInGrid {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true, false, true},
                {true, false, true, true, true},
                {true, false, true, true, false},
                {true, true, true, true, true},
                {false, true, true, false, true},
                {true, false, true, true, true},
        };

        Chapter08RobotInGrid chapter08RobotInGrid = new Chapter08RobotInGrid();
        List<Point> path = chapter08RobotInGrid.findPath(maze);
        System.out.println(path);
    }

    private List<Point> findPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return null;
        }

        HashSet<Point> failedPoints = new HashSet<>();
        List<Point> path = new ArrayList<>();
        findPath(maze, maze.length - 1, maze[0].length - 1, failedPoints, path);
        return path;

    }

    private boolean findPath(boolean[][] maze, int row, int column, HashSet<Point> failedPoints, List<Point> path) {

        if (row < 0 || column < 0 || !maze[row][column]) {
            return false;
        }

        Point point = new Point(row, column);

        if (failedPoints.contains(point)) {
            return false;
        }

        boolean initialPoint = (row == 0 && column == 0) ? true : false;

        if (initialPoint || findPath(maze, row - 1, column, failedPoints, path) || findPath(maze, row, column - 1, failedPoints, path)) {
            path.add(point);
            return true;
        }

        failedPoints.add(point);
        return false;

    }

    @Data
    @AllArgsConstructor
    class Point {
        private int row;
        private int column;
    }
}
