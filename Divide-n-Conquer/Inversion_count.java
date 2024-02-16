import java.util.*;

public class Inversion_count {

    public static int merge (int[] arr, int left, int mid, int right){
        int i=left, j=mid, k=0, invCount = 0;
        int[] temp = new int[right-left+1];

        while(i<mid && j<=right) {
            if (arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid-i);
            }
        }

        
        while(i<mid){
            temp[k++] = arr[i++];
        }
        while(j<=right){
            temp[k++] = arr[j++];
        }

        for(i = left, k = 0; i <= right ; i++, k++) {
            arr[i] = temp[k];
        }

        return invCount;
    }

    public static int mergeSort (int[] arr, int left, int right){
        int invCount = 0;

        if (right > left) {
            int mid = left + (right - left)/2;
            invCount = mergeSort(arr,left,mid);
            invCount += mergeSort(arr,mid+1,right);
            invCount += merge(arr,left,mid+1,right);
            // passing mid+1 in merge bcz mid is in left sub-array
        }

        return invCount;
    }

    public static int getInversions (int[] arr){
        return  mergeSort(arr, 0 , arr.length -1);
    }

    public static void main(String args[]) {
        int[] arr = {2,4,1,3,5};
        System.out.println(getInversions(arr));
    }
}