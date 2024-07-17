import java.util.*;

public class CycleDetectionDirected {
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

        graph[0].add(new Edge(0, 2, 10));

        graph[1].add(new Edge(1, 0, 10));

        graph[2].add(new Edge(2, 3, 6));

        graph[3].add(new Edge(3, 0, 5));
    }

    public static boolean detectCycleDirectedUtil (ArrayList<Edge>[] graph, int curr, boolean[] visited, boolean[] stack) { 
        visited[curr] = true;
        stack[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (stack[e.dest] == true) return true; // is cycle
            if (!visited[e.dest] && detectCycleDirectedUtil(graph, e.dest, visited, stack)) return true;

        }
        stack[curr] = false;
        return false;
    }

    // O(V+E)
    public static boolean detectCycleDirected (ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];    
        boolean[] stack = new boolean[graph.length]; 
        
        for(int i = 0; i < graph.length; i++) {
            if (!visited[i] && detectCycleDirectedUtil(graph, i, visited, stack)) {
                return true;
            }
        }

        return false;
    }


    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V]; // null is stored currently

        createGraph(graph);
        System.out.println("Cycle: " + detectCycleDirected(graph));
    }
}