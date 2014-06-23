package com.interview.datastructures.string.sort;

public class MSDSorter {
	
	public static String[] sort(String[] strlist){
		String[] aux = new String[strlist.length];
		KeyIndexedSorter sorter = new KeyIndexedSorter(KeyIndexedSorter.CHARSET);
		sorter.sort(strlist, aux, 0, strlist.length - 1, 0);
		return strlist;
	}
}
