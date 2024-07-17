import java.util.*;

public class ConnectedComponents {
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

    public static void DFS (ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[visited.length];

        for(int i = 0; i < graph.length; i++) {
            DFSUtil(graph, i, visited);
        }
    }
    public static void DFSUtil (ArrayList<Edge> graph[], int curr, boolean visited[]){ // O(V+E) if used adjacency list, if used adjacency matrix then O(V^2)
        System.out.print(" " + curr);
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                DFS(graph, e.dest, visited);
            }
        }
    }  
    
    public static void BFS (ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                BFSUtil(graph, visited);
            }
        }
    }
    
    public static void BFSUtil (ArrayList<Edge> graph[], boolean visited){ // O(V+E) if used adjacency list, if used adjacency matrix then O(V^2)
        List<Integer> queue = new ArrayList<>();

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
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V]; // null is stored currently

        createGraph(graph);
        DFS(graph);
        
    }
}