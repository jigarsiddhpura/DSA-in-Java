import java.util.*;

public class ConnectingCities {
    static class Edge implements Comparable<Edge>{
        int dest, cost;

        public Edge (int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        }
    }

    public static int ConnectCities (int[][] cities){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));

        boolean[] visited = new boolean[cities.length];
        int finalCost = 0;

        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (!visited[curr.dest]) {
                visited[curr.dest] = true;
                finalCost += curr.cost;

                for(int i = 0; i < cities[0].length; i++) {
                    if (cities[curr.dest][i] != 0) { // if edge exists add neighbor in queue
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }

        return finalCost;
    }



    public static void main(String args[]) {
        int cities[][] = {{0,1,2,3,4}, {1,0,5,0,7}, {2,5,0,6,0}, {3,0,6,0,0}, {4,7,0,0,0}};
        ArrayList<Edge> graph[] = new ArrayList[cities.length]; // null is stored currently

        int ans = ConnectCities(cities);
        System.out.println("Minimum cost: " + ans);
    }
}