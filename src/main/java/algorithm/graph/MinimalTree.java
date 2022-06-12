package algorithm.graph;

public class MinimalTree {

    public static BinaryTreeNode buildMinimalSearchTree(int[] array) {
        if (array == null || array.length == 0) return null;
        return buildMinimalSearchTree(0, array.length - 1, array);
    }

    private static BinaryTreeNode buildMinimalSearchTree(int start, int end, int[] array) {
        if (end < start) return null;
        int middle = (start + end) / 2;
        BinaryTreeNode node = new BinaryTreeNode(array[middle], null, null);
        node.left = buildMinimalSearchTree(start, middle - 1, array);
        node.right = buildMinimalSearchTree(middle + 1, end, array);
        return node;
    }

}
