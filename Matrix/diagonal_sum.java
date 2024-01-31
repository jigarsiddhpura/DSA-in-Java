import java.util.*;

public class diagonal_sum {
    public static int diagSum (int[][] matrix){
        int sum = 0;
        int n = matrix.length;

        // T.C. = O(n^2)
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(i==j) {
                    // PD - PRIMARY DIAGONAL
                    sum += matrix[i][j];
                } else if (i+j == n-1) {
                    // SD - SECONDARY DIAGONAL
                    sum += matrix[i][j];
                }
            }
        }

        sum = 0;

        // T.C. = O(n) ⭐⭐
        for(int i = 0; i < n; i++) {
            // PD
            sum += matrix[i][i];
            // SD
            if (i != n-1-i) {       // to not include the middle most element AGAIN in case on n being ODD
                sum += matrix[i][n-1-i];
            }
        }
        return sum;
    }
    public static void main(String args[]) {
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int sum = diagSum(matrix);
        System.out.println(sum);
    }
}