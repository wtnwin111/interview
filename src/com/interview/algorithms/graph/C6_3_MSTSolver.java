package com.interview.algorithms.graph;

import java.util.Queue;

import com.interview.basics.model.graph.WeightedGraph;
import com.interview.basics.model.graph.WeightedGraph.Edge;

public abstract class C6_3_MSTSolver {
	protected WeightedGraph g;
	protected Queue<Edge> mst;
	protected double weight;
	
	public C6_3_MSTSolver(WeightedGraph g){
		this.g = g;
	}
	
	public abstract void solve();
	
	public Iterable<Edge> getMST(){
		return mst;
	}
	
	public double weight(){
		return weight;
	}
}
