package algorithm.cracking.recursive;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerSetTest {

    @Test
    void findAllSubsets() {
        PowerSet powerSet = new PowerSet();
        var subsets = powerSet.allSubsets(List.of(1, 2, 3));
        assertEquals(8, subsets.size());
    }

    @Test
    void findAllSubsetsWithBiggerSet() {
        PowerSet powerSet = new PowerSet();
        var subsets = powerSet.allSubsets(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        assertEquals(256, subsets.size());
    }

    @Test
    void testWithEmptySet() {
        PowerSet powerSet = new PowerSet();
        var subsets = powerSet.allSubsets(List.of());
        assertEquals(1, subsets.size());
    }

    @Test
    void testWithNullSet() {
        PowerSet powerSet = new PowerSet();
        var subsets = powerSet.allSubsets(null);
        assertEquals(1, subsets.size());
    }

}