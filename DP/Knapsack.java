import java.util.*;

public class Knapsack {

    // simple recursion 
    public static int knapsack(int[] val, int[] wt, int W, int n) {
        // base case
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n-1] <= W) {
            // include
            int ans1 = val[n-1] + knapsack(val, wt, W - wt[n-1], n-1);
            // exclude
            int ans2 = knapsack(val, wt, W, n-1);

            return Math.max(ans1,ans2);
        } else {
            return knapsack(val, wt, W, n-1);
        }
    }

    public static int knapsackWithDp(int[] val, int[] wt, int W, int n, int[][] dp) {
        // base case
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[n-1][W] != -1) {
            return dp[n-1][W];
        }

        if (wt[n-1] <= W) {
            // include
            int ans1 = val[n-1] + knapsack(val, wt, W - wt[n-1], n-1);
            // exclude
            int ans2 = knapsack(val, wt, W, n-1);
            
            return dp[n-1][W] = Math.max(ans1, ans2);
        } else {
            return dp[n-1][W] = knapsack(val, wt, W, n-1);
        }
    }

    public static int knapsackTabulation(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n+1][W+1];

        for(int j = 0; j < W; j++) {
            dp[0][j] = 0;
        }
        for(int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < W+1; j++) {
                int v = val[i-1];
                int w = wt[i-1];
                if (w <= j) {
                    // include
                    int ans1 = v + dp[i-1][j-w];
                    // exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1,ans2);
                } else {
                    // exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        printMatrix(dp, n+1, W+1);

        return dp[n][W];
    }

    public static int unboundedKnapsack(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n+1][W+1];

        for(int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j < W; j++) {
            dp[0][j] = 0;
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < W+1; j++) {
                int v = val[i-1];
                int w = wt[i-1];

                // valid
                if (w <= j) {
                    // include
                    int ans1 = v + dp[i][j-w];
                    // exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                } else {
                    // invalid + exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        printMatrix(dp, n+1, W+1);

        return dp[n][W];

    }

    public static void main(String args[]) {
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};
        int W = 7;
        System.out.println(knapsack(val, wt, W, val.length));
        
        int[][] dp = new int [val.length][W+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        System.out.println(knapsackWithDp(val, wt, W, val.length, dp));
    
        System.out.println(knapsackTabulation(val, wt, W));

        System.out.println(unboundedKnapsack(val, wt, W));
    }

    public static void printMatrix(int[][] mat, int i, int j) {
        for(int k = 0; k < i; k++) {
            for(int l = 0; l < j; l++) {
                System.out.print(mat[k][l] + " ");
            }
            System.out.println();
        }
    } 
}