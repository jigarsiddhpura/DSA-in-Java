import java.util.*;

public class CheapestFlightWithinKStops {
    static class Edge {
        int src, dest, weight;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void createGraph (int[][] flights, ArrayList<Edge> graph[]) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < flights.length; i++) {
            int[] e = flights[i];
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            graph[src].add(new Edge(src, dest, wt));
        }
    }

    static class Info {
        int n, cost, stops;

        public Info(int n, int cost, int stops) {
            this.n = n;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        // implemented using Dijkstra's algorithm with modification 
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(src, 0, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while(!queue.isEmpty()) {
            Info curr = queue.remove();
            if (curr.stops > k) break;

            for(int i = 0; i < graph[curr.n].size(); i++) {
                Edge e = graph[curr.n].get(i);
                int u = e.src;
                int v = e.dest;
                int w = e.weight;

                if (dist[v] > curr.cost + w && curr.stops <= k) { 
                    // curr.cost alias of dist[u] bcz dist[u] will be the min. dist. from src to u but we want the curr parent (u) ka dist (cost) from src ⭐⭐⭐
                    dist[v] = curr.cost + w;
                    queue.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }

        return (dist[dest] == Integer.MAX_VALUE) ? -1 : dist[dest];
    }
    public static void main(String args[]) {
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int k = 1, src = 0, dest = 3, n = 4;
        int ans = findCheapestPrice(n, flights, src, dest, k);
        System.out.println(ans);
    }
}