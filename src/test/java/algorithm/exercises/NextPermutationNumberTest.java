package algorithm.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NextPermutationNumberTest {

    private NextPermutationNumber nextPermutationNumber = new NextPermutationNumber();

    @Test
    void nextPermutationCase1() {
        int[] input = {1, 5, 1, 3, 2};
        nextPermutationNumber.nextPermutation(input);
        assertArrayEquals(new int[]{1, 5, 2, 1, 3}, input);
    }

    @Test
    void nextPermutationCase2() {
        int[] input = {1, 2, 3};
        nextPermutationNumber.nextPermutation(input);
        assertArrayEquals(new int[]{1, 3, 2}, input);
    }

    @Test
    void nextPermutationCase3() {
        int[] input = {2, 1, 0};
        nextPermutationNumber.nextPermutation(input);
        assertArrayEquals(new int[]{0, 1, 2}, input);
    }

    @Test
    void nextPermutationCase4() {
        int[] input = {};
        nextPermutationNumber.nextPermutation(input);
        assertArrayEquals(new int[]{}, input);
    }

    @Test
    void nextPermutationCase5() {
        assertThrows(NullPointerException.class, () -> nextPermutationNumber.nextPermutation(null));
    }

}