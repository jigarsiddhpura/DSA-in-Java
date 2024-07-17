import java.util.*;

public class Bipartite {
    static class Edge {
        int src, dest;

        public Edge (int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
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

    // O(V+E)
    public static boolean detectBipartite (ArrayList<Edge>[] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        
        List<Integer> queue = new LinkedList<>();

        for(int i=0; i<graph.length; i++) {
            if (color[i] == -1) {
                queue.add(i);
                color[i] = 0;
                
                // BFS
                while(!queue.isEmpty()) {
                    int node = queue.remove(0);
    
                    for(int j = 0; j < graph[node].size(); j++) {
                        Edge e = graph[node].get(j);
    
                        // case 1 : neighbor color is sme
                        if (color[e.dest] == color[node]) return false;
    
                        // case 3 : neighbor has no color
                        if (color[e.dest] == -1) color[e.dest] = (color[node] == 0) ? 1 : 0;
                        
                        queue.add(e.dest);  
                        // case 2 : neighbor color is diff -> continue;
                    }
                }
            }
        }

        return true;
    }



    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V]; // null is stored currently

        createGraph(graph);
        System.out.println("Bipartite: " + detectBipartite(graph));
    }
}