import java.util.*;

public class CircularQ {
    static class Queue {
        static int[] arr;
        static int rear, front, size;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty (){
            return  (rear == -1 && front == -1);
        }

        public static boolean isFull (){
            return  ((rear+1)%size == front);
        }

        public static void add (int data){
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            
            if (front == -1){ // add 1st element
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int remove (){
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int res = arr[front];
            
            if (front == rear) { // del last elem
                rear = front = -1;
            } else {
                front  = (front + 1) % size;
            }
            return res;
        }
    }
    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(3);
        q.add(5);
        q.add(7);
        while (!q.isEmpty() ) {
            System.out.print(q.remove() + " ");
        }
    }
}