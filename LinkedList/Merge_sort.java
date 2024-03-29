import java.util.*;

public class Merge_sort {

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

  private Node merge(Node head1, Node head2) {
    Node dummy = new Node(-1);
    Node current = dummy;

    while (head1 != null && head2 != null) {
      if (head1.data < head2.data) {
        current.next = head1;
        head1 = head1.next;
      } else {
        current.next = head2;
        head2 = head2.next;
      }
      current = current.next;
    }

    while (head1 != null) {
      current.next = head1;
      head1 = head1.next;
      current = current.next;
    }

    while (head2 != null) {
      current.next = head2;
      head2 = head2.next;
      current = current.next;
    }

    return dummy.next;
  }

  public Node mergeSort(Node head) {
    if (head == null || head.next == null) return head;

    // find mid
    Node mid = getMid(head);
    Node rightHead = mid.next;
    mid.next = null;
    // Recursively sort two halves
    Node newLeft = mergeSort(head);
    Node newRight = mergeSort(rightHead);

    return merge(newLeft, newRight);
  }

  public static void main(String args[]) {
    Merge_sort ll = new Merge_sort();
    ll.addFirst(1);
    ll.addFirst(2);
    ll.addFirst(3);
    ll.addFirst(4);
    ll.printll();

    ll.head = ll.mergeSort(ll.head);
    ll.printll();
  }
}
