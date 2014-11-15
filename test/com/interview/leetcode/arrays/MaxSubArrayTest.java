package com.interview.leetcode.arrays;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-15
 * Time: 下午5:38
 */
public class MaxSubArrayTest extends TestCase {
    public void testMaxProduct() throws Exception {
        int[] array = new int[]{7,-2,-4};
        assertEquals(12, MaxSubArray.maxProduct(array));
    }
}
