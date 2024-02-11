// BINARY STRING PROBLEM - print all binary string of size N WITHOUT CONSECUTIVE ONES
// PAYTM 

import java.util.*;

public class Binary_String {
    public static void binaryString (int n, int lastPlace, String str){
        // base 
        if (n == 0) {
            System.out.println(str);
            return;
        }

        if (lastPlace == 0) {
            // if last place is 0 -> i can add both 0 & 1 in my right
            binaryString(n-1, 0, str+"0");
            binaryString(n-1, 1, str+"1");
        } else {
            // if last place is 1 -> i can add both only 1 in my right
            binaryString(n-1, 0, str+"0");
        }
    }
    public static void main(String args[]) {
        // initially if we set lastPlace = 1, it will not go in 1st `if` & string starting from 1 won't be considered 
        binaryString(3, 0, "");
    }
}