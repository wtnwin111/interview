package com.interview.datastructures.graph.questions;

import java.util.Stack;

import com.interview.datastructures.graph.model.DFSearcher;
import com.interview.datastructures.graph.model.Graph;
/**
 * Run depth-first search. Return vertices in reverse postorder
 * @author stefanie
 *
 */
public class TopologicalSorter extends ProblemSolver{
	Stack<Integer> stack = new Stack<Integer>();
	CycleFinder cycleFinder ;

	public TopologicalSorter(Graph g) {
		super(g);
		searcher = new DFSearcher(g);
		cycleFinder = new CycleFinder(g);
		cycleFinder.solve();
	}

	@Override
	public void preProcess(int v) {
		
	}

	@Override
	public void postProcess(int v) {
		stack.add(v);
	}

	public String getOrder(){
		StringBuilder builder = new StringBuilder();
		while(!stack.isEmpty()){
			builder.append(stack.pop() + "-");
		}
		return builder.toString();
	}
	
	public boolean canSort(){
		return (cycleFinder.getCycle() == null) ? true : false;
	}
	
	public String why(){
		return cycleFinder.getCycle();
	}

	@Override
	protected void clean() {
//		if(searcher.allMarked()){
//			this.isBreak = true;
//		} //else {
//			stack.clear();
//			searcher.cleanPath();
//			searcher.cleanMark();
//		}
	}
}
