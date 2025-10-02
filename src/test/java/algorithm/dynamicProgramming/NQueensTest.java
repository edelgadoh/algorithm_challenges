package algorithm.dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.List;

class NQueensTest {

    @Test
    public void testA() {
        List<List<Integer>> queens = NQueens.getQueens(5);
        System.out.println(queens);
    }

}