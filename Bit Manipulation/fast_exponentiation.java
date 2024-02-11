import java.util.*;

public class fast_exponentiation {
    public static int fastExponentiation (int a, int n){
        int ans = 1;
        while (n>0) {
            if ((n & 1) != 0) { // check out LSB
                ans = ans * a;
            } 
            a = a * a;
            n = n >> 1; // right shift by one bit to move on to the next bit
        }
        return ans;
    }
    public static void main(String args[]) {
        int count = fastExponentiation(2,10);
        System.out.println(count);
    }
}