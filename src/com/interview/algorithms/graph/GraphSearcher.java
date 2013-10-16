package com.interview.algorithms.graph;

import com.interview.datastructures.graph.AdjListGraph;
import com.interview.datastructures.graph.Graph;
import com.interview.datastructures.graph.Vertex;
import com.interview.datastructures.graph.VertexColor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created_By: zouzhile
 * Date: 9/23/13
 * Time: 5:05 PM
 */

public class GraphSearcher {

    public Graph generateSampleGraph(int type){
        /*
        1 ---- 2
        |     /| \
        |    / |  \
        |   /  |   3
        |  /   |  /
        | /    | /
        5 ----- 4
         */
        Graph graph = new AdjListGraph(type);

        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);
        Vertex three = new Vertex(3);
        Vertex four = new Vertex(4);
        Vertex five = new Vertex(5);

        graph.addEdge(one, two);
        graph.addEdge(one, five);
        graph.addEdge(two, five);
        graph.addEdge(two, four);
        graph.addEdge(two, three);
        graph.addEdge(three, four);
        graph.addEdge(four, five);
        return graph;
    }

    // do depth first search
    public void DFS(Graph graph) {
        for(Vertex vertex : graph.vertexs())
            if(vertex.getColor() == VertexColor.WHITE)
                DFS(graph, vertex);
    }

    public void DFS(Graph graph, Vertex vertex) {
        vertex.setColor(VertexColor.GRAY);
        for(Vertex adj : graph.adj(vertex)) {
            if(adj.getColor() == VertexColor.WHITE)
                DFS(graph, adj);
        }
        System.out.println(vertex.getValue());
        vertex.setColor(VertexColor.BLACK);
    }

    public void BFS(Graph graph) {
        for(Vertex vertex : graph.vertexs())
            if(vertex.getColor() == VertexColor.WHITE)
                BFS(graph, vertex);
    }

    public void BFS(Graph graph, Vertex source) {
        List<Vertex> queue = new ArrayList<Vertex>();
        source.setColor(VertexColor.GRAY);
        queue.add(source);
        while(! queue.isEmpty()) {
            Vertex v = queue.remove(0);
            Iterable<Vertex> adjacentVertex = graph.adj(v);
            if(adjacentVertex != null) {
                Iterator<Vertex> adjcentVertexItr = adjacentVertex.iterator();
                while(adjcentVertexItr.hasNext()) {
                    Vertex adj = adjcentVertexItr.next();
                    if(adj.getColor() ==  VertexColor.WHITE){
                        adj.setColor(VertexColor.GRAY);
                        queue.add(adj);
                    }
                }
            }
            System.out.println(v.getValue());
            v.setColor(VertexColor.BLACK);
        }

    }

    public static void main(String[] args) {
        GraphSearcher searcher = new GraphSearcher();

        System.out.println("Undirected Graph - BFS");
        Graph graph = searcher.generateSampleGraph(Graph.UNDIRECTED);
        searcher.BFS(graph, graph.getVertex(1));

        System.out.println();

        System.out.println("Undirected Graph - DFS");
        graph = searcher.generateSampleGraph(Graph.UNDIRECTED);
        searcher.DFS(graph, graph.getVertex(1));
    }

}
