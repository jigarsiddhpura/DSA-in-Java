import java.util.*;

public class BinaryTree3 {
    static class Node{
        int data;
        Node left, right;
        Node (int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    public static void k_level_iterative (Node root, int k){ // O(N)
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(k != 0) {
            Node popped = q.remove();
            if (popped == null) {
                if (q.isEmpty()) {
                    System.out.println("\nk level not found");
                    break; // end of tree
                } else {
                    q.add(null);
                    k--;
                }
            } else {
                if (k==1) System.out.print(popped.data+" ");
                if (popped.left != null) q.add(popped.left);
                if (popped.right != null) q.add(popped.right);
            }
        }
    }
    public static void k_level_rec (Node root, int k){ // O(N)
        if (k==1) {
            System.out.print(root.data + " ");
            return; // bcz we have printed the node at current level so no need to go further in that branch
        }
        k_level_rec(root.left , k-1);
        k_level_rec(root.right , k-1);
    }
    public static boolean get_path (Node root, int n, ArrayList<Node> path){
        if (root == null) return false;

        path.add(root); // initially add the root in path later remove if its not the ancestor

        if (root.data == n) return true;

        boolean foundleft = get_path(root.left, n, path);
        boolean foundright = get_path(root.right, n, path);

        if (foundleft || foundright) return true; // n is either in left or right subtree

        // n is not in left not right subtree then remove that root
        path.remove(path.size() - 1);
        return false;
    }
    public static Node lowest_common_ancestor_brute_force (Node root, int p, int q){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        get_path(root, p, path1);
        get_path(root, q, path2);

        int i=0;
        
        for(; i<path1.size() && i<path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        Node lca = path1.get(i-1);
        return lca;
    }   
    public static Node lowest_common_ancestor_approach2 (Node root, int p, int q){
        if (root == null || root.data == p || root.data == q) return root;

        Node left = lowest_common_ancestor_approach2(root.left, p, q);
        Node right = lowest_common_ancestor_approach2(root.right, p, q);

        if (left != null && right != null) return root; // case 1

        return (left != null) ? left : right;

    }
    public static int getDist (Node root, int n){
        if (root == null) return -1;

        if (root.data == n) return 0;

        int leftD = getDist(root.left, n);
        int rightD = getDist(root.right, n);

        if (leftD == -1 && rightD == -1) return -1; // case 1 : n is not in left not right subtree

        return (leftD != -1) ? (leftD+1) : (rightD+1); // case 2 :  n is present in left or right subtree
    }   
    public static int min_dist_btw_2_nodes (Node root, int p, int q){
        Node lca = lowest_common_ancestor_approach2(root, p, q);

        int dist1 = getDist(lca, p);
        int dist2 = getDist(lca, q);

        return  dist1 + dist2;
    }
    public static int find_kth_ancestor (Node root, int p, int k){ // p ka kth ancestor find krna hai
        if (root == null) return -1;
        if (root.data == p) return 0;

        int leftD = find_kth_ancestor(root.left, p, k);
        int rightD = find_kth_ancestor(root.right, p, k);

        if (leftD == -1 && rightD == -1) return -1; // case 1 : n is not in left not right subtree

        int max = Math.max(leftD, rightD);
        if (max+1 == k) {
            System.out.println("kth ancestor = "+root.data);
        }
        return max+1;

    }   
    public static int transform_2_sum_tree (Node root){
        if (root == null) return 0;

        int leftSum = transform_2_sum_tree(root.left);
        int rightSum = transform_2_sum_tree(root.right);

        int temp = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = leftSum + rightSum + newLeft + newRight; // ⭐⭐
        return temp;
    }   
    public static void preOrder (Node root){
        if (root == null) return;

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
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

        // k_level_iterative(root,2);
        // System.out.println("");
        // k_level_rec(root,2);

        System.out.println("LCA OF 4 & 5 = "+lowest_common_ancestor_brute_force(root, 4, 5).data);
        System.out.println("LCA OF 4 & 5 = "+lowest_common_ancestor_approach2(root, 4, 5).data);
        System.out.println("MIN DIST BTW 4 & 7 = "+min_dist_btw_2_nodes(root, 4, 7));
        find_kth_ancestor(root, 4, 2);
        transform_2_sum_tree(root);
        preOrder(root);
    }
}