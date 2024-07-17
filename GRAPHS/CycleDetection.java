import java.util.*;

public class CycleDetection {
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

    public static boolean detectCycleUtil (ArrayList<Edge> graph[], int curr, boolean[] visited, int parent){
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) { // iterating over all neighbors
            Edge e = graph[curr].get(i);

            // case 3 - neightbor is not visited so check for cycle in its neighbors
            if (!visited[e.dest] ) {
                if (detectCycleUtil(graph, e.dest, visited, curr)) {
                    return true;
                }
            }  
            
            // case 1 - neighbor is visited and not parent -> cycle
            else if (visited[e.dest] && e.dest != parent) {
                return true;
            }

            // case 2 (when neighbor is visited & is parent)- do nthg -> continue;
        }
        return false;
    }

    public static boolean detectCycleUtilBFS (ArrayList<Edge> graph[], int src, boolean[] visited){
        int[] parent = new int[graph.length];
        Arrays.fill(parent, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        visited[src] = true;

        while(!q.isEmpty()) {
            int curr = q.remove();
            for(int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);

                if (!visited[e.dest]) {
                    visited[e.dest] = true;
                    q.add(e.dest);
                    parent[e.dest] = curr;
                } else if (e.dest != parent[curr]) {
                    return true;
                }
            }
        }
        return false;
    }

    // O(V+E)
    public static boolean detectCycle (ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) { // loop for all disjoint components
            if (!visited[i]) {
                // 1st node ka parent in a disjoint set is -1
                if (detectCycleUtil(graph, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    // O(V+E)
    public static boolean detectCycleBFS (ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) { // loop for all disjoint components
            if (!visited[i]) {
                // 1st node ka parent in a disjoint set is -1
                if (detectCycleUtilBFS(graph, i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V]; // null is stored currently

        createGraph(graph);
        System.out.println("Cycle: " + detectCycle(graph));
        System.out.println("Cycle: " + detectCycleBFS(graph));
    }
}