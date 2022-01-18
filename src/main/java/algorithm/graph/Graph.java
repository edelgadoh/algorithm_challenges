package algorithm.graph;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Graph {
    private int nodes;
    private LinkedList<Integer>[] adjacencyList;

    @SuppressWarnings("unchecked")
    Graph(int v) {
        nodes = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
    }

    public List<Integer> getAdjacencyListByNode(Integer node) {
        return adjacencyList[node];
    }

}
