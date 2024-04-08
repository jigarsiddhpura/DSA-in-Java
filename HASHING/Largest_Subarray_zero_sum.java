// ✨✨ REVISIT ✨✨

import java.util.*;

public class Largest_Subarray_zero_sum {
    public static void main(String args[]) {
        int[] arr = {15,-2,2,-8,1,7,10};
        int maxLen = 0, sum = 0;

        Map<Integer, Integer> map = new HashMap<>(); // key : value = sum : index

        for(int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum)) {
                int i = map.get(sum);
                maxLen = j - i;
            } else {
                map.put(sum, j);
            }
        }

        System.out.println("maxLen = " + maxLen);
    }
}