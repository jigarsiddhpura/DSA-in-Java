import java.util.*;

public class Recursion_advancePS{

    
    public static void main(String[] args){
        
        // permutations("abc","");
        
        // int totalPaths = countPaths(0,0,3,3);
        // System.out.println(totalPaths);
        
        // System.out.println(placeTiles(4,2));
        
        // System.out.println(callGuests(4));

        ArrayList<Integer> subset = new ArrayList<>();
        subsetPrint(3,subset);
    }

    public static void permutations(String str,String permutation){
        // T.C = O(n!)
        if(str.length() == 0){
            System.out.println(permutation);
            return;
        }
        for(int i=0;i<str.length();i++){
            char currChar = str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i+1);
            permutations(newStr, permutation+currChar);
        }
    }

    // count total paths in a maze from (0,0) to (n,m)
    public static int countPaths(int i,int j,int n,int m){
        //base case: when we reach the boundary - i.e no further path
        if(i == n || j == m){
            return 0;
        }
        // base case : when we reach the destination
        if(i == n-1 && j == m-1){
            return 1;
        }

        // move downwards
        int downPaths = countPaths(i+1,j,n,m);

        // move right
        int rightPaths = countPaths(i,j+1,n,m);

        return downPaths + rightPaths;
    }

    // no. of ways we can fill the floor of size (n,m) with titles of size (1,m)
    public static int placeTiles(int n , int m ){
        if(n==m){
            return 2;
        }
        if(n<m){
            return 1;
        }
    
        // vertically
        int verticalPlacement = placeTiles(n-m,m);
    
        // horizontally
        int horizontalPlacement = placeTiles(n-1,m);
    
        return verticalPlacement + horizontalPlacement;
    }

    // no. of ways in which u can invite n people to the party - single / pairs (default meaning of pair = pair of 2 only)
    public static int callGuests(int n){
        // <= bcz if guests<1 -> no way to call them -> 1 way
        if(n <= 1){
            return 1;
        }

        // single
        int ways1 = callGuests(n-1);

        // pair
        int ways2 = (n-1) * callGuests(n-2);

        return ways1 + ways2;
    }

    // print all subsets of 1st `n` natural no.s
    public static void subsetPrint(int n, ArrayList<Integer> subset) {
        if(n==0){
            printArray(subset);
            return;
        }

        // add hoga
        subset.add(n);
        subsetPrint(n-1,subset);

        // add nhi hoga
        subset.remove(subset.size() - 1);
        subsetPrint(n-1, subset);
    }

    public static void printArray(ArrayList<Integer> arr){
        for(int i=0;i<arr.size();i++){
            System.out.print(" "+arr.get(i));
        }
        System.out.println("");
    }


}