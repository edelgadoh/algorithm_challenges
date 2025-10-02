package algorithm.graph;

import java.util.Iterator;

public class GraphTree {

    public static boolean isCycleUtil(Graph graph, int v, Boolean visited[], int parent) {
        visited[v] = true;
        int i;

        Iterator<Integer> it = graph.getAdjacencyListByNode(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                if (isCycleUtil(graph, i, visited, v)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }

        }
        return false;
    }

    public static boolean isTree(Graph graph) {
        int v = graph.getNodes();
        Boolean[] visited = new Boolean[v];
        for (int i = 0; i < v; i++) {
            visited[i] = false;
        }

        if (isCycleUtil(graph, 0, visited, -1)) {
            return false;
        }

        for (int u = 0; u < v; u++) {
            if (!visited[u]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        if (GraphTree.isTree(graph)) {
            System.out.println("Graph is tree");
        } else {
            System.out.println("Graph is not a tree");
        }

        Graph graph2 = new Graph(5);
        graph2.addEdge(1, 0);
        graph2.addEdge(0, 2);
        graph2.addEdge(2, 1);
        graph2.addEdge(0, 3);
        graph2.addEdge(3, 4);
        if (GraphTree.isTree(graph2)) {
            System.out.println("Graph is tree");
        } else {
            System.out.println("Graph is not a tree");
        }

    }

}
