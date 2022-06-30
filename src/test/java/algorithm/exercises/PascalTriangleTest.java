package algorithm.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PascalTriangleTest {

    @Test
    void pascalTriangleGenerateTest() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1));
        expected.add(List.of(1, 1));
        expected.add(List.of(1, 2, 1));
        expected.add(List.of(1, 3, 3, 1));
        expected.add(List.of(1, 4, 6, 4, 1));

        List<List<Integer>> result = PascalTriangle.generate(5);

        Assertions.assertEquals(expected, result);

    }
}