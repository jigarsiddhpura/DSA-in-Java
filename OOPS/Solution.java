import java.util.*;

public class Solution {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        while(n>0) {
            System.out.println(n);
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    public static void main(String args[]) {
        int n = hammingWeight(1101);
        System.out.println(n);
    }
}