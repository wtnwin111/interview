package com.interview.utils;

import java.util.Set;

public class ConsoleWriter {

	public static void printIntArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

    public static void printIntArray(int[][] array) {
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j< array.length; j ++)
                System.out.print("\t" + array[i][j]);
            System.out.println();
        }
    }
    
    public static void printIntSet(Set<Integer> set){
    	for(Integer i : set){
			System.out.print(i + " ");
		}
		System.out.println();
    }
    
}
