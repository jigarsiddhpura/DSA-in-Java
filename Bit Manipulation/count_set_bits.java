import java.util.*;

public class count_set_bits {
    public static int countSetBits (int n){
        int count = 0;
        while (n>0) {
            if ((n & 1) != 0) { // check out LSB
                count++;
            } 
            n = n >> 1; // right shift by one bit to move on to the next bit
        }
        return count;
    }
    public static void main(String args[]) {
        int n = 5;
        int count = countSetBits(n);
        System.out.println(count);
    }
}