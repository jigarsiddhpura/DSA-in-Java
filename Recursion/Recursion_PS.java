import java.util.*;

public class Recursion_PS{

    public static int first = -1;
    public static int last = -1;
    public static boolean[] map = new boolean[26];
    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    
    public static void main(String[] args){

        int n = 3;
        towerOfHanoi(n,"S","H","D");

        // String str = "abcd";
        // reverse(str,str.length() - 1);
        
        // String str = "bacdabba";
        // char match = 'a';
        // findOccurence(str,match,0);

        // int[] arr = {1,2,4,3,1,2};
        // boolean ans = isSorted(arr,0);
        // System.out.print(ans);

        // moveAllX(0,"axbcxxd",0,"");

        // removeDuplicates("abbcdac",0,"");

        // ⭐⭐⭐
        // subsequences("abc",0,"");

        // HashSet<String> set = new HashSet<String>();
        // uniqueSubsequences("aaa",0,"",set);

        // printKeypadComb("23",0,"");

    }

    public static void towerOfHanoi(int n,String src,String helper,String dest){
        if(n==1){
            System.out.println("Move disk "+n+" from " + src +" to " + dest );
            return;
        }
        towerOfHanoi(n-1,src,dest,helper);
        System.out.println("Move disk "+n+" from " + src +" to " + dest );
        towerOfHanoi(n-1,helper,src,dest);
    }

    public static void reverse(String str,int idx){
        // TC = O(n)
        if(idx == -1){
            return;
        }
        System.out.print(str.charAt(idx));
        reverse(str,idx-1);
    }

    public static void findOccurence(String str,char match,int idx){
        // TC:O(N)
        if(idx == str.length()){                                    //base case
            System.out.print("first = "+first+" last = "+last);
            return;
        }
        char currChar = str.charAt(idx);
        if(currChar == match){
            if(first == -1){
                first = idx;
            } else { 
                last = idx;
            }
        }
        findOccurence(str,match,idx+1);
    }

    public static boolean isSorted(int[] arr,int idx){
        // strictly increasing , TC: O(n)
        if(idx == arr.length ){
            return true;
        }

        if(arr[idx] >= arr[idx+1]){
            return false;
        } else {
            return isSorted(arr,idx+1);
        }
    }

    public static void moveAllX(int idx,String str,int count,String newString){
        // T.C = O(n + count) = O(n+n) = O(2n) = O(n)
        // reason for count -> n is max(count) = n
        if(idx == str.length()){
            for(int i=0;i<count;i++){
                newString += 'x';
            }
            System.out.print(newString);
            return;
        }
        char currChar = str.charAt(idx);
        if(currChar == 'x'){
            moveAllX(idx+1,str,count+1,newString);
        } else {
            newString += currChar;
            moveAllX(idx+1,str,count,newString);
        }
    }

    public static void removeDuplicates(String str,int idx,String newString){
        if(idx == str.length()){
            System.out.print(newString);
            return;
        }
        char currChar = str.charAt(idx);
        int pos = currChar - 'a';
        if(!map[pos]){
            map[pos] = true;
            newString += currChar;
        }
        removeDuplicates(str,idx+1,newString);
    }

    public static void subsequences(String str,int idx,String newString){
        // T.C = 0(2^n)
        if(idx==str.length()){
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);

        // to be
        subsequences(str,idx+1,newString+currChar);

        // or not to be
        subsequences(str,idx+1,newString);
    }

    public static void uniqueSubsequences(String str,int idx,String newString,HashSet<String> set){
        // T.C = 0(2^n)
        if(idx==str.length()){
            if(set.contains(newString)){
                return;
            } else {
                set.add(newString);
                System.out.println(newString);
                return;
            }
        }

        char currChar = str.charAt(idx);

        // to be
        uniqueSubsequences(str,idx+1,newString+currChar,set);

        // or not to be
        uniqueSubsequences(str,idx+1,newString,set);
    }

    public static void printKeypadComb(String str,int idx, String combination){ 
        // T.C = O(4^n) where n = length of string, 4 = max length of a mapping
        if(idx == str.length()){
            System.out.println(combination);
            return;
        }
        char currChar = str.charAt(idx);
        String mapping = keypad[currChar - '0'];
        for(int i=0;i<mapping.length();i++){
            printKeypadComb(str,idx+1,combination+mapping.charAt(i));
        }
    }

}