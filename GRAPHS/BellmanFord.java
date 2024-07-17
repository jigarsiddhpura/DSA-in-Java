import java.util.*;

public class BellmanFord {
    static class Edge {
        int src, dest, weight;

        public Edge (int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void createGraph (ArrayList<Edge> graph){

        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        graph.add(new Edge(1, 2, -4));

        graph.add(new Edge(2, 3, 2));

        graph.add(new Edge(3, 4, 4));

        graph.add(new Edge(4, 1, -1));
    }

    public static void bellmanFord (ArrayList<Edge> graph, int src, int V){
        
        int[] dist = new int[V];
        int[] parent = new int[V];

        for(int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
                parent[i] = -1;
            }
        }
        
        for(int i=0; i<V-1; i++) {  
            for(int j=0; j<graph.size(); j++) { // for all edges
                Edge e = graph.get(j);

                if (dist[e.src] != Integer.MAX_VALUE &&  dist[e.dest] > dist[e.src] + e.weight) {
                    // IN JAVA -> INFINITY + something will be -ve
                    // checks if the distance from the source vertex to the source of the current edge has already been initialized. If it has been initialized (i.e., it's not equal to infinity), then it means that a path from the source vertex to e.src has been discovered earlier in the algorithm.
                    dist[e.dest] = dist[e.src] + e.weight;
                    parent[e.dest] = e.src;
                }
            }
        }

        for(int i = 0; i < V; i++) {
            System.out.println("Dist from " + src + " to " + i + " is " + dist[i]);
        }

    }



    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph = new ArrayList<>(); // null is stored currently

        createGraph(graph);
        bellmanFord(graph, 0, V);
    }
}