import java.util.*;

public class FindSubset {
    public static void findsubset (int i, String str, String subset){
        if(i == str.length()){
            System.out.println(subset);
            return;
        }
        findsubset(i+1, str, subset+str.charAt(i));  //include current element in the subset
        findsubset(i+1, str, subset);

    }
    public static void main(String args[]) {
        String str = "abc";
        findsubset(0, str, "");
    }
}