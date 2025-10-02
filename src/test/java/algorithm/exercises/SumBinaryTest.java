package algorithm.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SumBinaryTest {

    @ParameterizedTest
    @CsvSource({
            "101, 101, '[1, 0, 1, 0]'",
            "100110, 000110, '[1, 0, 1, 1, 0, 0]'",
            "100111, 100111, '[1, 0, 0, 1, 1, 1, 0]'",
            "100, 1111, '[1, 0, 0, 1, 1]'",
            "1001001, 1111, '[1, 0, 1, 1, 0, 0, 0]'"
    })
    void sumBinaryTest(String a, String b, String expectedSum) {
        String sum = SumBinary.sum(a, b);
        Assertions.assertEquals(expectedSum, sum);
    }

}
