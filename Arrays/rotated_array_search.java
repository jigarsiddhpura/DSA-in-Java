// Question 2:There is an integer array nums sorted in ascending order (with distinct values).Prior to being passed to your function, nums is possibly rotated at an unknown pivot  index k (1  <=  k  <  nums.length)  such  that  the  resulting  array  is [nums[k], nums[k+1],   ...,   nums[n-1], nums[0],   nums[1],   ...,   nums[k-1]] (0-indexed).   For   example, [0,1,2,4,5,6,7] might        be        rotated        at        pivot        index 3   and become [4,5,6,7,0,1,2].Given the array nums after the possible rotation and an integer target, returnthe index oftarget if it is in nums, or -1   if it is not in nums.You must write an algorithm with O(log n) runtime complexity ⭐⭐

// DSA Sheet #6

import java.util.*;

public class rotated_array_search {
    public static int minIndex (int[] arr){
        // find the index of minimum element in a rotated array
        int left=0, right=arr.length-1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(mid > 0 && arr[mid-1] > arr[mid]){
                return mid;
            } else if (arr[mid] >= arr[left] && arr[mid] > arr[right]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

    public static int findIndex (int[] arr, int target){
        int min = minIndex(arr);
        if(target >= arr[min] && target <= arr[arr.length-1]) {
            return binarySearch(arr, min, arr.length-1, target);
        } else {
            return binarySearch(arr, 0, min, target);
        }
    }

    public static int binarySearch (int[] arr, int start, int end, int target){
        int l = start, r = end;
        while(l<=r) {                  // 🔴🔴 MISTAKE 1 : l<r 
            int m = l+(r-l)/2;
            if(arr[m] == target) return m;
            else if(arr[m] > target) r = m-1;
            else l = m+1;
        }
        return -1; // if no match found
    }
    public static void main(String args[]) {
        int arr[] = {4,5,6,7,0,1,2};
        int target = 0;
        int s = findIndex(arr,target);
        System.out.println("duplicates = " + s);
    }
}