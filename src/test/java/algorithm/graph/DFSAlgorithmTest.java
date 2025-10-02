package algorithm.graph;

import org.junit.jupiter.api.Test;

class DFSAlgorithmTest {

    @Test
    void dfsTest() {
        Graph graph = new Graph(10);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 8);
        graph.addEdge(6, 7);
        graph.addEdge(8, 9);
        /*
                5 - 8 - 9
              /
        1 - 2 - 4 - 6 - 7
          \
            3
         */
        new DFSAlgorithm().dfs(1, graph);
        //One possibility -> 1 2 4 6 7 5 8 9 3
    }
}