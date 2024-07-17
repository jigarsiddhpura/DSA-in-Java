import java.util.*;

public class TargetSumSubset {
    public static boolean targetSumSubset(int[] numbers, int target) {
        int n = numbers.length;
        boolean[][] dp = new boolean[n+1][target+1];

        // i = total item considered from start, j = target sum
        for(int i = 0; i < n+1; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < target+1; j++) {
                int val = numbers[i-1];
                // valid + include 
                if (val <= j && dp[i-1][j-val] == true) {
                    dp[i][j] = true;
                } 
                // exclude
                else if (dp[i-1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }

        printMatrix(dp, n+1, target+1);

        return dp[n][target];
    }
    public static void main(String args[]) {
        int[] numbers = {4,2,7,1,3};
        int target = 10;
        System.out.println(targetSumSubset(numbers, target));
    }
    public static void printMatrix(boolean[][] mat, int i, int j) {
        for(int k = 0; k < i; k++) {
            for(int l = 0; l < j; l++) {
                System.out.print(mat[k][l] + " ");
            }
            System.out.println();
        }
    } 
}