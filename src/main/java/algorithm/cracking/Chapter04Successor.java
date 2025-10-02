package algorithm.cracking;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;

import static org.apache.commons.lang3.StringUtils.leftPad;
import static org.apache.commons.lang3.StringUtils.rightPad;

public class Chapter04Successor {
    public static void main(String[] args) {

        Chapter04Successor chapter04Successor = new Chapter04Successor();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Node root = chapter04Successor.buildBinarySearchTree(array, 0, array.length - 1, null);
        chapter04Successor.bfsPrint(root);
        System.out.println(chapter04Successor.nextNode(root));

        Node nodeFive = chapter04Successor.bfs(root, 5);
        System.out.println(chapter04Successor.nextNode(nodeFive));

        Node nodeTwelve = chapter04Successor.bfs(root, 12);
        System.out.println(chapter04Successor.nextNode(nodeTwelve));

        Node nodeTen = chapter04Successor.bfs(root, 10);
        System.out.println(chapter04Successor.nextNode(nodeTen));

    }

    private Node nextNode(Node node) {
        if (node != null && node.getRight() != null) {
            return leftMost(node.getRight());
        }
        Node parent = node.getParent();
        Node current = node;
        while(parent != null && parent.getRight() == current){
            parent = parent.getParent();
            current = current.getParent();
        }
        return current.getParent();
    }

    private Node leftMost(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private Node buildBinarySearchTree(int[] array, int start, int end, Node parent) {
        if (end < start) return null;
        int middle = (start + end) / 2;

        Node node = Node.builder().value(array[middle]).parent(parent).build();

        Node left = buildBinarySearchTree(array, start, middle - 1, node);
        Node right = buildBinarySearchTree(array, middle + 1, end, node);
        int height;
        if (left == null && right == null) {
            height = -1;
        } else if (left == null) {
            height = right.getHeight();
        } else if (right == null) {
            height = left.getHeight();
        } else {
            height = Math.max(left.getHeight(), right.getHeight());
        }
        node.setLeft(left);
        node.setRight(right);
        node.setHeight(height + 1);
        return node;
    }

    private Node bfs(Node root, Integer value){
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            Node popped = nodes.pop();
            if(popped.getValue() == value){
                return popped;
            }
            if(popped.getLeft() != null) nodes.add(popped.getLeft());
            if(popped.getRight() != null) nodes.add(popped.getRight());
        }
        return null;
    }

    private void bfsPrint(Node node) {
        TreeMap<Integer, ArrayList<Node>> treeMap = new TreeMap<>(Collections.reverseOrder());
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(node);
        while (!nodes.isEmpty()) {
            Node popped = nodes.pop();
            ArrayList<Node> orDefault = treeMap.getOrDefault(popped.getHeight(), new ArrayList<>());
            orDefault.add(popped);
            treeMap.put(popped.getHeight(), orDefault);
            if (popped.getLeft() != null) nodes.add(popped.getLeft());
            if (popped.getRight() != null) nodes.add(popped.getRight());
        }
        treeMap.values().forEach(x -> {
            x.forEach(y -> System.out.print(
                            leftPad(" ", treeMap.size() * (y.getHeight())) +
                                    y.getValue() +
                                    rightPad(" ", treeMap.size() * (y.getHeight()))
                    )
            );
            System.out.println();
        });
    }


    @Getter
    @Setter
    @Builder
    private static class Node {
        private Integer value;
        private Node left;
        private Node right;
        private Node parent;
        private Integer height;

        @Override
        public String toString(){
            return String.format("%d", value);
        }
    }
}
