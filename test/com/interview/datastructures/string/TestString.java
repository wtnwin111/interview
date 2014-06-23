package com.interview.datastructures.string;

import junit.framework.Assert;

import org.junit.Test;

import com.interview.datastructures.string.sort.KeyIndexedSorter;
import com.interview.datastructures.string.sort.LSDSorter;
import com.interview.datastructures.string.sort.MSDSorter;
import com.interview.util.TestUtil;

public class TestString {
	@Test
	public void testReverse(){
		String str = TestUtil.generateString();
		System.out.println("Source String: " + str);
		String reverse = BasicOp.reverse(str);
		System.out.println("Reverse String: " + reverse);
		for(int i = 0; i < str.length(); i++){
			Assert.assertEquals(str.charAt(i), reverse.charAt(str.length() - i - 1));
		}
	}
	
	@Test
	public void testSuffixes(){
		String str = TestUtil.generateString();
		System.out.println("Source String: " + str);
		String[] suffiexs = BasicOp.suffixes(str);
		for(String suff : suffiexs){
			System.out.println("Suffixes String: " + suff);
		}
	}
	
	@Test
	public void testLCP(){
		String str1 = TestUtil.generateString();
		System.out.println("Generate String Str1: " + str1);
		String str2 = TestUtil.generateString();
		System.out.println("Generate String Str2: " + str2);
		int len = BasicOp.lcp(str1, str2);
		System.out.println("LCP is: " + len);
	}
	
	@Test
	public void testKeyIndexedSorter(){
		char[] charlist = TestUtil.generateCharArray(30, 26);
		System.out.println("Generate Charlist: " + new String(charlist));
		
		KeyIndexedSorter sorter = new KeyIndexedSorter(KeyIndexedSorter.CHARSET);
		sorter.sort(charlist);
		System.out.println("Key Indexed Sort Result Charlist: " + new String(charlist));
	}
	
	@Test
	public void testLSDSorter(){
		String[] strlist = TestUtil.generateSameLengthString(10, 50);
		System.out.println("Generate String List: ");
		for(int i = 0; i < 50; i ++){
			System.out.println(strlist[i]);
		}
		
		LSDSorter.sort(strlist);
		
		System.out.println("Sorted String List: ");
		for(int i = 0; i < 50; i ++){
			System.out.println(strlist[i]);
		}
	}
	
	@Test
	public void testMSDSorter(){
		String[] strlist = TestUtil.generateSameLengthString(10, 50);
		System.out.println("Generate String List: ");
		for(int i = 0; i < 50; i ++){
			System.out.println(strlist[i]);
		}
		
		MSDSorter.sort(strlist);
		
		System.out.println("Sorted String List: ");
		for(int i = 0; i < 50; i ++){
			System.out.println(strlist[i]);
		}
	}
}
