import java.util.*;

public class threeSum {
    public static List<List<Integer>> findTriplets (int[] arr){
        int target = 0;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {
            int j=i+1, k=arr.length-1;
            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == target){
                    set.add(Arrays.asList(arr[i],arr[j],arr[k]));
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        ans.addAll(set);
        return ans;
    }
    public static void main(String args[]) {
        int arr[] = {-1, 0,  1, 2, -1, -4};
        List<List<Integer>> s = findTriplets(arr);
        System.out.println("trappedWater is " + s);
    }
}