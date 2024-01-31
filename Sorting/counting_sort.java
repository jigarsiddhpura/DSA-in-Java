import java.util.*;

public class counting_sort {
    public static int[] countingSort (int[] nums){
        // calc max value
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
        }

        // updating freq arr
        int[] count = new int [max+1];
        for(int i=0; i<nums.length; i++){
            count[nums[i]]++;
        }

        // sorting
        int j=0;
        for(int i = 0; i < count.length; i++) {
            while(count[i]>0){
                nums[j] = i;
                j++;
                count[i]--;
            }
        }
        return nums;
    }
    public static void main(String args[]) {
        int[] nums = {1,4,1,3,2,4,3,7};
        int[] s = countingSort(nums);
        for(int i = 0; i < s.length; i++) {
            System.out.print(s[i]+" ");
        }
    }
}