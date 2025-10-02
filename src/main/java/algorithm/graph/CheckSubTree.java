package algorithm.graph;

public class CheckSubTree {
    public static boolean check(BinaryTreeNode node1, BinaryTreeNode node2) {
        if (node2 == null) return true;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        inOrder(node1, sb1);
        inOrder(node2, sb2);
        return sb1.toString().contains(sb2.toString());
    }

    private static void inOrder(BinaryTreeNode node, StringBuilder stringBuilder) {
        if (node == null) {
            stringBuilder.append("|");
            return;
        }
        stringBuilder.append(node.data);
        inOrder(node.left, stringBuilder);
        inOrder(node.right, stringBuilder);
    }
}
