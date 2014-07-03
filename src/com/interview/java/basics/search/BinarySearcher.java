package com.interview.java.basics.search;

import com.interview.java.basics.sort.QuickSorter;

public class BinarySearcher extends Searcher{
	static QuickSorter SORTER = new QuickSorter();

	public BinarySearcher(int[] input) {
		//sort before set
		super(input);
//		this.input = SORTER.sort(input);
		// TODO Auto-generated constructor stub
	}

	
	public int searchIterative(int item) {
		int N = this.input.length - 1;
		int k = N/2;
		while(true){
			int ck = k;
			if(k <= 0 || k >= N) 		return -1;
			else if(input[k] == item)	return k;
			else if(input[k] < item)	k = k/2;
			else k = k + (N-k)/2;
			N = ck;
		}
	}
	
	@Override
	public int search(int item){
		return search(item, 0, input.length - 1);
	}
	
	public int search(int item, int lo, int hi){
		if(hi < lo) return -1;
		int mid = lo + (hi - lo)/2;
		if(input[mid] == item) 		return mid;
		else if(input[mid] > item)	return search(item, lo, mid - 1);
		else return search(item, mid + 1, hi);
	}
	
}
