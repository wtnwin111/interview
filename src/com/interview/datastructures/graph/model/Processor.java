package com.interview.datastructures.graph.model;

public interface Processor {
	public void preProcess(int v);
	
	public void postProcess(int v);
}
