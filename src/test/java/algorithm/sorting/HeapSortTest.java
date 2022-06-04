package algorithm.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HeapSortTest {

    private HeapSort heapSort;

    @BeforeEach
    public void init() {
        heapSort = new HeapSort();
    }

    @Test
    public void testA() {
        int[] actualArray = {5, 9, 33, 1, 0, -34, 56, 1, 2, 3};
        int[] expectedArray = actualArray.clone();
        Arrays.sort(expectedArray);

        heapSort.sort(actualArray);

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testB() {
        int[] actualArray = {5, 1, 6, 2, 3, 4};
        int[] expectedArray = actualArray.clone();
        Arrays.sort(expectedArray);

        heapSort.sort(actualArray);

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testC() {
        int[] actualArray = {-99, 0, 0, 99, 100000, 50000000, -30006};
        int[] expectedArray = actualArray.clone();
        Arrays.sort(expectedArray);

        heapSort.sort(actualArray);

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testD() {
        int[] actualArray = {};
        int[] expectedArray = actualArray.clone();
        Arrays.sort(expectedArray);

        heapSort.sort(actualArray);

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testE() {
        int[] actualArray = {1,2,3,4,5};
        int[] expectedArray = actualArray.clone();
        Arrays.sort(expectedArray);

        heapSort.sort(actualArray);

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testF() {
        int[] actualArray = {5,4,3,2,1};
        int[] expectedArray = actualArray.clone();
        Arrays.sort(expectedArray);

        heapSort.sort(actualArray);

        assertArrayEquals(expectedArray, actualArray);
    }

}