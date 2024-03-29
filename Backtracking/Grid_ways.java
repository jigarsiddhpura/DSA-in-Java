import java.util.*;

public class Grid_ways {
    // Exponential time = 2^(m+n)
    public static int totalGridWays (int i, int j, int row, int col){
        // base condn
        if (i==row-1 && j==col-1) {
            return 1;
        } else if (i==row || j==col) {
            return 0;
        }
    
        int w1 = totalGridWays(i+1, j, row, col); // right turn
        int w2 = totalGridWays(i, j+1, row, col); // down turn

        return w1+w2;
    }

    public static int factorial (int n){
        if (n==1) return 1;
        if (n==0) return 0;

        return n * factorial(n-1);
    }

    // Linear time = O(n)
    public static int totalGridWays (int row, int col){
        return (factorial(row-1+col-1)/(factorial(row-1)*factorial(col-1)));
    }
    public static void main(String args[]) {
        int n = 3, m = 3;

        int total = totalGridWays(0,0,n,m);
        System.out.println(total);
        
        int total_new = totalGridWays(n,m);
        System.out.println(total);

    }
}