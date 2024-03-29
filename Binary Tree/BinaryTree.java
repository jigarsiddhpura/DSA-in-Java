import java.util.*;

public class BinaryTree {
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

        public static void preOrder (Node root){
            if (root == null) return;

            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder (Node root){
            if (root == null) return;

            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public static void postOrder (Node root){
            if (root == null) return;

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelOrder (Node root){
            // BFS
            if (root == null) return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);  // indicates the end of one level

            while(!q.isEmpty()) {
                Node popped  = q.remove();
                if (popped == null) {
                    System.out.println("");
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);  // indicate start of next level
                    }
                } else {
                    System.out.print(popped.data+" ");

                    if (popped.left != null) q.add(popped.left);
                    if (popped.right != null) q.add(popped.right);
                }
            
            }
        }   

        public static int height(Node node) {
            if (node == null) return 0;

            int leftH = height(node.left);
            int rightH = height(node.right);
            int maxH = Integer.max(leftH, rightH) + 1;

            return maxH;
        }

        public static int nodeCount(Node node) {
            if (node == null) return 0;

            int leftC = nodeCount(node.left);
            int rightC = nodeCount(node.right);

            return leftC + rightC + 1;
        }

        public static int nodeSum(Node node) {
            if (node == null) return 0;

            int leftS = nodeSum(node.left);
            int rightS = nodeSum(node.right);

            return leftS + rightS + node.data;
        }


    }
    public static void main(String args[]) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BTree tree = new BTree();
        Node root = tree.buildTree(nodes);

        System.out.println(root.data);

        tree.preOrder(root);
        tree.inOrder(root);
        tree.postOrder(root);
        tree.levelOrder(root);
        System.out.println("Height of tree = "+ tree.height(root));
        System.out.println("Count of nodes = "+ tree.nodeCount(root));
        System.out.println("sum of nodes = "+ tree.nodeSum(root));
    }
}