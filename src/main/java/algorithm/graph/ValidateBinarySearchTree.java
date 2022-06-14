package algorithm.graph;

public class ValidateBinarySearchTree {
    public static boolean validate(BinaryTreeNode node) {
        return validate(node, null, null);
    }

    private static boolean validate(BinaryTreeNode node, Integer minValue, Integer maxValue) {
        if (node == null) return true;
        if ((minValue != null && minValue > node.data) || (maxValue != null && maxValue < node.data)) {
            return false;
        }
        if (!validate(node.left, minValue, node.data)) return false;
        if (!validate(node.right, node.data, maxValue)) return false;
        return true;
    }
}
