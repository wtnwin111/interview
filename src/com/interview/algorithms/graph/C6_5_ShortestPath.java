package com.interview.algorithms.graph;

import com.interview.datastructures.graph.weighted.Edge;
import com.interview.datastructures.graph.weighted.Graph;
import com.interview.datastructures.graph.weighted.Vertex;

import java.util.*;

/**
 * http://baike.baidu.com/view/349189.htm
 * Created_By: zouzhile
 * Date: 4/17/14
 * Time: 9:19 PM
 */
public class C6_5_ShortestPath {


    public int Dijkstra(Graph graph, Vertex source, Vertex target) {
        Iterator<Vertex> vertexIterator = graph.vertexes();

        HashMap<Vertex, Integer> pendings = new HashMap<Vertex, Integer>();
        while(vertexIterator.hasNext()) {
            Vertex curr = vertexIterator.next();
            pendings.put(curr, Integer.MAX_VALUE);
        }
        pendings.put(source, 0);

        Set<Vertex> visited = new HashSet<Vertex>();

        while(! pendings.isEmpty()) {
            Vertex current = this.nearestPendingVertex(pendings);
            int nearestDistance = pendings.get(current);
            if(current.equals(target))
                return nearestDistance;

            List<Edge> edges = graph.getEdges(current);
            Iterator<Edge> edgeIterator = edges.iterator();
            while(edgeIterator.hasNext()) {
                Edge edge = edgeIterator.next();
                int weight = edge.getWeight();
                Vertex currTarget = edge.getTarget();
                pendings.put(currTarget, nearestDistance + weight);
            }
            pendings.remove(current);
            visited.add(current);
        }

        return Integer.MAX_VALUE;
    }

    private Vertex nearestPendingVertex(HashMap<Vertex, Integer> pendings) {
        Vertex nearestVertex = null;
        for(Vertex vertex : pendings.keySet()) {
            if(nearestVertex == null) {
                nearestVertex = vertex;
            } else {
                int distance = pendings.get(vertex);
                int nearestDistance = pendings.get(nearestVertex);
                if(distance < nearestDistance)
                    nearestVertex = vertex;
            }
        }
        return nearestVertex;
    }
}
