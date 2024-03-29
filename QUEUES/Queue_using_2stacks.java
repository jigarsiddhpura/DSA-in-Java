import java.util.*;

public class Queue_using_2stacks {
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();  
        static Stack<Integer> s2 = new Stack<>();  

        public static boolean isEmpty (){
            return s1.isEmpty();
        }   

        public static int remove (){ // O(1)
            if(isEmpty())  {
                System.out.println("Queue is Empty"); 
                return -1;
            }
            else {
                return s1.pop();
            }
        }       

        public static void add (int data){ // O(N)
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }
    public static void main(String args[]) {
        Queue q = new Queue();
        q.add(1);
        q.add(3);
        q.add(5);
        q.add(7);
        while (!q.isEmpty() ) {
            System.out.print(q.remove() + " ");
        }
    }
}