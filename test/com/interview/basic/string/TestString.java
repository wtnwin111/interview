package com.interview.basic.string;

import junit.framework.Assert;

import org.junit.Test;

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
}
