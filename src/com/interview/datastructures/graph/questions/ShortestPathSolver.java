package com.interview.datastructures.graph.questions;

import com.interview.basics.model.graph.searcher.BFSearcher;
import com.interview.basics.model.graph.Graph;

public class ShortestPathSolver extends ProblemSolver{
	private int source;
	private int target;
	private int step = 0;
	private String path;

	public ShortestPathSolver(Graph g) {
		super(g);
		searcher = new BFSearcher(g);
	}
	
	
	public void solve(int s, int t) {
		this.source = s;
		this.target = t;
		searcher.search(s, this);
	}



	@Override
	public void preProcess(int v) {
		if(v == this.target){
			searcher.setBreak(true);
			int s = searcher.getPrevious(v);
			StringBuilder builder = new StringBuilder();
			builder.append(v);
			while(s != -1){
				step ++;
				builder.append("-" + s);
				s = searcher.getPrevious(s);
			}
			path = builder.toString();
		}
	}
	
	

	public int getStep() {
		return step;
	}


	public String getPath() {
		return path;
	}
	
	


	public int getSource() {
		return source;
	}


	public int getTarget() {
		return target;
	}


	@Override
	public void postProcess(int v) {
		// TODO Auto-generated method stub
		
	}

}
