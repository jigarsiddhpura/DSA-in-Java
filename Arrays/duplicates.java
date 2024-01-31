// Question 1:Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct

// DSA Sheet #4

import java.util.*;

public class duplicates {
    public static boolean checkduplicates (int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            // set.add(element) will return false if the set already contains a value
            if(!set.add(arr[i])) return true;
        }
        return false;
    }
    public static void main(String args[]) {
        int arr[] = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean s = checkduplicates(arr);
        System.out.println("duplicates = " + s);
    }
}