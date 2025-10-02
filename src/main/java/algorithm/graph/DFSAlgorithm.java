package algorithm.graph;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DFSAlgorithm {


    public void dfs(Integer v, Graph g) {
        boolean[] visited = new boolean[g.getNodes()];
        dfsRecursive(v, g, visited);
    }

    public void dfsRecursive(Integer v, Graph g, boolean[] visited) {

        visited[v] = true;
        log.info(String.format("Node visited: %d", v));

        for (Integer i : g.getAdjacencyListByNode(v)) {
            if (!visited[i]) {
                dfsRecursive(i, g, visited);
            }
        }

    }

}
