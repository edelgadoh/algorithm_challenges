package algorithm.cracking.recursive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TripleStepTest {

    private final TripleStep tripleStep = new TripleStep();

    @Test
    void climbStairsTest() {
        assertEquals(4, tripleStep.climbStairs(3));
        assertEquals(7, tripleStep.climbStairs(4));
        assertEquals(13, tripleStep.climbStairs(5));
        assertEquals(2082876103, tripleStep.climbStairs(36));// 37 causes an overflow due to int boundary!
    }

    @Test
    void climbEmptyOrOneStairTest() {
        assertEquals(0, tripleStep.climbStairs(0));
        assertEquals(1, tripleStep.climbStairs(1));
    }

}