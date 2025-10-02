package algorithm.graph;

public class BalancedTree {

    public int isBalanced(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = isBalanced(root.left);
        if (leftH == -1) {
            return -1;
        }

        int rightH = isBalanced(root.right);
        if (rightH == -1) {
            return -1;
        }

        int diff = leftH - rightH;
        if (Math.abs(diff) > 1) {
            return -1;
        }
        return 1 + Math.max(leftH, rightH);

    }

    public static void main(String args[]) {
        BinaryTreeNode root = new BinaryTreeNode(5, null, null);
        root.left = new BinaryTreeNode(10, null, null);
        root.right = new BinaryTreeNode(15, null, null);
        root.left.left = new BinaryTreeNode(20, null, null);
        root.left.right = new BinaryTreeNode(25, null, null);
        root.right.left = new BinaryTreeNode(30, null, null);
        root.right.right = new BinaryTreeNode(35, null, null);
        System.out.println(" Is Tree Balanced : " + (new BalancedTree()).isBalanced(root));
        root.right.right.right = new BinaryTreeNode(40, null, null);
        root.right.right.right.right = new BinaryTreeNode(45, null, null);
        System.out.println(" Is Tree Balanced : " + (new BalancedTree()).isBalanced(root));
    }

}