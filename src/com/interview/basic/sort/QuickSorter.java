package com.interview.basic.sort;

import java.util.Random;

public class QuickSorter extends Sorter{

	@Override
	public int[] sort(int[] input) {
		input = shuffle(input);
		sort(input, 0, input.length - 1);
		return input;
	}
	
	private void sort(int[] input, int lo, int hi){
		if(hi <= lo) return;
		//partition array and return the key index
		int key = partition(input, lo, hi);
		//sort the sub array
		sort(input, lo, key - 1);
		sort(input, key + 1, hi);
		
	}
	
	private int partition(int[] input, int lo, int hi){
		int key = input[lo];
		int i = lo, j = hi + 1;
		while(true){
			// find item on lo to swap
			while(input[++i] < key)
				if(i == hi) break;
			// find item on hi to swap
			while(input[--j] > key)
				if(j == lo) break;
			// check if pointers cross
			if (i >= j) break;
			swap(input, i, j);
		}
		//with a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		swap(input, lo, j);
		return j;
	}
	
	private int[] shuffle(int[] input){
		int N = input.length;
		Random random = new Random();
        for (int i = 0; i < N; i++) {
            int r = i + random.nextInt(N-i);     // between i and N-1
            swap(input, i, r);
        }
        return input;
	}

}
