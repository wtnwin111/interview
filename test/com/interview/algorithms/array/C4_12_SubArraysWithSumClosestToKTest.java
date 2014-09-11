package com.interview.algorithms.array;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

public class C4_12_SubArraysWithSumClosestToKTest extends TestCase {

    public void testFind() throws Exception {
        int[] array = { 2, 1, 2, 5, 4 };
        boolean[] mark = C4_12_SubArraysWithSumClosestToK.find(array, 7);
        ConsoleWriter.printBooleanArray(mark);
        boolean[] expected = new boolean[]{true, false, false, true, false};
        for(int i = 0; i < expected.length; i++){
            assertEquals(expected[i], mark[i]);
        }
    }

    public void testFind2() throws Exception {
        int[] array = { 2,4,7,9,3,8,5,2,1,4 };
        boolean[] mark = C4_12_SubArraysWithSumClosestToK.find(array, 15);
        ConsoleWriter.printBooleanArray(mark);
        boolean[] expected = new boolean[]{true, true, false, true, false, false, false, false, false, false};
        for(int i = 0; i < expected.length; i++){
            assertEquals(expected[i], mark[i]);
        }
    }
}