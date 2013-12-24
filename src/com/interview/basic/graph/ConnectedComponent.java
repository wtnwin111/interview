package com.interview.basic.graph;

import java.util.HashSet;
import java.util.Set;

import com.interview.basic.graph.model.Graph;
import com.interview.basic.graph.model.Processor;

public class ConnectedComponent implements Processor{
	private Graph g;
	public int[] flag;
	public Set<Integer>[] components;
	public int count;
	private DFSearcher searcher;
	
	public ConnectedComponent(Graph g){
		flag = new int[g.V];
		count = 1;
		this.g = g;
		searcher = new DFSearcher(g);
	}
	
	@SuppressWarnings("unchecked")
	public void find(){
		for (int v = 0; v < g.V; v++){
			if (!searcher.isMarked(v)){
				searcher.search(v, this);
				count++;
			}
		}
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
	public void process(int v) {
		flag[v] = count;
	}
}
