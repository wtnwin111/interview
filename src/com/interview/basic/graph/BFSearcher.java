package com.interview.basic.graph;

import java.util.ArrayDeque;
import java.util.Queue;

import com.interview.basic.graph.model.Graph;
import com.interview.basic.graph.model.Processor;

public class BFSearcher extends Searcher {
	private Queue<Integer> queue;
	
	public BFSearcher(Graph g){
		super(g);
		init();
		queue = new ArrayDeque<Integer>();
	}
	
	public void search(int s, Processor p){
		queue.add(s);
		bfsInner(p);
	}
	
	public void bfsInner(Processor p){
		while(!queue.isEmpty()){
			int s = queue.poll();
			if(marked[s]) continue;
			if(p != null){
				p.process(s);
			}
			marked[s] = true;
			if(g.adj[s] != null){
				for(int t : g.adj[s]){
					if(!marked[t]){
						queue.add(t);
						edges[t] = s;
					}
				}
			}
		}
	}
}
