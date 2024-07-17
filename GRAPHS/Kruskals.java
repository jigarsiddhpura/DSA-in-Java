import java.util.*;

public class Kruskals {
    static int n = 7;
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static class Edge implements Comparable<Edge>{
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    public static void init (){
        for(int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find (int x){
        if (par[x] == x) return x;

        // return find(par[x]);
        return par[x] = find(par[x]);
        // above line is `PATH COMPRESSION` for FAST RETREIVAL as THE HEIGHT OF THE TREE REDUCES ⭐⭐⭐
        // dry run it for better understanding 
    }  
    
    public static void union (int a, int b){
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            // par[parB] = parA;
            // rank[parA]++;
            par[parA] = parB;
            rank[parB]++;
        } else if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else {
            par[parA] = parB;
        }
    }

    public static void createEdges (ArrayList<Edge> edges){
        edges.add(new Edge(0, 1, 10));    
        edges.add(new Edge(0, 2, 15));    
        edges.add(new Edge(0, 3, 30));    
        edges.add(new Edge(0, 3, 40));    
        edges.add(new Edge(0, 3, 50));    
    }

    public static void KruskalsMST (ArrayList<Edge> edges, int V){

        init();     

        Collections.sort(edges);
        int count = 0, mstCost = 0;

        for(int i = 0; count < V-1; i++) { // no. of edges = V-1
            // Edge curr = edges.get(i);
            Edge curr = edges.remove(0); // sme as above

            int parA = find(curr.src);
            int parB = find(curr.dest);

            if (parA != parB) { // no cycle is formed on connecting a n b
                union(parA, parB);
                count++;
                mstCost += curr.wt;
            }
        }

        System.out.println("Min mstCost = "+mstCost);
    }
    public static void main(String args[]) {
        ArrayList<Edge> edges = new ArrayList<>();
        createEdges(edges);
        int V = 4;
        KruskalsMST(edges, V);
    }
}