package algorithm.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AllSubSetsTest {

    @Test
    void testA() {
        int[] elements = {1, 2, 3};
        //a,b,c
        //0 0 0
        //0 0 1
        //0 1 0
        //0 1 1
        //1 0 0
        //1 0 1
        //1 1 0
        //1 1 1
        AllSubSets allSubSets = new AllSubSets();
        List<List<Integer>> subsets = allSubSets.subsets(elements);

        Assertions.assertEquals(8, subsets.size());

    }

}