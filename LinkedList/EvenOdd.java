import java.util.*;

public class EvenOdd {
    
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head, tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            // Ensure newNode.next points to the old head, not itself
            newNode.next = head;
            head = newNode;
        }
    }
    
    public void printll() {
        if (head == null) {
            System.out.println("ll is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            // Move to the next node, not the same node again
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println("");
    }

    public void evenodd (){
        Node oddHead = new Node(-1); 
        Node evenTail = head, oddTail = oddHead, evenPrev = null;
        
        while(evenTail != null) {
            if (evenTail.data %2 != 0) {
                oddTail.next = evenTail;
                oddTail = oddTail.next;
                evenPrev.next = evenTail.next.next;
            }
            evenPrev = evenTail;
            evenTail = evenTail.next;
        }

    }

    public static void main(String args[]) {
        EvenOdd ll = new EvenOdd();
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printll();
        ll.evenodd();
        ll.printll();
    }
}