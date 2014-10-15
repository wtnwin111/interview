package com.interview.algorithms.array;

import junit.framework.TestCase;

public class C4_63_YangMatrixSearchingTest extends TestCase {

    public void testcase() throws Exception {
        int[][] matrix = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        assertTrue(C4_63_YangMatrixSearching.exist(matrix, 6));
        assertFalse(C4_63_YangMatrixSearching.exist(matrix,5));
    }
}