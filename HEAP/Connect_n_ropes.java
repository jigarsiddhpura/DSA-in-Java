import java.util.*;

public class Connect_n_ropes {
    public static void main(String args[]) {
        int[] ropes = {4,3,2,6};
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while(pq.size() > 1) {
            int f = pq.remove();
            int s = pq.remove();
            cost += f + s;
            pq.add(f+s);
        }

        System.out.println("cost = "+cost);
    }
}