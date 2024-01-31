import java.util.*;

public class Sorting{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int arr[] = {7,8,3,1,2};

        // bubbleSort(arr);
        // selectionSort(arr);
        insertionSort(arr);
    }

    public static void swap(int[] arr,int a,int b){
        // in Java, primitive data type (int) are passed by VALUE n NOT by REFERENCE. Thus, to swap the elements, pass the array and indices and not the array values
        int temp = arr[b];
        arr[b] = arr[a] ;
        arr[a] = temp;
    }

    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void insertionSort(int arr[]){
        // TC : O(n^2)
        int len = arr.length;
        for(int i=1;i<len;i++){
            int j = i - 1;
            int temp = arr[i];
            while(j>=0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        printArray(arr);
    }

    public static void selectionSort(int arr[]){
        // TC : O(n^2)
        int len = arr.length;
        for(int i=0;i<len-1;i++){
            int min = i;
            for(int j=i+1;j<len;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            if(min != i){
                swap(arr,min,i);
            }
        }
        printArray(arr);
    }

    public static void bubbleSort(int arr[]){
        // TC : O(n^2)
        int len = arr.length;
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-i-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        printArray(arr);
    }

}