package com.interview.algorithms.graph;

import com.interview.datastructures.graph.AdjListGraph;
import com.interview.datastructures.graph.Graph;

/**
 * Created_By: zouzhile
 * Date: 9/23/13
 * Time: 5:05 PM
 */

public class GraphSearcher {

    /*
        1 ----> 2                 7 -> 9
        |       |                 |    |
         -> 3    -> 4 <- 5 <- 6 <-     |
                              |        |
                               --> 8 <--
     */
    public Graph generateSampleGraph(){
        Graph graph = new AdjListGraph();
        graph.type = Graph.DIRECTED;

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(5, 4);
        graph.addEdge(6, 5);
        graph.addEdge(6, 8);
        graph.addEdge(7, 6);
        graph.addEdge(7, 9);
        graph.addEdge(9, 8);

        return graph;
    }

    public void doDepthFirstSearch(Graph graph) {

    }

    public void doBreadthFirstSearch(Graph graph) {

    }


}
