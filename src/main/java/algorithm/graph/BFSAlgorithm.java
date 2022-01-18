package algorithm.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class BFSAlgorithm {

    public void bfs(Integer v, Graph g) {
        boolean[] visited = new boolean[g.getNodes()];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            Integer s = queue.poll();
            log.info(String.format("Node visited: %d", s));

            for (Integer i : g.getAdjacencyListByNode(s)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }

        }

    }

}
