package com.interview.datastructures.sort;

public class MergeSorter extends Sorter{

	@Override
	public int[] sort(int[] input) {
		int N = input.length;
		int[] aux = new int[N];
		sort(input, aux, 0, N-1);
		return input;
	}

	private void sort(int[] input, int[] aux, int lo, int hi) {
		if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(input, aux, lo, mid);
        sort(input, aux, mid + 1, hi);
        merge(input, aux, lo, mid, hi);
	}

	private void merge(int[] input, int[] aux, int lo, int mid, int hi) {
		//copy input array to aux
		for(int k = lo; k <= hi; k++){
			aux[k] = input[k];
		}
		int i = lo, j = mid + 1;
		for(int k = lo; k <= hi; k++){
			if      (i > mid)           input[k] = aux[j++];	//left part is all copied, still copy right part
            else if (j > hi)            input[k] = aux[i++];	//right part is all copied, still copy left part
            else if (aux[j] < aux[i]) 	input[k] = aux[j++];	//right element is smaller, copy right part
            else   						input[k] = aux[i++];	//left element is smaller, copy left part
		}
		
	}

}
