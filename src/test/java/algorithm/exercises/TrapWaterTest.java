package algorithm.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrapWaterTest {

    @Test
    void trapWaterTest1() {

        // [0,1,0,2,1,0,1,3,2,1,2, 1]
        //                |
        //        |       | |   |
        //  _ | _ | | _ | | | | |  |
        //  0 1 2 3 4 5 6 7 8 9 10 11

        TrapWater trapWater = new TrapWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = trapWater.trap(height);
        Assertions.assertEquals(6, result);
    }

    @Test
    void trapWaterTest2() {

        // [3,1,0,2,1,0,1,3,3,1, 3]
        //  |             | |    |
        //  |     |       | |    |
        //  | | _ | | _ | | | |  |
        //  0 1 2 3 4 5 6 7 8 9 10

        TrapWater trapWater = new TrapWater();
        int[] height = {3, 1, 0, 2, 1, 0, 1, 3, 3, 1, 3};
        int result = trapWater.trap(height);
        Assertions.assertEquals(15, result);
    }

}