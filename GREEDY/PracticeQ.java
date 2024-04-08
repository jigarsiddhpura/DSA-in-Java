import java.util.*;

public class PracticeQ {
    public static void Maximum_Balance_String_Partitions(String st) {
        // Time taken = 10 mins
        int n = st.length();
        int l = 0, r = 0, count = 0;

        for (int i = 0; i < n; i++) {
            if (st.charAt(i) == 'L') l++;
            else if (st.charAt(i) == 'R') r++;

            if (l == r) {
                count++;
            }
        }

        System.out.println("Number of partitions: " + count);
    }

    public static void K_Larget_Odd_Num(int[] arr, int k) {
        // T.C = O(1)
        // Time taken = 14 mins
        int L = arr[0], R = arr[1], ans = 0;

        if ((R & 1) > 0) { // R is odd
            ans = R - 2*k + 2;
        } else {
            ans = R - 2*k + 1;
        }

        if (ans < L) ans = 0;

        System.out.println("Kth Largest Odd Number: " + ans);

    }

    public static void Lexo_small(int n, int k){
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');

        for(int i = n-1; i >= 0; i--) {
            k -= i;
            if (k >= 0) {
                if (k >= 26) {
                    arr[i] = 'z';
                    k -= 26;
                } else {
                    arr[i] = (char) (k + 97 - 1);
                    k -= arr[i] - 'a' + 1;
                }
            } else {
                break;
            }
            k+= i;
        }

        System.out.println("Lexo Smallest String: " + String.valueOf(arr));
    }

    public static void Buy_and_sell_stocks (int[] prices){
        int buyPrice = Integer.MAX_VALUE;
        int profit = 0;

        for(int i = 0; i < prices.length; i++) {
            buyPrice = Math.min(buyPrice, prices[i]);
            profit = Math.max(profit, prices[i] - buyPrice);
        }

        System.out.println("Maximum Profit: " + profit);
    }

    public static int ans = Integer.MAX_VALUE;;
    public static void Minimize_max_sum_of_subarrays (int[] arr, int k, int n, int idx, int sum, int maxSum){
        // ⭕🔴 this is BRUTE FORCE APPRAOCH - OPTIMIZE WITH DP ⭕🔴
        // base condition
        sum = 0;
        if (k == 1) {
            // sum = 0;
            for(int i = idx; i < n; i++) {
                sum += arr[i];
            }
            maxSum = Math.max(maxSum, sum);
            ans = Math.min(ans, maxSum);
            return;
        }
        for(int i = idx; i < n; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            Minimize_max_sum_of_subarrays(arr, k-1, n, i+1, sum, maxSum);
        }
    
    }

    public static void main(String args[]) {
        Maximum_Balance_String_Partitions("LRRRRLLRLLRL");

        K_Larget_Odd_Num(new int[]{-10,10}, 3);

        Lexo_small(5, 42);

        Buy_and_sell_stocks(new int[]{7,1,5,3,6,4});

        int[] arr = {1,2,3,4,5};
        int k = 1; // no. of partitions
        Minimize_max_sum_of_subarrays(arr, k, arr.length, 0, 0, 0);
        System.out.println("Minimum Max Sum: " + ans);
    }
}
