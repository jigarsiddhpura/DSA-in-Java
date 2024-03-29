import java.util.*;

public class Swap2Nodes {
    
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

    public void swap (int x, int y){
        Node currX = head, prevX = null;
        Node currY = head, prevY = null;

        while(currX != null && currX.data != x){
            prevX = currX;
            currX = currX.next;
        }

        while(currY != null && currY.data != y){
            prevY = currY;
            currY = currY.next;
        }

        if (prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }

        if (prevY != null) {
            prevY.next = currX;
        } else {
            head = currX;
        }

        Node next = currX.next;
        currX.next = currY.next;
        currY.next = next;
    }

    public static void main(String args[]) {
        Swap2Nodes ll = new Swap2Nodes();
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printll();
        ll.swap(2,5);
        ll.printll();
    }
}