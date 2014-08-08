package com.interview.utils;

import com.interview.basics.model.collection.list.LinkedList;
import com.interview.basics.model.collection.list.Node;

import java.util.Set;

public class ConsoleWriter {

	public static void printIntArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

    public static void printIntArray(Integer[] array){
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

    public static void printLinkedList(LinkedList list){
        Node node = list.getHead();
        while(node != null){
            System.out.print(node.item.toString() + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void printBooleanArray(boolean[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
}
