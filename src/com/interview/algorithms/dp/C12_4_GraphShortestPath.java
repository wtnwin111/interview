package com.interview.algorithms.dp;

import com.interview.datastructures.graph.weighted.Edge;
import com.interview.datastructures.graph.weighted.Graph;
import com.interview.datastructures.graph.weighted.Vertex;

import java.util.*;

/**
 * Created_By: zouzhile
 * Date: 3/17/14
 * Time: 4:19 PM
 *
 * [top coder] Given an undirected graph G having N (1<N<=1000) vertices and positive weights.
 * Find the shortest path from vertex 1 to vertex N, or state that such shortestPath doesn't exist.
 */
public class C12_4_GraphShortestPath {

    class State {
        int weight = Integer.MAX_VALUE;
        String previous = null;
    }
    class Result{
        int weight = Integer.MAX_VALUE;
        List<String> path = new ArrayList<String>();
    }
    class IndexedNode implements Comparable<IndexedNode>{
        Vertex vertex;
        State state;

        public IndexedNode(Vertex vertex, State state){
            this.vertex = vertex;
            this.state = state;
        }
        @Override
        public int compareTo(IndexedNode node) {
            return this.state.weight - node.state.weight;
        }
    }
    public Result findShortestPath(Graph graph, String from, String to) {
        Map<String, State> optimal = new HashMap<String, State>();
        Set<String> visited = new HashSet<String>();
        Vertex fromVertex = graph.getVertex(from);
        State s = new State();
        s.weight = 0;
        optimal.put(from, s); // from to from itself is zero weight

        PriorityQueue<IndexedNode> queue = new PriorityQueue<IndexedNode>();
        queue.add(new IndexedNode(fromVertex, s));

        while(!queue.isEmpty()) {       //Graph BFS search, current use PriorityQueue to get the shortest node first.
                IndexedNode current = queue.poll();
                if(! visited.contains(current.vertex.getValue())) {
                    // for each current vertex, we need to check on each adj vertex to
                    // update the optimal, no matter the adj vertex is visited or not.
                    for(Edge edge : graph.getEdges(current.vertex)) {
                        Vertex adj = edge.getTarget();

                        State state = optimal.get(adj.getValue());
                        if(state == null) {
                            state = new State(); // weight is Integer.MAX_VALUE;
                        }

                        if((current.state.weight + edge.getWeight()) < state.weight) {
                            // update the smallest weight and path
                            state.weight = current.state.weight + edge.getWeight();
                            state.previous = current.vertex.getValue();
                        }
                        optimal.put(adj.getValue(), state);

                        if(! visited.contains(adj))
                            queue.add(new IndexedNode(adj, state));
                    }
                    visited.add(current.vertex.getValue());
                }
        }
        return buildResult(optimal, from, to);
    }

    public Result buildResult(Map<String, State> optimal, String from, String to){
        Result result = new Result();
        result.weight = optimal.get(to).weight;
        String current = to;
        while(!from.equals(current)){
            result.path.add(current);
            current = optimal.get(current).previous;
        }
        result.path.add(from);
        return result;
    }
}
