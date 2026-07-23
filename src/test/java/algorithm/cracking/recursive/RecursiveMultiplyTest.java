package algorithm.cracking.recursive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecursiveMultiplyTest {

    RecursiveMultiply recursiveMultiply = new RecursiveMultiply();

    @Test
    void differentMultiplyTest() {
        assertEquals(0, recursiveMultiply.multiply(0, 6));
        assertEquals(0, recursiveMultiply.multiply(6, 0));
        assertEquals(6, recursiveMultiply.multiply(1, 6));
        assertEquals(12, recursiveMultiply.multiply(2, 6));
        assertEquals(12, recursiveMultiply.multiply(6, 2));
        assertEquals(3000, recursiveMultiply.multiply(600, 5));
        assertEquals(8038995, recursiveMultiply.multiply(7999, 1005));
    }
    
}