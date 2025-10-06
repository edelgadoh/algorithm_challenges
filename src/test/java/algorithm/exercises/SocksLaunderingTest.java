package algorithm.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SocksLaunderingTest {

    private SocksLaundering socksLaundering = new SocksLaundering();

    @Test
    void testBasicSolution() {
        var C = new int[]{1, 2, 1, 1};
        var D = new int[]{1, 4, 3, 2, 4};
        var K = 2;
        int solution = socksLaundering.solution(K, C, D);
        assertEquals(3, solution);
    }

    @Test
    void testSolutionNoWashing() {
        var C = new int[]{1, 2, 1, 1};
        var D = new int[]{1, 4, 3, 2, 4};
        var K = 0;
        int solution = socksLaundering.solution(K, C, D);
        assertEquals(1, solution);
    }

    @Test
    void testSolutionWithOnlyOneAvailableDirty() {
        var C = new int[]{};
        var D = new int[]{1, 4, 1, 2, 4};
        var K = 2;
        int solution = socksLaundering.solution(K, C, D);
        assertEquals(1, solution);
    }

    @Test
    void testSolutionWithOnlyTwoAvailableDirty() {
        var C = new int[]{};
        var D = new int[]{1, 4, 1, 2, 4, 7, 7};
        var K = 4;
        int solution = socksLaundering.solution(K, C, D);
        assertEquals(2, solution);
    }

    @Test
    void testSolutionWithOnlyClean() {
        var C = new int[]{1, 2, 3, 1, 2, 3, 3, 3};
        var D = new int[]{};
        var K = 10;
        int solution = socksLaundering.solution(K, C, D);
        assertEquals(4, solution);
    }

}