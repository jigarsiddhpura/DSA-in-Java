import java.util.*;

public class FractionalKnapsack {
    public static void main(String args[]) {
        int[] weight = {10,20,30};
        int[] value = {60,100,120};

        int capacity = 50;

        double ratio[][] = new double[weight.length][2];
        for(int i=0; i<weight.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }

        int ans = 0;

        // sort based on ratio
        Arrays.sort(ratio, Comparator.comparingDouble(a -> a[1]));

        // thus looping from back bcz we want to take value with max ratio first
        for(int i = ratio.length-1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                ans += value[idx];
                capacity -= weight[idx];
            } else {
                ans += capacity * ratio[i][1];
                break;
            }
        }

        System.out.println("Maximum Profit : " + ans);
    }
}