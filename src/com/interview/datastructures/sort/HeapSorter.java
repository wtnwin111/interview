package com.interview.datastructures.sort;

public class HeapSorter extends Sorter{
	//use min head or max head, up=true is max head.
	public boolean up = true;

	public int[] sort(int[] input){
		int N = input.length - 1;
		for(int i = 1; i <= N; i++){
			swim(input, i);
		}
//		for (int k = N/2; k >= 0; k--)
//			sink(input, k, N);
        while (N > 1) {
            swap(input, 0, N--);
            sink(input, 0, N);
        }
        return input;
	}
	
	private void swim(int[] input, int k){
		while(true){
			int p = (k-1)/2;
			if(up){
				if(k <= 0 || p < 0 || input[p] >= input[k]) break;
			} else {
				if(k <= 0 || p < 0 || input[p] <= input[k]) break;
			}
			swap(input, p, k);
			k = p;
		}
	}

	private void sink(int[] input, int k, int n) {
		//index start from 0, so the K -> 2K+1, 2K+2
		while(2*k + 1 < n){
			int j = 2*k + 1;
			if(up){
				if( j + 1 <= n && input[j] < input[j+1]) j++;
				if(input[k] > input[j]) break;
			} else {
				if( j + 1 <= n && input[j] > input[j+1]) j++;
				if(input[k] < input[j]) break;
			}
			
			swap(input, j, k);
			k = j;
		}
	}
	
	
}
