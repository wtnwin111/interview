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
	
	@Test
	public void testMergeSort(){
		Sorter sorter = new MergeSorter();
		int[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
		System.out.print("Merge Sort Result:\t");
		ConsoleWriter.printIntArray(sortedArray);
	}
	
	@Test
	public void testQuickSort(){
		Sorter sorter = new QuickSorter();
		int[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
		System.out.print("Quick Sort Result:\t");
		ConsoleWriter.printIntArray(sortedArray);
	}
	
	@Test
	public void testHeapUpSort(){
		Sorter sorter = new HeapSorter();
		int[] array = new int[] {66, 32, 73, 32, 50, 33, 30, 16, 40, 21};
		int[] sortedArray = sorter.sort(array);
		System.out.print("Heap Up Sort Result:\t");
		ConsoleWriter.printIntArray(sortedArray);
	}
	
	@Test
	public void testHeapDownSort(){
		HeapSorter sorter = new HeapSorter();
		sorter.up = false;
		int[] array = new int[] {66, 32, 73, 32, 50, 33, 30, 16, 40, 21};
		int[] sortedArray = sorter.sort(array);
		System.out.print("Heap Down Sort Result:\t");
		ConsoleWriter.printIntArray(sortedArray);
	}
}
