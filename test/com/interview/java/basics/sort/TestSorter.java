package com.interview.java.basics.sort;

import com.sun.tools.corba.se.idl.InterfaceGen;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;

import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;

public class TestSorter extends TestCase {
	public static Integer[] testArray;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testArray = TestUtil.generateIntArray(10, 100, 0);
		//System.out.print("Generate Array:\t\t");
		//ConsoleWriter.printIntArray(testArray);
	}
	

	@Test
	public void testSelectSort() {
		Sorter<Integer> sorter = new SelectSorter<Integer>();
		Integer[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
        assertOrder(sortedArray);
	}
	
	@Test
	public void testInsertSort(){
		Sorter<Integer> sorter = new InsertSorter<Integer>();
		Integer[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
        assertOrder(sortedArray);
	}
	
	@Test
	public void testShellSort(){
		Sorter<Integer> sorter = new ShellSorter<Integer>();
		Integer[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
        assertOrder(sortedArray);
	}
	
	@Test
	public void testMergeSort(){
		Sorter<Integer> sorter = new MergeSorter<Integer>();
		Integer[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
        assertOrder(sortedArray);
	}
	
	@Test
	public void testQuickSort(){
		Sorter<Integer> sorter = new QuickSorter<Integer>();
		Integer[] sortedArray = sorter.sort(TestUtil.copyArray(testArray));
        assertOrder(sortedArray);
	}
	
	@Test
	public void testHeapUpSort(){
		Sorter<Integer> sorter = new HeapSorter<Integer>();
		Integer[] array = new Integer[] {66, 32, 73, 32, 50, 33, 30, 16, 40, 21};
		Integer[] sortedArray = sorter.sort(array);
        assertOrder(sortedArray);
	}
	
	@Test
	public void testHeapDownSort(){
		HeapSorter<Integer> sorter = new HeapSorter<Integer>();
		sorter.up = false;
		Integer[] array = new Integer[] {66, 32, 73, 32, 50, 33, 30, 16, 40, 21};
		Integer[] sortedArray = sorter.sort(array);
        assertOrder(sortedArray);
	}

    private void assertOrder(Integer[] array){
        for(int i = 0; i < array.length - 1; i++){
            assertTrue(array[i] <= array[i + 1]);
        }
    }
}
