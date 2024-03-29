import java.util.*;

public class Heap_sort {

    public static void heapSort(int[] arr) { // O(nlogn) + O(nlogn) = O(nlogn) in total
        // step 1: create max heap 
        int n = arr.length;
        for(int i = n/2; i >= 0; i--) { // O(n/2 * logn) = O(nlogn)
            heapify(arr, i, n); 
        }

        // step 2: push larget at end
        for(int i = n-1; i >= 0; i--) {
            // swap (largest-first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i); // O(nlogn)
        }
    }

    private static void heapify(int[] arr, int i, int heapSize) {
        int leftChild = 2*i + 1;
        int rightChild = 2*i + 2;
        int maxIdx = i;

        if (leftChild < heapSize && arr[leftChild] > arr[maxIdx]) {
            maxIdx = leftChild;
        }

        if (rightChild < heapSize && arr[rightChild] > arr[maxIdx]) {
            maxIdx = rightChild;
        }

        if (maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxidx, heapSize);
        }
    }

    public static void main(String args[]) {
        int[] arr = {1,2,4,5,3};
        heapSort(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.println("" + arr[i]);
        }
    }
}