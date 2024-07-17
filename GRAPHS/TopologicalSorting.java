import java.util.*;

public class TopologicalSorting {
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
        graph[0].add(new Edge(0, 1, 10));

        graph[2].add(new Edge(2, 3, 6));

        graph[1].add(new Edge(1, 3, 5));
    }

    public static void topologicalSortUtil (ArrayList<Edge>[] graph, int curr, boolean[] visited, Deque<Integer> stack) {
        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topologicalSortUtil(graph, e.dest, visited, stack);
            }
        }
        stack.push(curr);
    }

    // O(V+E)
    public static void topologicalSort (ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topologicalSortUtil(graph, i, visited, stack);
            }
        }

        // stack contains all nodes in topological order if graph is acyclic
        System.out.println("Is cycle = "+(stack.size() != graph.length));

        while(!stack.isEmpty()) {
            System.out.print(" " + stack.pop());
        }
    }

    public static void calcInDegree (ArrayList<Edge>[] graph, int[] inDegree) {
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDegree[e.dest]++;
            }
        }
    }

    public static void topologicalSortBFS (ArrayList<Edge>[] graph){
        int[] inDegree = new int[graph.length];
        
        Queue<Integer> queue = new LinkedList<>();
        calcInDegree(graph, inDegree);

        for(int i=0; i<inDegree.length; i++) {
            // i = vertex
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.remove();

            System.out.print(" " + node);
            for(int i = 0; i < graph[node].size(); i++) {
                // iterate for all neighbors
                Edge e = graph[node].get(i);
                inDegree[e.dest]--;
                if (inDegree[e.dest] == 0) {
                    queue.add(e.dest);
                }
            }
        }

    }


    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V]; // null is stored currently

        createGraph(graph);
        // topologicalSort(graph);
        topologicalSortBFS(graph);
    }
}