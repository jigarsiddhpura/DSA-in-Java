import java.util.*;

public class max_subarray_sum_kadanes_algorithm{
    public static int kadanes(int[] nums){
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        boolean allNegative = true;
        int max = Integer.MIN_VALUE;

        for (int i=0;i<nums.length;i++){
            currSum += nums[i];
            if (currSum < 0) currSum = 0;
            maxSum = Math.max(maxSum,currSum);

            // for case where all elements are negative , return smallest -ve integer
            if (nums[i]>0) allNegative = false;
            max = Integer.max(max,nums[i]);
        }
        return allNegative ? max : maxSum;
    }

    public static void main(String args[]){
        // int nums[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int nums[] = {-1, -2, -3 };
        int s = kadanes(nums);
        System.out.println("maxSumimum contiguous sum is " + s);
    }
}