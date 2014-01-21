package com.interview.basic.graph.questions.mst;

import java.util.Queue;

import com.interview.basic.graph.model.WeightedGraph;
import com.interview.basic.graph.model.WeightedGraph.Edge;

public abstract class MSTSolver {
	protected WeightedGraph g;
	protected Queue<Edge> mst;
	protected double weight;
	
	public MSTSolver(WeightedGraph g){
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
