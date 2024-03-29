import java.util.*;

public class PriorityQ_Objects {
    static class Student implements Comparable<Student> {
        // now to define the logic of comparison
        String name;
        int rank;

        Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        // overriding the compare function to define the logic of comparsion for student object
        @Override
        public int compareTo (Student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String args[]) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("A",23));
        pq.add(new Student("B",12));
        pq.add(new Student("C",40));

        while(!pq.isEmpty()) {
            System.out.println("Removed:"+ pq.peek().name);
            pq.remove();
        }
    }
}