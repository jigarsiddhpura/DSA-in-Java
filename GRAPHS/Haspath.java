import java.util.*;

public class Haspath {
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
    public static boolean hasPath (ArrayList<Edge> graph[], int src, int dest, boolean visited[]){ // O(V+E) if used adjacency list, if used adjacency matrix then O(V^2)
        if (src == dest) return true;

        visited[src] = true;
        for(int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) {
                return true;
            }
        }
        return false;
    }           
    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V]; // null is stored currently

        createGraph(graph);
        System.out.println("HasPath from 0 to 5: " + hasPath(graph, 0, 5, new boolean[V]));
    }
}