import java.util.*;

public class BFS {
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
    }
    public static void BFS (ArrayList<Edge> graph[]){ // O(V+E) if used adjacency list, if used adjacency matrix then O(V^2)
        List<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];

        queue.add(0); // src = 0
        while(!queue.isEmpty()) {
            int currNode = queue.remove(0);
            
            if (!visited[currNode]) {
                System.out.print(" " + currNode);
                visited[currNode] = true;
                for(int i=0; i<graph[currNode].size(); i++) {
                    Edge e = graph[currNode].get(i);
                    queue.add(e.dest);
                }
            }
        }
    }           
    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V]; // null is stored currently

        createGraph(graph);
        BFS(graph);
        
    }
}