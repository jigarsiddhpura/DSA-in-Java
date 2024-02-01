import java.util.*;

public class Recursion_advancePS{

    
    public static void main(String[] args){
        
        // permutations("abc","");
        
        // int totalPaths = countPaths(0,0,3,3);
        // System.out.println(totalPaths);
        
        // System.out.println(placeTiles(4,2));
        
        // System.out.println(callGuests(4));

        // ArrayList<Integer> subset = new ArrayList<>();
        // subsetPrint(3,subset);

        removeDuplicates(0, "appnnacolllegge", new StringBuilder(""), new int[26]);

    }

    // Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.
    // ✅ GOLDMAN SACHS ✅

    public static int friendsPairing (int n){
        if (n==1 || n==2) {
            return n;
        }

        // total ways = single + pair (choices for each pair * 1 pair ways  )
        return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    
    }


    // remove duplicates from string 
    // ✅ GOOGLE, MICROSOFT ✅
    public static void removeDuplicates (int idx,String str, StringBuilder newStr, int[] map){
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if (map[currChar-'a'] == 0) {
            map[currChar-'a'] = 1;
            newStr.append(currChar);
        }
        removeDuplicates(idx+1,str,newStr,map);
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
    
    // no. of ways we can fill the floor of size (2,n) with titles of size (2,1)
    // ✅ AMAZON ✅
    public static int tilingProblem (int n){
        if (n==0 || n==1){
            return 1;
        }

        int verticalPlacement = tilingProblem(n-1);
        int horizontalPlacement = tilingProblem(n-2);

        return verticalPlacement + horizontalPlacement;
    }

    // no. of ways we can fill the floor of size (n,m) with titles of size (1,m)
    public static int placeTiles(int n , int m ){
        if(n==m){
            return 2;
        }
        if(n<m){
            // n = 0 or 1
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