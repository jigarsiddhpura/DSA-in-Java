import java.util.*;

public class HashMap_Implementation {
    static class HashMap<K,V> { // generalizing datatype of key and value
        private class Node {
            K key;
            V value;
            
            public Node (K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; // number of key-value pairs / nodes
        private int N; // number of buckets
        private LinkedList<Node> buckets[]; // N = buckets.length
        
        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4]; // initial number of buckets is 4
            for(int i = 0; i < buckets.length; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunc(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di;
            for(di = 0; di < ll.size(); di++) {
                Node node = ll.get(di);
                if (node.key == key) {
                    return di;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        public void rehash () {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];
            N = N*2;

            for(int i=0; i<buckets.length; i++) {
                buckets[i] = new LinkedList<Node>();
            }

            for(int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for(Node node: ll) {
                    put(node.key, node.value);
                }
            }
        }   

        public void put (K key, V value) { // O(lambda) -> O(1)
            int bucketIdx = hashFunc(key);
            int di = searchInLL(key, bucketIdx);

            if (di != -1) {
                Node node = buckets[bucketIdx].get(di);
                node.value = value;
            } else {
                buckets[bucketIdx].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n/N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey (K key) {// O(1)
            int bucketIdx = hashFunc(key);
            int di = searchInLL(key, bucketIdx);

            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V get (K key){// O(1)
            int bucketIdx = hashFunc(key);
            int di = searchInLL(key, bucketIdx);

            if (di != -1) {
                Node node = buckets[bucketIdx].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V remove (K key){ // O(1)
            int bucketIdx = hashFunc(key);
            int di = searchInLL(key, bucketIdx);

            if (di != -1) {
                Node node = buckets[bucketIdx].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for(int i = 0; i < N; i++) {
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty (){
            return n==0;
        }   

    }
    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("mango", 100);
        hm.put("banana", 200);
        hm.put("apple", 300);

        ArrayList<String> keys = hm.keySet();
        for(String k : keys) {
            System.out.println("key = " + k + ", value = " + hm.get(k));
        }
    }
}