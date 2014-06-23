package com.interview.datastructures.sort;

public class ShellSorter extends Sorter{

	@Override
	public int[] sort(int[] input) {
		int N = input.length;
		// 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
        int h = 1;
        while (h < N/3) h = 3*h + 1; 

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && (input[j]<input[j-h]); j -= h) {
                    swap(input, j, j-h);
                }
            }
            h /= 3;
        }
        return input;
	}

}
