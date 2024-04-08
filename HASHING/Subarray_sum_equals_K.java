import java.util.*;

public class Subarray_sum_equals_K {
    public static void main(String args[]) {
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;

        // (sum, count)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // As there is at least one subarray with 0 sum which is the empty array itself.
        int sum=0, count=0;

        for(int j = 0; j < arr.length; j++) {
            sum += arr[j]; // sum(j) -> sum uptil index j
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            } 
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println("count = " + count);
    }
}