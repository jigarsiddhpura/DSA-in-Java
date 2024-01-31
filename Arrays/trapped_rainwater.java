// refer leetcode ka mera ans ... vo short hai ✅✅

import java.util.*;

public class trapped_rainwater{
    public static int trappedWater(int[] height){
        int n = height.length;

        // left max boundary ka array
        int[] leftMax = new int[n];
        leftMax[0] =height[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        } 

        // right max boundary ka array
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }

        int total = 0;
        for(int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i],rightMax[i]);
            total += waterLevel - height[i];
        }

        return total;
    }
    public static void main(String args[]){
        int arr[] = {4,2,0,6,3,2,5};
        int s = trappedWater(arr);
        System.out.println("trappedWater is " + s);
    }
}