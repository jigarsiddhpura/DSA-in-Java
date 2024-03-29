import java.util.*;

public class Array {

    public static void printArray(int[] arr) {
        // Print the elements of the array
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void changeArr (int[] arr, int i, int val){
        // base
        if (i == arr.length) {
            printArray(arr);
            return ;
        }

        // recursion
        arr[i] = val;
        changeArr(arr,i+1,val+1); // func call wala step
        arr[i] = arr[i] - 2; // backtracking wala step ⭐
    }
    public static void main(String args[]) {
        int[] arr = new int[5];
        changeArr(arr,0,1);
        printArray(arr);
    }
}