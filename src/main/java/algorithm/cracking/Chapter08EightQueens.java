package algorithm.cracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Chapter08EightQueens {

    private final int GRID_SIZE = 8;

    public static void main(String[] args) {
        Chapter08EightQueens chapter08EightQueens = new Chapter08EightQueens();
        Integer[] columns = {0, 0, 0, 0, 0, 0, 0, 0};

        ArrayList<Integer[]> results = new ArrayList<>();
        chapter08EightQueens.placeQueens(0, columns, results);
        results.forEach(result -> System.out.println(Arrays.deepToString(result)));
        //1 0 0 0 0 0 0 0
        //0 0 0 0 1 0 0 0
        //0 0 0 0 0 0 0 1
        //0 0 0 0 0 1 0 0
        //0 0 1 0 0 0 0 0
        //0 0 0 0 0 0 1 0
        //0 1 0 0 0 0 0 0
        //0 0 0 1 0 0 0 0
    }

    void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if (row == GRID_SIZE) {
            results.add(columns.clone());
        } else {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (isValidPosition(columns, row, column)) {
                    columns[row] = column;
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    private boolean isValidPosition(Integer[] columns, int row, int column) {
        for (int row2 = 0; row2 < row; row2++) {
            int column2 = columns[row2];

            if (column == column2) {
                return false;
            }
            int columnDifference = Math.abs(column2 - column);
            int rowDifference = row - row2;
            if (columnDifference == rowDifference) {
                return false;
            }
        }
        return true;
    }

}
