import java.util.*;

public class AllPaths {
    static class Edge {
        int src, dest, weight;

        public Edge (int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void createGraph (ArrayList<Edge> graph[]){

        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3, 6));

        graph[2].add(new Edge(2, 3, 6));

        graph[3].add(new Edge(3, 1, 5));

        graph[4].add(new Edge(4, 0, 3));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
    }
    public static void printAllPath (ArrayList<Edge> graph[], int src, int dest, String path){ // O(V+E) if used adjacency list, if used adjacency matrix then O(V^2)
        if (src == dest) {
            System.out.println(path+dest);
            return;
        }

        for(int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path + src);
        }
    }           
    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V]; // null is stored currently

        createGraph(graph);
        printAllPath(graph, 5, 1, "");
        
    }
}