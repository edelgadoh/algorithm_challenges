package algorithm.graph;

import java.util.Deque;
import java.util.LinkedList;

public class TreeOperation {
    public static BinaryTreeNode insert(BinaryTreeNode node, int value) {
        if (node == null) {
            node = new BinaryTreeNode(value, null, null);
            return node;
        }

        BinaryTreeNode temporalNode = node;
        while (temporalNode != null) {
            if (value < temporalNode.data) {
                if (temporalNode.left != null) {
                    temporalNode = temporalNode.left;
                } else {
                    temporalNode.left = new BinaryTreeNode(value, null, null);
                    break;
                }
            } else {
                if (temporalNode.right != null) {
                    temporalNode = temporalNode.right;
                } else {
                    temporalNode.right = new BinaryTreeNode(value, null, null);
                    break;
                }
            }
        }
        return node;
    }

    public static String preOrder(BinaryTreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Deque<BinaryTreeNode> stack = new LinkedList<>();

        stack.addLast(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pollLast();
            sb.append(node.data);
            sb.append(" ");
            if (node.right != null) stack.addLast(node.right);
            if (node.left != null) stack.addLast(node.left);
        }
        return sb.toString().trim();
    }

    public static String postOrder(BinaryTreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();

        Deque<BinaryTreeNode> stack = new LinkedList<>();
        BinaryTreeNode lastVisited = null;
        BinaryTreeNode node = root;

        while (!stack.isEmpty() || node != null) {

            if (node != null) {
                stack.addLast(node);
                node = node.left;
            } else {
                BinaryTreeNode peekNode = stack.peekLast();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    node = peekNode.right;
                } else {
                    sb.append(peekNode.data);
                    sb.append(" ");
                    lastVisited = stack.pollLast();
                }
            }

        }
        return sb.toString().trim();
    }

    public static String inOrder(BinaryTreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();

        Deque<BinaryTreeNode> stack = new LinkedList<>();
        BinaryTreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                node = stack.pollLast();
                sb.append(node.data);
                sb.append(" ");
                node = node.right;
            }
        }
        return sb.toString().trim();
    }

    public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, int a, int b) {
        BinaryTreeNode node = root;
        while (node != null) {
            if (a < node.data && b < node.data) {
                node = node.left;
            } else if (a > node.data && b > node.data) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;

    }

    public static int level(BinaryTreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(level(root.left), level(root.right));
    }

    public static int height(BinaryTreeNode root) {
        return level(root) - 1;
    }
}
