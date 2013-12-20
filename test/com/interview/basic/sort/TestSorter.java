package com.interview.basic.sort;

import org.junit.BeforeClass;
import org.junit.Test;

import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;

public class TestSorter {
	public static int[] testArray;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testArray = TestUtil.generateIntArray(10, 100, 0);
		System.out.print("Generate Array:\t\t");
		ConsoleWriter.printIntArray(testArray);
	}
	

	@Test
	public void testSelectSort() {
		Sorter sorter = new SelectSorter();
		int[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
		System.out.print("Select Sort Result:\t");
		ConsoleWriter.printIntArray(sortedArray);
	}
	
	@Test
	public void testInsertSort(){
		Sorter sorter = new InsertSorter();
		int[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
		System.out.print("Insert Sort Result:\t");
		ConsoleWriter.printIntArray(sortedArray);
	}
	
	@Test
	public void testShellSort(){
		Sorter sorter = new ShellSorter();
		int[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
		System.out.print("Shell Sort Result:\t");
		ConsoleWriter.printIntArray(sortedArray);
	}

}
