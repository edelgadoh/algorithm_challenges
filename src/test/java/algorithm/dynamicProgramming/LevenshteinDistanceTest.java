package algorithm.dynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LevenshteinDistanceTest {

    @Test
    public void testDistance(){
       LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
        int distance = levenshteinDistance.getDistance("benyam", "ephrem");
        Assertions.assertEquals(5, distance);
    }

    @Test
    public void test2Distance(){
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
        int distance = levenshteinDistance.getDistance("edwin", "marisol");
        Assertions.assertEquals(6, distance);
    }

    @Test
    public void test3Distance(){
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
        int distance = levenshteinDistance.getDistance("university", "universidade");
        Assertions.assertEquals(4, distance);
    }
}
