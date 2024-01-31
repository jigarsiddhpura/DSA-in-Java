import java.util.*;

public class swapping {
    public static void main(String args[]) {
        int x = 3, y = 4;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("x = "+x+" y = "+y);
    }
}