package com.interview.algorithms.string;

import com.interview.utils.ConsoleReader;

/**
 * Given a string array, find the max common part of all string elements.
 * E.g. the max common string of ["abcde", "abccd", "abc", abcef"] is "abc"
 * This checks basic programming using loop
 * 
 * @author zouzhile (zouzhile@gmail.com)
 *
 */
public class C11_8_MaxCommonStringSearch {
	
	public String findMaxCommonString(String[] elements){
		boolean stop = false;
		int offset = 0;
		String maxCommon = "";
		while (!stop){
			String common = "";
			for(String element: elements){
				if (common == "" && offset < element.length()){
					common = element.substring(offset, offset + 1);
				} else if (element.length() == offset  || 
						!common.equals(element.substring(offset, offset + 1))){
					stop = true;
					break;
				} 				
			}
			if(!stop){
				maxCommon += common;
				offset ++;
			}
		}
		return maxCommon;
	}
	
	public static void main(String[] args){
		System.out.println("Search Max Common String");
		System.out.println("===============================================================================");
		ConsoleReader reader = new ConsoleReader();
		String[] elements = reader.readStringItems();
		C11_8_MaxCommonStringSearch searcher = new C11_8_MaxCommonStringSearch();
		String maxCommonString = searcher.findMaxCommonString(elements);
		System.out.println("Max Common String is: " + maxCommonString);
	}
}
