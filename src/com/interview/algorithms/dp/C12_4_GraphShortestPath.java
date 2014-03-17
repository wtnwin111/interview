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
        List<String> path = new ArrayList<String>();
    }
    public State findShortestPath(Graph graph, String from, String to) {
        HashMap<String, State> optimal = new HashMap<>();

        Vertex fromVertex = graph.getVertex(from);
        State s = new State();
        s.weight = 0;
        s.path.add(from);
        optimal.put(from, s); // from to from itself is zero weight

        HashSet<Vertex> visited = new HashSet<>();
        HashSet<Vertex> queue = new HashSet<>();


        queue.add(fromVertex);
        while(!queue.isEmpty()) {
            HashSet<Vertex> newMembers = new HashSet<>();
            for(Vertex current : queue) {
                State currState = optimal.get(current.getValue());
                if(! visited.contains(current)) {
                    // for each current vertex, we need to check on each adj vertex to
                    // update the optimal, no matter the adj vertex is visited or not.
                    for(Edge edge : graph.getEdges(current)) {
                        Vertex adj = edge.getTarget();

                        State state = optimal.get(adj.getValue());
                        if(state == null) {
                            state = new State(); // weight is Integer.MAX_VALUE;
                        }

                        if((currState.weight + edge.getWeight()) < state.weight) {
                            // update the smallest weight and path
                            state.weight = currState.weight + edge.getWeight();
                            state.path.clear();
                            for(String value : currState.path)
                                state.path.add(value);
                            state.path.add(adj.getValue());
                        }
                        optimal.put(adj.getValue(), state);

                        if(! visited.contains(adj))
                            newMembers.add(adj);
                    }
                    visited.add(current);
                }
            }
            queue.clear();
            queue.addAll(newMembers);
        }

        State result = optimal.get(to);
        return result;
    }
}
