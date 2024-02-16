import java.util.*;

public class Sorted_and_Rotated_Array {
    public static int search (int[] arr, int tar, int si, int ei){
        if (si > ei) {
            return -1;
        }

        int mid = si + (ei - si)/2;
        if (tar == arr[mid]) {
            return mid;
        }

        // mid on L1
        if (arr[si] <= arr[mid]) {
            // case a : left
            if (arr[si] <= tar && tar < arr[mid]) {
                return search(arr,tar,si,mid-1);
            }
            // case b : right
            else {
                return search(arr,tar,mid+1,ei);
            }
        }
        // mid on L2
        else {
            // case a : right
            if (arr[mid] < tar && tar <= arr[ei]) {
                return search(arr,tar,mid+1,ei);
            }
            // case b : left
            else {
                return search(arr,tar,si,mid-1);
            }
        }
    }
    public static void main(String args[]) {
        int[] arr = {4,5,6,7,0,1,2};
        int tar = 1;
        System.out.println(search(arr,tar,0,arr.length-1));
    }
}