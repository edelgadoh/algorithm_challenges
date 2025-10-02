package algorithm.graph;

import org.junit.jupiter.api.Test;

class BFSAlgorithmTest {

    @Test
    void bfsTest() {
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
        new BFSAlgorithm().bfs(1, graph);
        //One possibility -> 1 2 3 4 5 6 8 7 9

    }
}