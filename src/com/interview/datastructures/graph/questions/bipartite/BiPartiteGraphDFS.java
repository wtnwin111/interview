package com.interview.datastructures.graph.questions.bipartite;

import com.interview.basics.model.graph.searcher.DFSearcher;
import com.interview.basics.model.graph.Graph;

public class BiPartiteGraphDFS extends BiPartiteGraph{
	
	public BiPartiteGraphDFS(Graph g){
		super(g);
		searcher = new DFSearcher(g);
	}

	@Override
	public void preProcess(int v) {
		int p = searcher.getPrevious(v);
		if(p >= 0){
			flags[v] = !flags[p];
		} else {
			flags[v] = true;
		}
	}
}
