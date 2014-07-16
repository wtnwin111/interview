package com.interview.datastructures.graph.questions;

import java.util.HashSet;
import java.util.Set;

import com.interview.basics.model.graph.searcher.DFSearcher;
import com.interview.basics.model.graph.Graph;

public class ConnectedComponent extends ProblemSolver{
	public int[] flag;
	public Set<Integer>[] components;
	
	
	public ConnectedComponent(Graph g){
		super(g);
		flag = new int[g.V];
		searcher = new DFSearcher(g);
	}
	
	@SuppressWarnings("unchecked")
	public void solve(){
		super.solve();
		count --;
		components = (Set<Integer>[]) new Set[count + 1];
		for(int i = 0; i < g.V; i++){
			Set<Integer> set = components[flag[i]];
			if(set == null){
				set = new HashSet<Integer>();
				components[flag[i]] = set;
			}
			set.add(i);
		}
	}
	
	public Set<Integer>[] getComponents() {
		return components;
	}

	@Override
	public void preProcess(int v) {
		flag[v] = count;
	}

	@Override
	public void postProcess(int v) {
		// TODO Auto-generated method stub
		
	}
}
