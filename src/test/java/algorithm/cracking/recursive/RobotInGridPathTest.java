package algorithm.cracking.recursive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotInGridPathTest {

    @Test
    void findPath() {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 1, 0}
        };
        RobotInGridPath robotInGridPath = new RobotInGridPath();
        var path = robotInGridPath.findPaths(grid);
        assertEquals(5, path.size());

    }

    @Test
    void findPathWithOtherBlockers() {
        int[][] grid = {
                {0, 0, 1, 0},
                {1, 0, 0, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0}
        };
        RobotInGridPath robotInGridPath = new RobotInGridPath();
        var path = robotInGridPath.findPaths(grid);
        assertEquals(7, path.size());
    }

    @Test
    void testWithNullGrid() {
        RobotInGridPath robotInGridPath = new RobotInGridPath();
        var path = robotInGridPath.findPaths(null);
        assertEquals(0, path.size());
    }
}