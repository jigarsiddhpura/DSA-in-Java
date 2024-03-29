import java.util.*;

public class Sudoku {

    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        // Vertical check
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == digit) return false;
        }

        // Horizontal check
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit) return false;
        }

        // 3x3 grid check
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) return false;
            }
        }

        return true;
    }


    public static boolean solveSudoku(int[][] sudoku, int row, int col) {
        // Base case: If we have reached the last row, return true
        if (row == 9) return true;

        // If we have reached the last column in the current row, move to the next row
        if (col == 9) {
            return solveSudoku(sudoku, row + 1, 0);
        }

        // Skip cells that are already filled
        if (sudoku[row][col] != 0) {
            return solveSudoku(sudoku, row, col + 1);
        }

        // Recursively try each digit from 1 to 9
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (solveSudoku(sudoku, row, col + 1)) {
                    return true;
                }
                sudoku[row][col] = 0; // Backtrack
            }
        }

        // If no digit leads to a solution, backtrack
        return false;
    }

    public static void main(String args[]) {
        int[][] sudoku = {
                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                {4, 9, 0, 1, 5, 7, 0, 0, 2},
                {0, 0, 3, 0, 0, 4, 1, 9, 0},
                {1, 8, 5, 0, 6, 0, 0, 2, 0},
                {0, 0, 0, 0, 2, 0, 0, 6, 0},
                {9, 6, 0, 4, 0, 5, 3, 0, 0},
                {0, 3, 0, 0, 7, 2, 0, 0, 4},
                {0, 4, 9, 0, 3, 0, 0, 5, 7},
                {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };
        boolean isSolved = solveSudoku(sudoku, 0, 0);
        System.out.println("Is sudoku solvable ? - " + isSolved);
    }
}
