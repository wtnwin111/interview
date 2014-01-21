package com.interview.basic.search;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;

public class TestSearcher {
	public static int[] testArray;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testArray = TestUtil.generateIntArray(10, 100, 0);
		System.out.print("Generate Array:\t\t");
		ConsoleWriter.printIntArray(testArray);
	}
	
	@Test
	public void testBinarySearcher(){
		BinarySearcher searcher = new BinarySearcher(TestUtil.copyArray(testArray));
		System.out.print("Sorted Array:\t\t");
		ConsoleWriter.printIntArray(searcher.getInput());
		testSearcher(searcher);
	}
	
	@Test
	public void testBSTSearcher(){
		BSTSearcher searcher = new BSTSearcher(TestUtil.copyArray(testArray));
		testSearcher(searcher);
	}
	
	@Test
	public void testRBTSearcher(){
		RBTSearcher searcher = new RBTSearcher(TestUtil.copyArray(testArray));
		testSearcher(searcher);
	}

	public void testSearcher(Searcher searcher) {
		int key = TestUtil.generateInt(100);
		int index = searcher.search(key);
		if(index >= 0){
			System.out.println("Find " + index + " element: " + key);
			Assert.assertEquals(key, searcher.getInput()[index]);
		} else {
			System.out.println("Haven't Find element: " + key);
			for(int i = 0; i < testArray.length; i++){
				Assert.assertNotSame(key, searcher.getInput()[i]);
			}
		}
		
		key = TestUtil.generateInt(testArray.length - 1);
		int value = searcher.getInput()[key];
		System.out.println("Generate " + key + "th element: " + value);
		index = searcher.search(value);
		System.out.println("Find " + index + " element: " + value);
		Assert.assertEquals(value, searcher.getInput()[index]);
		
	}
	
	
}
