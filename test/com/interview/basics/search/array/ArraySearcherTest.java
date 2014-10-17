package com.interview.basics.search.array;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

public class ArraySearcherTest extends TestCase {
    public static Integer[] testArray = new Integer[]{87, 1, 25, 23, 20, 86, 76, 92, 17, 31, 78, 56, 0, 31, 90, 88, 53, 24, 62, 26};
    //TestUtil.generateIntArray(20, 100, 0);

    public void testQuickSelect(){
        ConsoleWriter.printIntArray(testArray);
        QuickSelectSearcher<Integer> searcher = new QuickSelectSearcher<>(testArray);
        Integer expected = testArray[6];
        Integer actual = searcher.find(expected);
        assertEquals(expected, actual);
        assertNull(searcher.find(32));
    }
}