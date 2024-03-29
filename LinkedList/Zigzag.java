import java.util.*;

public class Zigzag {
    
  public static class Node {

    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node head, tail;

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

    
  private Node getMid(Node head) {
    Node slow = head;
    Node fast = head.next; // appended .next bcz bcz for case of even no. of nodes , i want the slow ptr to be at the last node of 1st half and not at the 1st node of 2nd half

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public void zigzag (Node head){
    // get mid 
    Node mid = getMid(head);

    // reverse 2nd half
    Node prev = null, curr = mid.next;
    mid.next = null;
    Node next;
    while(curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    Node right = prev, left = head;
    Node nextL, nextR;
    // zigzag merge

    while(left != null && right != null) {
        nextL = left.next;
        left.next = right;
        nextR = right.next;
        right.next = nextL;

        left = nextL;
        right = nextR;
    }
  }

    public static void main(String args[]) {
        Zigzag ll = new Zigzag();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.printll();

        ll.zigzag(head);
        ll.printll();
    }
}