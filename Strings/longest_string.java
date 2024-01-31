import java.util.*;

public class longest_string {
    public static void main(String args[]) {
        String[] arr = {"apple", "mango","chiko"}; 
        // checking longest lexicographically
        String longest = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(longest.compareTo(arr[i]) < 0) {
                longest = arr[i];
            }
        }
        System.out.println("The length of the longest string is : "+longest);
    }
}