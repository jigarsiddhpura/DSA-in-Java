import java.util.*;

public class Sliding_window_maximum {
    static class Pair implements Comparable<Pair> {
        int val, idx;

        public Pair (int val, int idx){
            this.val = val;
            this.idx = idx;
        } 
        
        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val; // descending order
        }
    }
    public static void main(String args[]) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new int[arr.length - k+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val;

        for(int i=k; i<arr.length; i++) {
            // Remove all elements from the PQ that are out of the current window [i-k, i]
            // The PQ contains elements that are in the window [i-k+1, i], so the condition is idx <= i-k
            // This is done to keep the PQ updated with the window elements and remove the elements out of the window
            while(pq.peek().idx <= i-k) {
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().val;
        }

        for(int i = 0; i < res.length; i++) {
            System.out.print(" " + res[i]);
        }
    }
}