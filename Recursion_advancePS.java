import java.util.*;

public class Recursion_advancePS{
    public static void main(String[] args){

        // permutations("abc","");

        int totalPaths = countPaths(0,0,3,3);
        System.out.println(totalPaths);
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

    // vertically
    

    }
}