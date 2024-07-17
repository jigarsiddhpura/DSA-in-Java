import java.util.*;

public class Graph {
    static class Edge {
        int src, dest, weight;

        public Edge (int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V]; // null is stored currently

        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 6));
        graph[0].add(new Edge(0, 3, 5));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 2));
        graph[2].add(new Edge(2, 0, 6));
        graph[2].add(new Edge(2, 1, 2));
        graph[2].add(new Edge(2, 3, 3));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 0, 5));
        graph[3].add(new Edge(3, 2, 3));
        graph[3].add(new Edge(3, 4, 1));
        graph[4].add(new Edge(4, 2, 3));
        graph[4].add(new Edge(4, 3, 1));

        // 2's neighbors
        for(int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println("2's neighbor " + e.dest + " with weight " + e.weight);
        }
    }
}