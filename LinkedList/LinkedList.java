import java.util.*;

public class LinkedList {

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

    public void size (){
        Node temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        System.out.println("size = "+size);
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
    
    public int removeLast(){
        if (head == null){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        } else {
            Node prev = head;
            for(int i = 0; i < size-2; i++) {
                prev = prev.next;
            }
            int val = tail.data;
            prev.next = null;
            tail = prev;
            size--;
            return val;
        }
    }

    public int helper (Node head, int key){
        if (head == null) return -1;

        if (head.data == key) return 0;
        // 0 bcz acc to current Node, it is the HEAD & head is @ index=0
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }

    public void recSearch (int key){
        System.out.println("found at index : " + helper(head,key));
    }

    public void reverse (){
        Node prev = null;
        Node curr = tail = head;
        // head is assgined to tail -> tail is asinged to curr : right to left asignment

        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // last me prev last node pe rahega
        head = prev;
    }

    public void delFromEnd (int n){
        int size = 0;
        Node temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        if (n == size) {
            head = head.next;
            return;
        }

        int iToDel = size-n;
        Node prev = head;
        for(int i = 1; i < iToDel; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return ;

    }       

    // SLOW-FAST APPROACH
    public Node findMid (){
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            // 1st condition is for EVEN no. of nodes & 2nd condition is for ODD no. of nodes
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // this is the mid node
    }

    public boolean checkPallindrome (){
        if (head == null || head.next == null) return true;

        // 1. find middle node
        Node mid = findMid();

        // 2. reverse second half
        Node prev = null, curr = mid, next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;  // last me prev last node pe rahega
        Node left = head;

        // 3. compare both halves
        while(right != null) {
            if (left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }
        return true;

    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(2);
        ll.addFirst(1);
        // ll.addFirst(5);
        // ll.size();
        // ll.removeLast();
        // ll.printll(); 
        // ll.recSearch(3);
        ll.reverse();
        ll.printll(); 
        // ll.delFromEnd(2);
        ll.printll(); 
        boolean isPallindrome = ll.checkPallindrome();
        System.out.println(isPallindrome);
    }
}
