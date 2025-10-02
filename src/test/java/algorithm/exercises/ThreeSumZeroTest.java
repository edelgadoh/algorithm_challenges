package algorithm.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ThreeSumZeroTest {

    @Test
    void testA() {
        ThreeSumZero threeSumZero = new ThreeSumZero();

        int[] arr = {3, 5, 8, 10, -9, -11, 16, 2};
        List<List<Integer>> result = threeSumZero.threeSum(arr);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(List.of(-11, 3, 8), result.get(0));
    }

    @Test
    void testB() {
        ThreeSumZero threeSumZero = new ThreeSumZero();

        int[] arr = {0, 0, 0};
        List<List<Integer>> result = threeSumZero.threeSum(arr);
        Assertions.assertEquals(List.of(0, 0, 0), result.get(0));
    }

    @Test
    void testC() {
        ThreeSumZero threeSumZero = new ThreeSumZero();

        int[] arr = {5, -5};
        List<List<Integer>> result = threeSumZero.threeSum(arr);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void testD() {
        ThreeSumZero threeSumZero = new ThreeSumZero();

        int[] arr = {4, -5, 2};
        List<List<Integer>> result = threeSumZero.threeSum(arr);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void testE() {
        ThreeSumZero threeSumZero = new ThreeSumZero();

        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSumZero.threeSum(arr);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)), result);

    }

}