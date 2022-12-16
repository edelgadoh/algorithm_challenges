package algorithm.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PalindromeNextNumberTest {

    @Test
    void findNextTest() {

        PalindromeNextNumber palindromeNextNumber = new PalindromeNextNumber();
        String nextNumber01 = palindromeNextNumber.find("234567");
        Assertions.assertEquals("235532", nextNumber01);

        String nextNumber02 = palindromeNextNumber.find("23456");
        Assertions.assertEquals("23532", nextNumber02);

        String nextNumber03 = palindromeNextNumber.find("99998");
        Assertions.assertEquals("99999", nextNumber03);

        String nextNumber04 = palindromeNextNumber.find("19991");
        Assertions.assertEquals("29992", nextNumber04);

        String nextNumber05 = palindromeNextNumber.find("8998");
        Assertions.assertEquals("9999", nextNumber05);

        String nextNumber06 = palindromeNextNumber.find("9999");
        Assertions.assertEquals("100001", nextNumber06);

        String nextNumber07 = palindromeNextNumber.find("264999");
        Assertions.assertEquals("265562", nextNumber07);

    }
}