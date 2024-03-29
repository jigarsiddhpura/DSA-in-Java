import java.util.*;

public class k_nearest_cars {
    static class Point implements Comparable<Point> {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point p2) {
            return this.dist - p2.dist;
        }
    }
    public static void main(String args[]) {
        int[][] points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i = 0; i < points.length; i++) {
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.add(new Point(points[i][0], points[i][1], dist));
        }

        for(int i = 0; i < k; i++) {
            Point p = pq.remove();
            System.out.println("C(" + p.x + ", " + p.y + ") dist: " + p.dist + " ");
        }
    }
}