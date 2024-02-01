import java.util.*;

public class Recursion{
    public static void main(String[] args){
        int n = 6;
        // printNum(5);
        // sumNatural(0,n,0);

        int fact_n = factorial(n);
        System.out.println(fact_n);
        // fibonacci(0,1,n-2);
        
        // int xPowN = calcPower(2,5);
        // System.out.println(xPowN);

    } 

    public static void printNum(int n){
        // for each recursive call -> `n` is created in the memory , which doesn't happen in iteration
        // if there is not base condition then the problem STACK OVERFLOW will occur due to MEMORY getting filled
        if(n==0){
            return;
        } else{
            System.out.println(n);
            printNum(n-1);
        }
    }

    public static void sumNatural(int i,int n,int sum){
        if(i == n+1){
            System.out.print(sum);
            return;
        }
        sum += i;
        sumNatural(i+1,n,sum);
    }

    public static int factorial(int n){
        if(n == 0 || n == 1){
            return 1; 
        }
        int fact_n = n * factorial(n-1);
        return fact_n;
    }

    public static void fibonacci(int a,int b,int n){
        if(n == 0){
            return; 
        }
        if(a==0){
            System.out.printf(a+" "+b+" ");
        }
        int sum = a + b;
        System.out.print(sum+" ");
        fibonacci(b,sum,n-1);
    }

    public static int calcPower(int x,int n){
        // stack height = n
        if(n == 0){
            return 1; 
        }
        if(x == 0){
            return 0;
        }
        int xPown = x * calcPower(x,n-1);
        return xPown;
    }

    public static int calcPowerlogn(int x,int n){
        // stack height = logn
        if(n == 0){
            return 1; 
        }
        if(x == 0){
            return 0;
        }
        int xPown = calcPower(x,n/2);
        if(n%2 == 0){
            return xPown * xPown;
        } else {
            return xPown * xPown * x;
        }
    }

    public static boolean isSorted (int[] arr, int i){
        if (i == arr.length-1) {
            return true;
        }
        if (arr[i] > arr[i+1]) {
            return false;
        }
        return isSorted(arr,i+1);
    }

    public static int firstOccurence (int[] arr, int i, int key){
        if (i == arr.length) return -1;

        // compare with self
        if (arr[i] == key) return i;

        // then look forward
        return firstOccurence(arr,i+1,key);
    }

    public static int lastOccurence (int[] arr, int i, int key){
        if (i == arr.length) return -1;

        // Look forward
        int isFound = lastOccurence(arr,i+1,key);

        // then compare with self
        if (isFound == -1 && arr[i] == key) return i;

        return isFound;
    }
}