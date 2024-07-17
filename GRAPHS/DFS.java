import java.util.*;

public class DFS {
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

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 6));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 2));

        graph[2].add(new Edge(2, 0, 6));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 1, 5));
        graph[3].add(new Edge(3, 4, 3));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 3));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }
    public static void DFS (ArrayList<Edge> graph[], int curr, boolean visited[]){ // O(V+E) if used adjacency list, if used adjacency matrix then O(V^2)
        System.out.print(" " + curr);
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                DFS(graph, e.dest, visited);
            }
        }
    }           
    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V]; // null is stored currently

        createGraph(graph);
        DFS(graph, 0, new boolean[V]);
        
    }
}