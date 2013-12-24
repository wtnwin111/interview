package com.interview.basic.graph;

import com.interview.basic.graph.model.Graph;
import com.interview.basic.graph.model.Processor;

public class DFSearcher extends Searcher{
	
	public DFSearcher(Graph g){
		super(g);
		init();
	}
	
	public void search(int s, Processor p){
		dfsInner(s, p);
	}
	
	public void dfsInner(int s, Processor p){
		if(p != null){
			p.process(s);
		}
		marked[s] = true;
		if(g.adj[s] != null){
			for(int t : g.adj[s]){
				if(!marked[t]){
					dfsInner(t, p);
					edges[t] = s;
				}
			}
		}
	}
	
}
