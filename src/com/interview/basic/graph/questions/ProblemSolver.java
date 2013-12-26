package com.interview.basic.graph.questions;

import com.interview.basic.graph.Searcher;
import com.interview.basic.graph.model.Graph;
import com.interview.basic.graph.model.Processor;

public abstract class ProblemSolver implements Processor{
	protected Searcher searcher;
	protected Graph g;
	public int count;
	public boolean isBreak;
	
	public ProblemSolver(Graph g){
		this.g = g;
		count = 1;
	}
	
	public void solve(){
		for (int v = 0; v < g.V; v++){
			if (!searcher.isMarked(v)){
				searcher.search(v, this);
				count++;
			}
			clean();
			if(isBreak){
				break;
			}
		}
	}

	protected void clean() {
		// TODO Auto-generated method stub
		
	}
}
