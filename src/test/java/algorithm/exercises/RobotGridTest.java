package algorithm.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RobotGridTest {

    @Test
    void findAllPaths() {
        int[][] grid = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        RobotGrid robotGrid = new RobotGrid();
        int paths = robotGrid.findPaths(grid);
        System.out.println(paths);
        Assertions.assertEquals(6, paths);
    }

    @Test
    void findAllPathsWithBlockers() {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        RobotGrid robotGrid = new RobotGrid();
        int paths = robotGrid.findPaths(grid);
        System.out.println(paths);
        Assertions.assertEquals(2, paths);
    }

    @Test
    void findAllPathsWithOtherBlockers() {
        int[][] grid = {
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 0, 0, 0}
        };
        RobotGrid robotGrid = new RobotGrid();
        int paths = robotGrid.findPaths(grid);
        System.out.println(paths);
        Assertions.assertEquals(4, paths);
    }
}