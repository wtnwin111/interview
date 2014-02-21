package com.interview.algorithms.graph;

import com.interview.datastructures.graph.AdjListGraph;
import com.interview.datastructures.graph.Graph;
import com.interview.datastructures.graph.Vertex;

import java.util.HashSet;

/**
 * Created_By: zouzhile
 * Date: 2/21/14
 * Time: 7:23 AM
 */
public class C6_3MinimumSpanningTree {

    public void generateMST(Graph graph) {
        HashSet<Vertex> visited = new HashSet<>();
        HashSet<Vertex> candidates = new HashSet<>();

        for(Vertex vertex : graph.vertexs()) {
            if(! visited.contains(vertex)) {
                candidates.add(vertex);
                while(! candidates.isEmpty()) {
                    Vertex currentVertex = candidates.iterator().next();
                    for(Vertex adj : graph.adj(currentVertex)){
                        if(! candidates.contains(adj) && ! visited.contains(adj)) {
                            adj.setParent(currentVertex);
                            System.out.println(currentVertex.getValue() + " -> " + adj.getValue());
                            candidates.add(adj);
                        }
                    }
                    candidates.remove(currentVertex);
                    visited.add(currentVertex);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = generateSampleGraph(Graph.DIRECTED);
        C6_3MinimumSpanningTree gen = new C6_3MinimumSpanningTree();
        gen.generateMST(graph);
    }

    public static Graph generateSampleGraph(int type){
        /*
        1 ---] 2
        ]     /] \
        |    / |  ]
        |   /  |   3
        |  /   |  /
        | [    | [
        5 ----] 4
         */
        Graph graph = new AdjListGraph(type);

        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);
        Vertex three = new Vertex(3);
        Vertex four = new Vertex(4);
        Vertex five = new Vertex(5);

        graph.addEdge(one, two);
        graph.addEdge(two, five);
        graph.addEdge(two, three);
        graph.addEdge(three, four);
        graph.addEdge(four, two);
        graph.addEdge(five, one);
        graph.addEdge(five, four);

        return graph;
    }
}
