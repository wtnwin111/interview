package com.interview.algorithms.graph;

import com.interview.basics.model.graph.WeightedGraph;
import com.interview.basics.model.graph.WeightedGraph.Edge;
import com.interview.basics.model.graph.searcher.IndexedPriorityQueue;

import java.util.Stack;

/**
 * Dijkstra Algorithm: Dynamic Programming
 * Can represent the SPT with two vertex-indexed arrays:
 * 		distTo[v] is length of shortest path from s to v.
 * 		edgeTo[v] is last edge on shortest path from s to v.
 * 
 * dist(s, t) = min(dist(s, t') + weight(t', t))
 * 
 * @author stefanie
 *
 */
public class C6_5_WeightedShortestPathSolver {
	WeightedGraph g;
	double[] distTo;
	Edge[] edgeTo;
	IndexedPriorityQueue<Integer, Double> pq;



	public C6_5_WeightedShortestPathSolver(WeightedGraph g){
		this.g = g;
		distTo = new double[g.V];
		edgeTo = new Edge[g.V];
		pq = new IndexedPriorityQueue<Integer, Double>();
		for(int i = 0; i < g.V; i++){
			distTo[i] = Double.POSITIVE_INFINITY;
		}
	}
	
	public void solve(int s){
		distTo[s] = 0.0;
		pq.add(s, 0.0);
		while(!pq.isEmpty()){
			relax(pq.poll());
		}
	}
	
	private void relax(int s) {
		if(g.adj[s] != null){
			for(Edge e : g.adj[s]){
				if(distTo[e.t] > distTo[s] + e.w){
					distTo[e.t] = distTo[s] + e.w;
					edgeTo[e.t] = e;
					if(pq.contains(e.t))	pq.update(e.t, distTo[e.t]);
					else 					pq.add(e.t, distTo[e.t]);
				}
			}
		}
	}

	public double distTo(int v){
		return distTo[v];
	}
	
	public boolean hasPathTo(int v){
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	
	public Iterable<Edge> pathTo(int v){
		if(!hasPathTo(v))	return null;
		Stack<Edge> path = new Stack<Edge>();
		for(Edge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.s]){
			path.push(edge);
		}
		return path;
	}
}
