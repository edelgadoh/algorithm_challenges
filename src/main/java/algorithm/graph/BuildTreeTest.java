package algorithm.graph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BuildTreeTest {

	public static class Node {
		int index;
		int value;
		Node left = null;
		Node right = null;

		Node(int value, int index) {
			this.value = value;
			this.index = index;
			this.left = null;
			this.right = null;
		}

		public String toString() {
			return "v=" + this.value;
		}

	}

	static Node buildTree(int[][] indexes) {
		Node root = new Node(1, 0);
		int localIndex = 0;
		for (int i = 0; i < indexes.length; i++) {
			Node node = findNode(root, i);
			if (indexes[i][0] != -1) {
				Node left = new Node(indexes[i][0], ++localIndex);
				node.left = left;
			}
			if (indexes[i][1] != -1) {
				Node right = new Node(indexes[i][1], ++localIndex);
				node.right = right;
			}
		}
		return root;
	}

	static Node findNode(Node node, int index) {
		if (node.index == index)
			return node;
		Node t = null;
		if (node.left != null)
			t = findNode(node.left, index);
		if (t == null && node.right != null)
			t = findNode(node.right, index);
		return t;
	}

	static List<Node> getNodes(Node root, int level) {
		List<Node> list1 = new ArrayList<>();
		List<Node> list2 = new ArrayList<>();
		list1.add(root);
		int localLevel = 1;
		while (localLevel < level) {
			for (Node n : list1) {
				if (n.left != null)
					list2.add(n.left);
				if (n.right != null)
					list2.add(n.right);
			}
			list1.clear();
			list1.addAll(list2);
			list2.clear();
			localLevel++;
		}
		return list1;
	}

	static int[] getInOrder(Node root) {
		List<Integer> list = new ArrayList<>();
		LinkedList<Node> stack = new LinkedList<>();

		Node current = root;

		while (stack.size() > 0 || current != null) {
			if (current != null) {
				stack.addLast(current);
				current = current.left;
			} else {
				current = stack.pollLast();
				list.add(current.value);
				current = current.right;
			}
		}

		int[] response = new int[list.size()];
		for (int i = 0; i < response.length; i++) {
			response[i] = list.get(i);
		}

		return response;

	}

	/*
	 * Complete the swapNodes function below.
	 */
	static int[][] swapNodes(int[][] indexes, int[] queries) {
		/*
		 * Write your code here.
		 */
		int[][] response = new int[queries.length][];

		Node root = buildTree(indexes);

		for (int i = 0; i < queries.length; i++) {

			int level = queries[i];
            int iteration = 1;
            while(true){
                List<Node> nodeList = getNodes(root, level*iteration);
                if(nodeList.size() == 0) break;
                for(Node n: nodeList){
                    Node temp = n.right;
                    n.right = n.left;
                    n.left = temp;
                }
                iteration++;
            }
            int[] localResult = getInOrder(root);
            response[i] = localResult;    

		}

		return response;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/tmp"));

		int n = Integer.parseInt(scanner.nextLine().trim());

		int[][] indexes = new int[n][2];

		for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
			String[] indexesRowItems = scanner.nextLine().split(" ");

			for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
				int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
				indexes[indexesRowItr][indexesColumnItr] = indexesItem;
			}
		}

		int queriesCount = Integer.parseInt(scanner.nextLine().trim());

		int[] queries = new int[queriesCount];

		for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
			int queriesItem = Integer.parseInt(scanner.nextLine().trim());
			queries[queriesItr] = queriesItem;
		}

		int[][] result = swapNodes(indexes, queries);

		for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
			for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
				bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));
				System.out.print(String.valueOf(result[resultRowItr][resultColumnItr])+" ");

				if (resultColumnItr != result[resultRowItr].length - 1) {
					bufferedWriter.write(" ");
				}
			}

			if (resultRowItr != result.length - 1) {
				bufferedWriter.write("\n");
				System.out.println();
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();
	}

}

/*
17
2 3
4 5
6 -1
-1 7
8 9
10 11
12 13
-1 14
-1 -1
15 -1
16 17
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
2
2
3

Your Output (stdout)
14 8 5 9 2 4 13 7 12 1 3 10 15 6 17 11 16
9 5 14 8 2 13 7 12 4 1 3 17 11 16 6 10 15
Expected O

 */