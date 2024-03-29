import java.util.*;

public class Heaps {
    static class Heap {
        // MIN HEAP by default
        List<Integer> arr = new ArrayList<>();

        public void add (int data){
            arr.add(data); // add to the last

            int child_i = arr.size()-1; // child index
            int par_i = (child_i-1)/2; // parent index

            // fix heap
            while(arr.get(child_i) < arr.get(par_i)){  // logn
                int temp = arr.get(child_i);
                arr.set(child_i, arr.get(par_i));
                arr.set(par_i, temp);

                child_i = par_i;
                par_i = (child_i - 1)/2;
            }
        }
        
        public int peek (){
            return arr.get(0);  
        }

        private void heapify(int i){ 
            int leftIdx = 2*i + 1, rightIdx = 2*i + 2;
            int minIdx = i;

            if (leftIdx < arr.size() && arr.get(leftIdx) < arr.get(minIdx)) {
                minIdx = leftIdx;
            } 
            if (rightIdx < arr.size() && arr.get(rightIdx) < arr.get(minIdx)) {
                minIdx = rightIdx;
            } 

            // swap with min
            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove (){
            // removing 1st element
            int data = arr.get(0);

            // step 1: swap 1st n last elem
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, data);

            // step 2 : remove last idx
            arr.remove(arr.size()-1);

            // step 3: heapify root
            heapify(0);
            return data;
        }

        public boolean isEmpty (){
            return arr.size() == 0;
        }
    }
    public static void main(String args[]) {
        Heap h = new Heap();

        h.add(5);
        h.add(4);
        h.add(3);
        h.add(2);

        while(!h.isEmpty()) {  // heap sort
            System.out.println(h.remove());
        }
    }
}