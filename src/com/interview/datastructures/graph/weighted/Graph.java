package com.interview.datastructures.graph.weighted;

import java.util.*;

/**
 * Created_By: zouzhile
 * Date: 3/16/14
 * Time: 9:34 AM
 */
public class Graph {

    HashMap<String, Vertex> vertexes = new HashMap<>();
    HashMap<String, List<Edge>> outs = new HashMap<>();

    public static Graph buildWeightedDAG() {
/*
        A      B
        ]     / \ 3
        |  6 /   ]
    40  |   /    C
        |  /     /9
        | [     [
        E [--- D
           19
*/
        Graph graph = new Graph();
        graph.vertexes.put("A", new Vertex("A"));
        graph.vertexes.put("B", new Vertex("B"));
        graph.vertexes.put("C", new Vertex("C"));
        graph.vertexes.put("D", new Vertex("D"));
        graph.vertexes.put("E", new Vertex("E"));

        Edge BC = new Edge(graph.vertexes.get("B"), graph.vertexes.get("C"), 3);
        Edge BE = new Edge(graph.vertexes.get("B"), graph.vertexes.get("E"), 6);
        List<Edge> outs = new ArrayList<>();
        outs.add(BC);
        outs.add(BE);
        graph.outs.put("B", outs);

        Edge CD = new Edge(graph.vertexes.get("C"), graph.vertexes.get("D"), 9);
        outs = new ArrayList<>();
        outs.add(CD);
        graph.outs.put("C", outs);

        Edge DE = new Edge(graph.vertexes.get("D"), graph.vertexes.get("E"), 19);
        outs = new ArrayList<>();
        outs.add(DE);
        graph.outs.put("D", outs);

        Edge EA = new Edge(graph.vertexes.get("E"), graph.vertexes.get("A"), 40);
        outs = new ArrayList<>();
        outs.add(EA);
        graph.outs.put("E", outs);
        return graph;
    }

    public static Graph buildSampleGraph(boolean isDirected) {
/*         2
        A ---] B
        ]     /] \ 3
        |  6 / |  ]
    40  |   /  |7  C
        |  /   |  /9
        | [    | [
        E [---- D
           19
*/
        Graph graph = new Graph();
        graph.vertexes.put("A", new Vertex("A"));
        graph.vertexes.put("B", new Vertex("B"));
        graph.vertexes.put("C", new Vertex("C"));
        graph.vertexes.put("D", new Vertex("D"));
        graph.vertexes.put("E", new Vertex("E"));

        Edge AB = new Edge(graph.vertexes.get("A"), graph.vertexes.get("B"), 2);
        List<Edge> outs = new ArrayList<>();
        outs.add(AB);
        if(! isDirected) {
            Edge AE = new Edge(graph.vertexes.get("A"), graph.vertexes.get("E"), 40);
            outs.add(AE);
        }
        graph.outs.put("A", outs);

        Edge BC = new Edge(graph.vertexes.get("B"), graph.vertexes.get("C"), 3);
        Edge BE = new Edge(graph.vertexes.get("B"), graph.vertexes.get("E"), 6);
        outs = new ArrayList<>();
        outs.add(BC);
        outs.add(BE);
        if(! isDirected) {
            Edge BA = new Edge(graph.vertexes.get("B"), graph.vertexes.get("A"), 2);
            Edge BD = new Edge(graph.vertexes.get("B"), graph.vertexes.get("D"), 7);
            outs.add(BA);
            outs.add(BD);
        }
        graph.outs.put("B", outs);

        Edge CD = new Edge(graph.vertexes.get("C"), graph.vertexes.get("D"), 9);
        outs = new ArrayList<>();
        outs.add(CD);
        if(! isDirected) {
            Edge CB = new Edge(graph.vertexes.get("C"), graph.vertexes.get("B"), 3);
            outs.add(CB);
        }
        graph.outs.put("C", outs);

        Edge DB = new Edge(graph.vertexes.get("D"), graph.vertexes.get("B"), 7);
        Edge DE = new Edge(graph.vertexes.get("D"), graph.vertexes.get("E"), 19);
        outs = new ArrayList<>();
        outs.add(DB);
        outs.add(DE);
        if(! isDirected) {
            Edge DC = new Edge(graph.vertexes.get("D"), graph.vertexes.get("C"), 9);
            outs.add(DC);
        }
        graph.outs.put("D", outs);

        Edge EA = new Edge(graph.vertexes.get("E"), graph.vertexes.get("A"), 40);
        outs = new ArrayList<>();
        outs.add(EA);
        if(! isDirected) {
            Edge EB = new Edge(graph.vertexes.get("E"), graph.vertexes.get("B"), 6);
            Edge ED = new Edge(graph.vertexes.get("E"), graph.vertexes.get("D"), 19);
            outs.add(EB);
            outs.add(ED);
        }
        graph.outs.put("E", outs);

        return graph;
    }

    public Vertex getVertex(String value) {
        return this.vertexes.get(value);
    }

    public Iterator<Vertex> vertexes(){
        return this.vertexes.values().iterator();
    }

    public List<Edge> getEdges(Vertex v) {
        return this.outs.get(v.getValue());
    }

    public HashMap<String, List<Edge>> getAllEdges() {
        return this.outs;
    }
}
