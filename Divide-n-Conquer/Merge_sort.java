import java.util.*;

public class Merge_sort {
    public static void printArray(String arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void merge (String arr[], int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        String[] L = new String [n1];
        String[] R = new String [n2];

        for(int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for(int j = 0; j < n2; j++) {
            R[j] = arr[mid + j + 1];
        }

        int i=0, j=0, k=left;
        while(i<n1 && j<n2) {
            if (isAlphabeticallySmaller(L[i],R[j])) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while(i<n1){
            arr[k++] = L[i++];
        }
        while(j<n2){
            arr[k++] = R[j++];
        }
    }

    public static void mergeSort (String arr[], int left, int right){
        if (left < right) {
            int mid = left + (right-left)/2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    public static boolean isAlphabeticallySmaller (String s1, String s2){
        if (s1.compareTo(s2) < 0) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        String[] arr = { "sun", "earth", "mars", "mercury"};
        mergeSort(arr,0,arr.length-1);
        printArray(arr);
    }
}