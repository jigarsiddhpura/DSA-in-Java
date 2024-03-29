import java.util.*;

public class BinaryTree2 {
    static class Node{
        int data;
        Node left, right;
        Node (int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    static class BTree {
        static int idx = -1;

        public static Node buildTree (int[] nodes){
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        } 

        public static int height(Node node) {
            if (node == null) return 0;

            int leftH = height(node.left);
            int rightH = height(node.right);
            int maxH = Integer.max(leftH, rightH) + 1;

            return maxH;
        }

        public static int diameter (Node root){  // O(N^2)
            if (root == null) return 0;

            int lDiam = diameter(root.left);
            int rDiam = diameter(root.right);

            int lH = height(root.left);
            int rH = height(root.right);

            int selfDiam = lH + rH + 1;

            return Math.max(Math.max(lDiam, rDiam), selfDiam);
        }

        static class Info {
            int diam, ht;

            public Info (int _diam, int _ht){
                this.diam = _diam;
                this.ht = _ht;
            }   
        }

        public static Info diameter2 (Node root){ // O(N)
            if (root == null) return new Info(0,0);

            Info lInfo =  diameter2(root.left);
            Info rInfo =  diameter2(root.right);

            int diam = Math.max(Math.max(lInfo.diam, rInfo.diam), lInfo.ht + rInfo.ht + 1);
            int ht =  Math.max(lInfo.ht, rInfo.ht) + 1;

            return new Info(diam, ht);
        }



    }
    public static void main(String args[]) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BTree tree = new BTree();
        Node root = tree.buildTree(nodes);

        System.out.println("diamter of tree = "+tree.diameter(root));
        System.out.println("diamter2 of tree = "+tree.diameter2(root).diam);

    }
}