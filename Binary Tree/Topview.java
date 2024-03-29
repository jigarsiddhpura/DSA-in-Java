import java.util.*;

public class Topview {
    static class Node{
        int data;
        Node left, right;
        Node (int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    static class Info {
        Node node;
        int hd; // horizontal dist

        public Info (Node _node, int _hd){
            this.node = _node;
            this.hd = _hd;
        }
    }
    public static void topview(Node root) {
        Map<Integer,Node> map = new HashMap<>();
        int min = 0, max = 0;

        if (root == null) return;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root,0));
        q.add(null);  // indicates the end of one level

        while(!q.isEmpty()) {
            Info popped  = q.remove();
            if (popped == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);  // indicate start of next level
                }
            } else {
                if (!map.containsKey(popped.hd)) {
                    map.put(popped.hd, popped.node);
                }
    
                if (popped.node.left != null) {
                    q.add(new Info(popped.node.left, popped.hd-1));
                    min = Math.min(min, popped.hd-1);
                }
                if (popped.node.right != null) {
                    q.add(new Info(popped.node.right, popped.hd+1));
                    max = Math.max(max, popped.hd+1);
                }
            }
        }
        
        for(int i = min; i <= max; i++) {
            System.out.print(map.get(i).data+" ");
        }
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

        topview(root);
    }
}