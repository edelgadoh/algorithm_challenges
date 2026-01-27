package algorithm.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotatedSortedArrayTest {

    @Test
    void searchTest() {
        RotatedSortedArray rsa = new RotatedSortedArray();
        assertEquals(4, rsa.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, rsa.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(0, rsa.search(new int[]{1}, 1));
        assertEquals(1, rsa.search(new int[]{6, 7, 0, 1, 2, 4, 5}, 7));
        assertEquals(0, rsa.search(new int[]{6, 7, 0, 1, 2, 4, 5}, 6));
        assertEquals(-1, rsa.search(new int[]{6, 7, 0, 1, 2, 4, 5}, 8));
        assertEquals(-1, rsa.search(null, 5));
    }

}