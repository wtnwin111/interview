package com.interview.basic.graph.questions;

import java.util.HashSet;
import java.util.Set;

import com.interview.basic.graph.model.DFSearcher;
import com.interview.basic.graph.model.Graph;

public class BiPartiteGraph extends ProblemSolver{
	public boolean[] flag;
	
	public BiPartiteGraph(Graph g){
		super(g);
		searcher = new DFSearcher(g);
		flag = new boolean[g.V];
	}

	@Override
	public void preProcess(int v) {
		int p = searcher.getPrevious(v);
		if(p >= 0){
			flag[v] = !flag[p];
		} else {
			flag[v] = true;
		}
	}
	
	public boolean isBiPartite(){
		for(int w = 0; w < g.V; w++){
			for(int v : g.adj[w]){
				if(flag[w] == flag[v])
					return false;
			}
		}
		return true;
	}
	
	public Set<Integer>[] getBiPartite(){
		@SuppressWarnings("unchecked")
		Set<Integer>[] partition = (Set<Integer>[]) new Set[2];
		for(int i = 0; i < g.V; i++){
			int index = flag[i]? 1: 0;
			Set<Integer> set = partition[index];
			if(set == null){
				set = new HashSet<Integer>();
				partition[index] = set;
			}
			set.add(i);
		}
		return partition;
	}

	@Override
	public void postProcess(int v) {
		// TODO Auto-generated method stub
		
	}
}
