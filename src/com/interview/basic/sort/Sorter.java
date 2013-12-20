package com.interview.basic.sort;
/**
 * sort algorithm interface
 * @author stefanie
 *
 */
public abstract class Sorter {
	/**
	 * sort input int array and return the sorted int array
	 * @param input
	 * @return
	 */
	public abstract int[] sort(int[] input);
	/**
	 * swap the ith and jth element in int array input
	 * @param input
	 * @param i
	 * @param j
	 */
	public static void swap(int[] input, int i, int j){
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
