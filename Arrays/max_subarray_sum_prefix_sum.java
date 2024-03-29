import java.util.*;

public class max__sum_prefix_sum{
    public static int maxSum(int[] arr){
        int max = Integer.MIN_VALUE, currSum = 0;
        int[] prefix = new int[arr.length];
        
        prefix[0] = arr[0];
        for (int i=1;i<prefix.length;i++) prefix[i] = prefix[i-1] + arr[i];

        for (int i=0;i<arr.length;i++){
            for (int j=i;j<arr.length;j++){
                currSum = i==0 ? prefix[j] : prefix[j] - prefix[i-1];
                if (currSum > max) max = currSum;
            }
        }
        return max;
    }
    public static void main(String args[]){
        int arr[] = {1, -2, 6, -1, 3};
        int s = maxSum(arr);
        System.out.println("Maximum contiguous sum is " + s);
    }
}