import java.util.*;

public class QueueB {
    static class Queue {
        static int[] arr;
        static int rear, size;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty (){
            return  (rear == -1);
        }

        public static void add (int data){
            if (rear == size-1) {
                System.out.println("Queue is Full");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        public static int remove (){
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int front = arr[0];
            for(int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
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