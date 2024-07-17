import java.util.*;

public class Dijikstra {
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

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair>{
        int n; // node
        int dist; // distance from src

        public Pair(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;
        }

    }

    public static void dijikstra (ArrayList<Edge> graph[], int src){
        int[] dist = new int[graph.length]; // distance from src
        for(int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.n]) {
                visited[curr.n] = true;
                for(int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int w = e.weight;

                    if (dist[v] > dist[u] + w) {
                        dist[v] = dist[u] + w;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for(int i = 0; i < dist.length-1; i++) {
            System.out.println("Dist from " + src + " to " + i + " is " + dist[i]);
        }

    }



    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V]; // null is stored currently

        createGraph(graph);
        dijikstra(graph, 0);
    }
}