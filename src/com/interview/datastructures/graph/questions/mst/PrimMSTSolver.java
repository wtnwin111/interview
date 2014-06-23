package com.interview.datastructures.graph.questions.mst;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

import com.interview.datastructures.graph.model.WeightedGraph;
import com.interview.datastructures.graph.model.WeightedGraph.Edge;

/**
 * Basic Idea: 
 * 		Start with vertex 0 and greedily grow tree T.
 * 		Add to T the min weight edge with exactly one endpoint in T.
 * 		Repeat until V - 1 edges.
 * @author stefanie
 *
 */
public class PrimMSTSolver extends MSTSolver{
	private boolean[] marked;
	private PriorityQueue<Edge> pq;

	public PrimMSTSolver(WeightedGraph g) {
		super(g);
	}

	@Override
	public void solve() {
		mst = new ArrayDeque<Edge>();
		marked = new boolean[g.V];
		pq= new PriorityQueue<Edge>();
		visit(0);
		while(!pq.isEmpty()){
			Edge e = pq.poll();
			if(marked[e.s] && marked[e.t])	continue;
			mst.add(e);
			weight += e.w;
			if(!marked[e.s]) visit(e.s);
			if(!marked[e.t]) visit(e.t);
		}
	}
	
	private void visit(int v){
		marked[v] = true;
		if(g.adj[v] != null){
			for(Edge e : g.adj[v]){
				if(!marked[e.t]) pq.add(e);
			}
		}
		
	}

}
