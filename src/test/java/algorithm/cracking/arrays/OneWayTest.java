package algorithm.cracking.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneWayTest {

    private OneWay oneWay = new OneWay();

    @Test
    void oneWayTest() {
        assertEquals(true, oneWay.checkOneWay("pale", "ple"));
        assertEquals(true, oneWay.checkOneWay("pales", "pale"));
        assertEquals(true, oneWay.checkOneWay("pale", "bale"));
        assertEquals(false, oneWay.checkOneWay("pale", "bae"));
        assertEquals(true, oneWay.checkOneWay("Edwin", "edwin"));
    }

    @Test
    void oneWayNullTest() {
        assertEquals(false, oneWay.checkOneWay(null, "ple"));
    }

    @Test
    void oneWayTwoEmptyTest() {
        assertEquals(true, oneWay.checkOneWay("", ""));
    }

}