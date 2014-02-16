package com.interview.basic.string.sort;

public class LSDSorter {
	
	public static String[] sort(String[] strlist){
		int length = strlist[0].length();
		String[] aux = new String[strlist.length];
		KeyIndexedSorter sorter = new KeyIndexedSorter(KeyIndexedSorter.CHARSET);
		for(int i = length - 1; i >= 0; i--){
			sorter.sort(strlist, aux, i);
		}
		return strlist;
	}
}
