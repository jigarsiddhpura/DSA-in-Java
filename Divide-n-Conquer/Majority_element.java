import java.util.*;

public class Majority_element {

    public static int countInRange (int[] arr, int num, int low, int high) { 
        int count = 0;
        for(int i = low; i <= high; i++) {
            if (arr[i] == num) count++;
        }
        return count;
    }

    public static int majorityElementRec (int[] arr, int low, int high){
        // base case : only 1 element
        if (low == high) {
            return arr[0];
        }
        int mid = low + (high-low)/2;
        int leftMax = majorityElementRec(arr,low,mid);
        int rightMax = majorityElementRec(arr,mid+1,high);

        if (leftMax==rightMax) return leftMax;

        int countLeftMax = countInRange(arr,leftMax,low,high);
        int countRightMax = countInRange(arr,rightMax,low,high);

        return (countLeftMax>countRightMax) ? countLeftMax : countRightMax;
    }

    public static int findMajorityElement (int[] arr){
        return majorityElementRec(arr, 0, arr.length-1);
    }

    public static void main(String args[]) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println("The majority element is " + findMajorityElement(arr));
    }
}