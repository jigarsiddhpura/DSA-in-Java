import java.util.*;

public class NQueens {

    static int count = 0;

    public static boolean isSafe (char[][] board, int row, int col) {   
        // check vertically up
        for(int i = row-1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }
        
        // check left diag
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i-- , j--) {
            if (board[i][j] == 'Q') return false;
        }

        // check right diag
        for(int i = row-1, j = col+1; i >= 0 && j < board.length; i-- , j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    // 🛑 use below func to get all possible  solutions of n queens problem
    public static void nQueens (char[][] board, int row){
        // base
        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }
        
        // column loop
        for(int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row+1); // function call for (n-1) Queens
                board[row][j] = 'X';  // backtracking step
            }
        }
    }

    // 🛑 use below func to check if a soln exists and print only 1 soln

    // public static boolean nQueens (char[][] board, int row){
    //     // base
    //     if (row == board.length) {
    //         count++;
    //         return true;
    //     }
        
    //     // column loop
    //     for(int j = 0; j < board.length; j++) {
    //         if (isSafe(board, row, j)) {
    //             board[row][j] = 'Q';
    //             if  (nQueens(board, row + 1)) return true;
    //             board[row][j] = 'X';  // backtracking step
    //         }
    //     }

    //     return false;
    // }

    public static void printBoard (char[][] arr){
        System.out.println("------- Board -------");
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }    
    }

    public static void main(String args[]) {
        int n = 4;
        char board[][] =  new char[n][n];

        // initialization
        for (int i=0; i<n; i++){
            for(int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        if (nQueens(board, 0)) {
            System.out.println("solutionn is possible");
            printBoard(board);
        } else {
            System.out.println("soln is not possible");
        }

        System.out.println("Number of solutions: " + count);
    }
}