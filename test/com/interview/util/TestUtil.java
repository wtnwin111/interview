package com.interview.util;

import java.util.Random;

public class TestUtil {
	public static final Random RAND = new Random();
	/**
	 * random generate sample int array
	 */
	public static int[] generateIntArray(int size, int max, int min){
		if(size <= 0){
			return new int[0];
		} else {
			int[] array = new int[size];
			for(int i = 0; i < size; i++){
				int randomNum = RAND.nextInt((max - min) + 1) + min;
				array[i] = randomNum;
			}
			return array;
		}
	}
	
	/**
	 * return a copy of the input array
	 * @param array
	 * @return
	 */
	public static int[] copyArray(int[] array){
		int[] copiedArray = new int[array.length];
		for(int i = 0; i < array.length; i++){
			copiedArray[i] = array[i];
		}
		return copiedArray;
	}
	
}
