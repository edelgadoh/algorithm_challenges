package algorithm.dynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KnapsackBinaryTest {

    @Test
    public void testA() {
        KnapsackBinary knapsackBinary = new KnapsackBinary();
        int[] weightArray = {5, 3, 4, 2};
        int[] valueArray = {60, 50, 70, 30};
        int maxWeight = 5;
        int maxValueInKnapSack = knapsackBinary.maxValueInKnapSack(weightArray, valueArray, maxWeight);
        Assertions.assertEquals(80, maxValueInKnapSack);
    }

}