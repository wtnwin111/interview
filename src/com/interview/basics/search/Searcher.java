package com.interview.basics.search;

public abstract class Searcher {
	int[] input;
	
	public Searcher(int[] input){
		this.input = input;
	}
	
	public abstract int search(int item);

	public int[] getInput() {
		return input;
	}
	
}
