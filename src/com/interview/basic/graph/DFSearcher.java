package com.interview.basic.graph;

import com.interview.basic.graph.model.Graph;
import com.interview.basic.graph.model.Processor;

public class DFSearcher {
	private Graph g;
	private boolean[] marked;
	private int[] edges;
	private Processor processor;
	
	public DFSearcher(Graph g, Processor processor){
		this.g = g;
		this.processor = processor;
	}
	
	public void dfs(int s){
		marked = new boolean[g.V];
		edges = new int[g.V];
		dfsInner(s);
	}
	
	public void dfsInner(int s){
		if(processor != null){
			processor.process(s);
		}
		marked[s] = true;
		if(g.adj[s] != null){
			for(int t : g.adj[s]){
				if(!marked[t]){
					dfsInner(t);
					edges[t] = s;
				}
			}
		}
	}
	
	public String path(int s, int v){
		dfs(s);
		if(marked[v]){
			StringBuilder builder = new StringBuilder();
			builder.append(v);
			int n = edges[v];
			while(n != s){
				builder.append("-" + n);
				n = edges[n];
			}
			builder.append("-" + s);
			return builder.toString();
		} else {
			return "";
		}
	}

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}
	
	
	
}
