package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-18
 * Time: 下午11:18
 */
public class C4_29_MaxSubArraySumTest extends TestCase {

    public void testcase1() throws Exception {
        int[] array = new int[] {1, -2, 3, 10, -4, 7, 2, -5};
        int sum = C4_29_MaxSubArraySum.max(array);
        assertEquals(18, sum);
    }
}
