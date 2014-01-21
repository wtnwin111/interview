package com.interview.basic.graph.model;

public interface Processor {
	public void preProcess(int v);
	
	public void postProcess(int v);
}
