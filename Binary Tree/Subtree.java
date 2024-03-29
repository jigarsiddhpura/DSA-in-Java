import java.util.*;

public class Subtree {
    static class Node{
        int data;
        Node left, right;
        Node (int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    public static boolean isIdentical (Node node, Node subRoot){
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root1, Node root2) {
        if (root1 == null) return false;

        if (root1.data == root2.data) {
            if (isIdentical(root1, root2)) return true;
        }

        return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }
    public static void main(String args[]) {
        // main tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // subtree
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));  // should print: true
    }
}