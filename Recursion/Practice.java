import java.util.*;

public class Practice {
    static String digits[] = {"zero","one","two","three", "four","five","six","seven","eight","nine"};

    public static void printDigits (int digit){
        if (digit == 0) {
            return;
        }
        int lastDigit = digit%10;
        printDigits(digit/10);
        System.out.print(digits[lastDigit]+" ");
    }   

    public static int length (String str){
        if (str.length() == 0) return 0;

        return length(str.substring(1)) + 1;
    }   

    public static int countSubStrs (String str, int i){
        // base
        if (i == str.length()) return 0;
        
        int count = 0;
        for(int j = i; j < str.length(); j++) {
            if (str.charAt(i) == str.charAt(j)) count++;
        }

        return count+countSubStrs(str, i+1);
    }

    public static void main(String args[]) {
        // printDigits(1290);

        // int len = length("abcde");
        // System.out.println(len);

        String str = "aba";
        int i = 0;
        System.out.println(countSubStrs(str,i));
    }
}