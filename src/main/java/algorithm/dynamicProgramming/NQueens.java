package algorithm.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static List<List<Integer>> getQueens(int n){
        List<List<Integer>> result = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void solveNQueens(int n, int row, ArrayList<Integer> colPlacements, List<List<Integer>> result) {
        if(row == n){
            result.add(new ArrayList<>(colPlacements));
        } else {
            for(int col=0; col<n; col++){
                colPlacements.add(col);
                if(isValid(colPlacements)){
                    solveNQueens(n, row+1, colPlacements, result);
                }
                colPlacements.remove(colPlacements.size()-1);
            }

        }
    }

    private static boolean isValid(ArrayList<Integer> colPlacements) {
        int rowId = colPlacements.size()-1;
        for(int i=0; i< rowId; i++){
            int diff= Math.abs(colPlacements.get(i) - colPlacements.get(rowId));
            if(diff == 0 || diff == rowId-i){
                return false;
            }
        }
        return true;
    }
}
