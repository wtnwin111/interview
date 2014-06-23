package com.interview.algorithms.graph;

import com.interview.datastructures.graph.weighted.Edge;
import com.interview.datastructures.graph.weighted.Graph;
import com.interview.datastructures.graph.weighted.Vertex;

import java.util.*;

/**
 * Created_By: zouzhile
 * Date: 4/20/14
 * Time: 8:04 PM
 */
public class C6_6_TopologicalSorting {

    public List<String> topologicalSort(Graph graph) {
        List<String> result = new ArrayList<String>();

        HashMap<String, List<Edge>> edges = graph.getAllEdges();
        HashMap<String, Integer> inDegrees = new HashMap<String, Integer>();

        // O(V)
        List<String> startingVertexes = new ArrayList<String>();
        Iterator<Vertex> vertexes = graph.vertexes();
        while(vertexes.hasNext())
            startingVertexes.add(vertexes.next().getValue());

        // O(E)
        for(Map.Entry<String, List<Edge>> vertexEdgesEntry : edges.entrySet()) {
            List<Edge> vertexEdges = vertexEdgesEntry.getValue();
            Iterator<Edge> edgeIterator = vertexEdges.iterator();
            while(edgeIterator.hasNext()) {
                Edge edge = edgeIterator.next();
                Vertex target = edge.getTarget();
                String targetVertexName = target.getValue();
                startingVertexes.remove(targetVertexName);
                Integer degrees = inDegrees.get(targetVertexName);
                if(degrees == null)
                    degrees = 0;
                inDegrees.put(targetVertexName, degrees + 1);
            }
        }

        // O(V+E)
        while(! startingVertexes.isEmpty()) {
            Iterator<String> startingVertexesItr = startingVertexes.iterator();
            List<String> toRemove = new ArrayList<String>();
            List<String> toAdd = new ArrayList<String>();

            while(startingVertexesItr.hasNext()) {
                String startingVertex = startingVertexesItr.next();
                toRemove.add(startingVertex);
                result.add(startingVertex);
                List<Edge> outEdges = edges.get(startingVertex);
                if(outEdges != null)
                    for(Edge edge : outEdges) {
                        String target = edge.getTarget().getValue();
                        Integer newDegree = inDegrees.get(target) - 1;
                        inDegrees.put(target, newDegree);
                        if(newDegree == 0) {
                            toAdd.add(target);
                            inDegrees.remove(target);
                        }
                    }
            }

            startingVertexes.removeAll(toRemove);
            startingVertexes.addAll(toAdd);
        }

        return result;
    }
}
