package com.interview.algorithms.array;

public class C4_19_MergeSortedArrays {
	
	public int[] mergeArray(int[] arr1, int[] arr2){
		int[] mergedArray = new int[arr1.length + arr2.length];
		
		int i=0, j=0;
		int k=0;
		for(;i< arr1.length && j < arr2.length; k++){
			
			if(arr1[i] < arr2[j]){
					mergedArray[k] = arr1[i];
					i++;
				}
				else {
					mergedArray[k] = arr2[j];
					j++;
				}
			} 
		if(i < arr1.length){
			for(; i < arr1.length; i++){
				mergedArray[k] = arr1[i];
				i++;
			}
		} else if(j < arr2.length){
			for(; j < arr2.length; j++){
				mergedArray[k] = arr2[j];
				j++;
			}
		}
		
		
		return mergedArray;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1, 2, 5, 10};
		int[] arr2 = {3, 4, 6, 7};
	}

}
