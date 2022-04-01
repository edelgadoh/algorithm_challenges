package algorithm.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class ValidateNumberTest {

    @Test
    void validateNumberForManyCases() {

        Map<String, Boolean> mapTests = new HashMap<>();
        mapTests.put("2", true);
        mapTests.put("0089", true);
        mapTests.put("-0.1", true);
        mapTests.put("+3.14", true);
        mapTests.put("4.", true);
        mapTests.put("-.9", true);
        mapTests.put("2e10", true);
        mapTests.put("-90E3", true);
        mapTests.put("3e+7", true);
        mapTests.put("+6e-1", true);
        mapTests.put("53.5e93", true);
        mapTests.put("-123.456e789", true);

        mapTests.put("abc", false);
        mapTests.put("1a", false);
        mapTests.put("1e", false);
        mapTests.put("e3", false);
        mapTests.put("99e2.5", false);
        mapTests.put("--6", false);
        mapTests.put("-+3", false);
        mapTests.put("95a54e53", false);

        ValidateNumber validateNumber = new ValidateNumber();
        for (Map.Entry<String, Boolean> testCase : mapTests.entrySet()) {
            boolean result = validateNumber.isNumber(testCase.getKey());
            Assertions.assertEquals(testCase.getValue(), result);
        }

    }
}